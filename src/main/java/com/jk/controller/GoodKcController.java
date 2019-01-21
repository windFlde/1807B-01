package com.jk.controller;

import com.jk.bean.Goods;
import com.jk.bean.MallAttr;
import com.jk.bean.MallSku;
import com.jk.bean.MallValue;
import com.jk.service.GoodKcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("kc")
public class GoodKcController {

    @Autowired
    private GoodKcService goodKcService;

    @ResponseBody
    @RequestMapping("getSx")
    public List<MallAttr> getSx (String id){

        return goodKcService.getSx(id);
    }

    @ResponseBody
    @RequestMapping("getValue")
    public List<MallValue> getValue(String id){

        return goodKcService.getValue(id);
    }

    @ResponseBody
    @RequestMapping("addSku")
    public String addSku(MallSku mallSku){
        goodKcService.addSku(mallSku);
        return "1";


    }

    @ResponseBody
    @RequestMapping("getGoodName")
    public List<Goods> getGoodName(String id) {
        return goodKcService.getGoodName(id);
    }
}
