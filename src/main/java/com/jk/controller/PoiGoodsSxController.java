package com.jk.controller;

import com.jk.bean.MallAttr;
import com.jk.service.PoiGoodsSxService;
import com.jk.utils.ExportExcel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("poiGoodsSx")
public class PoiGoodsSxController {

    @Resource
    private PoiGoodsSxService poiGoodsSxService;

    //poi导出
    @ResponseBody
    @RequestMapping("save")
    public String save(@RequestParam("id[]") String[] id) throws Exception {
        String sheetName = "商品属性";
        String titleName = "我的列表";
        String[] headers = {"属性ID", "属性名称", "是否启用", "属性值", "创建时间"};
        List<MallAttr> dataSet = poiGoodsSxService.saveMallAttr(id);
        String resultUrl = "C:\\Users\\XUEJJIAWEI\\Desktop\\mallAttr.xlsx";
        String pattern = "yyyy-MM-dd";
        ExportExcel.exportExcel(sheetName, titleName, headers, dataSet, resultUrl, pattern);
        return "success";
    }


}
