package com.jk.controller;

import com.jk.bean.Echarts;
import com.jk.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


}
