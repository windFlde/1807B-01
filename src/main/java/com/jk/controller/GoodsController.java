package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @program: boot_demo
 * @description:
 * @author: Mr.Xue
 * @create: 2019-01-21 11:16
 **/
@Controller
@RequestMapping("goods")
public class GoodsController {

    @RequestMapping("toView")
    public String toView(String viewName){

        return viewName;
    }

}
