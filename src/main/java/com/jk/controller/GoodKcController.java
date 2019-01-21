package com.jk.controller;

import com.jk.bean.*;
import com.jk.service.GoodKcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.Book;
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
    public List<MallValue> getValue(Integer id){

        return goodKcService.getValue(id);
    }
    //查询
    @ResponseBody
    @RequestMapping("getkucun")
    public SendPage getkucun(MallSku t, ReceivePage receivePage) {
        SendPage  sp = goodKcService.getkucun(t, receivePage);
        return sp;
    }



}
