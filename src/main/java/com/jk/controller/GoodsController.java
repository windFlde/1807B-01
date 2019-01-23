package com.jk.controller;

import com.jk.bean.Goods;
import com.jk.bean.MallAttr;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.service.GoodsService;
import com.jk.utils.OssUpFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
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
    public String toView(String viewName){
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
}
