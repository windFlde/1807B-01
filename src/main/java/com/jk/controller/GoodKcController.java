package com.jk.controller;

import com.jk.bean.Attr;
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
    public List<Attr> getSx (String id){

        return goodKcService.getSx(id);
    }
}
