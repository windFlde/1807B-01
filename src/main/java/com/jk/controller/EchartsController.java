package com.jk.controller;

import com.jk.bean.Echarts;
import com.jk.bean.Groud;
import com.jk.service.EchartsService;
import com.jk.utils.ExportExcel;
import com.jk.utils.importExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/ech")
public class EchartsController {

    @Autowired
    private EchartsService echartsService;

   @RequestMapping("queryEcharts")
    @ResponseBody
    public Map<String,Object> queryEcharts() {

        Map<String, Object> params = new HashMap<>();

        List<String> name = new ArrayList<>();
        List<Integer> value = new ArrayList<>();

        List<Echarts> list=echartsService.queryEcharts();

        for (Echarts echarts : list) {

            name.add(echarts.getName());
            value.add(echarts.getValue());
        }

        params.put("ename",name);
        params.put("evalue",value);
        return params;


    }

    /*@RequestMapping("queryEcharts2")
    @ResponseBody
    public  Map<String, Object> queryEcharts2() {

        Map<String, Object> params = new HashMap<>();
        List<String> name1 = new ArrayList<>();
        List<Integer> value1 = new ArrayList<>();

        List<Echarts> list1=echartsService.queryEcharts2();
        for (Echarts echarts1 : list1) {

            name1.add(echarts1.getName());
            value1.add(echarts1.getValue());

        }

        params.put("ename",name1);
        params.put("evalue",value1);

        return params;

    }*/


    @RequestMapping("importq")
    @ResponseBody
    public String importq() throws IOException {

        /////获取桌面路径
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File file = fsv.getHomeDirectory();
        //格式化时间戳
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
        String s = simpleDateFormat.format(new Date());

        String resultUrl = file.getPath() + "//" + s + ".xls";
        int startRow=2;
        int endRow=0;
        List<Groud> bookList = (List<Groud>) importExcel.importExcel(resultUrl, startRow, endRow, Groud.class);
        for (Groud groud : bookList) {

            groud.setGroudId(null);
            echartsService.importq(groud);

        }

        return "1";

    }

    @RequestMapping("exportq")
    @ResponseBody
    public String exportq(@RequestParam("id[]") String [] id) {

        String sheetName="Top列表";
        String titleName="我的列表";
        String[] headers = { "TopID", "Top名称", "Top地址"};

        /////获取桌面路径
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File file = fsv.getHomeDirectory();
        //格式化时间戳
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
        String s = simpleDateFormat.format(new Date());

        //去数据库查询要导出的数据
        List<Groud> list=echartsService.exportq(id);
        String resultUrl = file.getPath() + "//" + s + ".xls";
        String pattern = "yyyy-MM-dd";
        ExportExcel.exportExcel(sheetName,titleName,headers,list,resultUrl,pattern);

        return  "success";
    }


}
