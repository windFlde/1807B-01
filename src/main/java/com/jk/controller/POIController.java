package com.jk.controller;

import com.jk.bean.MallAttr;
import com.jk.service.GoodsService;
import com.jk.utils.ExportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("poi")
public class POIController {

    @Autowired
    private GoodsService goodsService;

    @ResponseBody
    @RequestMapping("impxls")
    public String impxls(@RequestParam("id[]") String[] id) {
        String sheetName="商品列表";
        String titleName="我的列表";
        String[] headers = { "商品ID", "商品名称", "商品图片", "分类编号1" ,"分类编号2","品牌id","创建时间","商品描述"};
        List<MallAttr> goods = goodsService.getGoods();
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com = fsv.getHomeDirectory();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
        String format = simpleDateFormat.format(new Date());
        String resultUrl=com.getPath()+"\\"+format+".xls";
        String pattern="yyyy-MM-dd";
        ExportExcel.exportExcel(sheetName, titleName, headers, goods, resultUrl, pattern);

        return "1";
    }
}
