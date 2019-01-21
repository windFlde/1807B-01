package com.jk.controller;

import com.jk.service.GoodssxService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("goodssx")
public class GoodssxController {

    @Resource
    private GoodssxService goodssxService;



}
