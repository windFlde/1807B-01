package com.jk.controller;

import com.jk.service.GoodKcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("kc")
public class GoodKcController {

    @Autowired
    private GoodKcService goodKcService;

    @ResponseBody
    @RequestMapping("getSx")
    public String  getSx (String id){

    }
}
