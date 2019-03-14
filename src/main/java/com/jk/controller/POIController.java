package com.jk.controller;

import com.jk.bean.MallAttr;
import com.jk.service.GoodsService;
import com.jk.utils.ExportExcel;
import com.jk.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("poi")
public class POIController {

    @Autowired
    private GoodsService goodsService;

    @ResponseBody
    @RequestMapping("impxls")
    public ResponseEntity<byte[]> impxls(@RequestParam("id[]") String[] id) {
        String sheetName="商品列表";
        String titleName="我的列表";
        String[] headers = { "商品ID", "商品名称", "商品图片", "分类编号1" ,"分类编号2","品牌id","创建时间","商品描述"};
        List<MallAttr> goods = goodsService.getGoods();
        String replace = UUID.randomUUID().toString().replace("-", "");

        String fileDir = "E:\\poi\\";

        File file = new File(fileDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        String randomPath = fileDir + replace+".xls";

        String pattern = "yyyy-MM-dd";
        ExportExcel.exportExcel(sheetName, titleName, headers, goods, randomPath, pattern);

        return FileUtil.FileDownload(randomPath,"fileName.xls");

    }
}
