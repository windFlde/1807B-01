package com.jk.controller;

import com.jk.bean.Goods;
import com.jk.bean.MallAttr;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.service.GoodsService;
import com.jk.utils.ExportExcel;
import com.jk.utils.OssUpFileUtil;
import com.jk.utils.importExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @program: boot_demo
 * @description:
 * @author: Mr.Xue
 * @create: 2019-01-21 11:16
 **/
@Controller
@RequestMapping("goods")
public class GoodsController {



    @Autowired
    GoodsService goodsService;



    @RequestMapping("toView")
    public String toView(String viewName)   {
        return viewName;
    }

    /*
    * 商品的查询
    * */
    @ResponseBody
    @RequestMapping("getQueryGoods")
    public SendPage getQueryGoods(ReceivePage r, MallAttr m) {
        SendPage sp=goodsService.getQueryGoods(r,m);
        return sp;
    }

    /**
     * 新增图片
     */
    String filename = "";
   @ResponseBody
    @PostMapping("toUploadBlog")
    public String toUploadBlog(@RequestParam("file") MultipartFile file){
        Map<String, Object> stringObjectMap = OssUpFileUtil.uploadFile(file);
       System.out.println(stringObjectMap);
        String count = "";
        for (String key : stringObjectMap.keySet()) {
           Object o = stringObjectMap.get(key);
            System.out.println("key: " + key + " value: " + o);
           if(key=="url"){
                count+=o;
                filename = count;
           }
        }
        return count;
   }
    /*
       商品新增
    */
    @ResponseBody
    @RequestMapping("addGoods")
    public String addGoods(Goods goods){
        goods.setChjshj(new Date());
        goodsService.addGoods(goods);
        return "";
    }


    //poi导出 throws Exception
    @ResponseBody
    @RequestMapping("daochu")
    public String daochu(@RequestParam("id[]") String[] id){
        String sheetName="商品列表";
        String titleName="我的列表";
        String[] headers = { "商品ID", "商品名称", "商品图片", "分类编号1" ,"分类编号2","品牌id","创建时间","商品描述"};
        List<Goods> dataSet = goodsService.daochu(id);
        String resultUrl="D:\\googds.xls";
        String pattern="yyyy-MM-dd";
        ExportExcel.exportExcel(sheetName, titleName, headers, dataSet, resultUrl, pattern);
        return "success";
    }
    //poi导入
    @ResponseBody
    @RequestMapping("daoru")
    public String daoru() throws Exception{
        String originUrl="D:\\googds.xls";
        int startRow=2;
        int endRow=0;
        List<Goods> bookList = (List<Goods>) importExcel.importExcel(originUrl, startRow, endRow, Goods.class);
        for (Goods book : bookList) {
            book.setId(null);
            goodsService.daoru(book);
        }
        return "1";
    }
}
