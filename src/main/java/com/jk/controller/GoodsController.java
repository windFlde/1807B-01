package com.jk.controller;

import com.jk.bean.Goods;
import com.jk.bean.MallAttr;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @program: boot_demo
 * @description:
 * @author: Mr.Xue
 * @create: 2019-01-21 11:16
 **/
@Controller
@RequestMapping("goods")
public class GoodsController {



    @Autowired
    GoodsService goodsService;


    @RequestMapping("toView")
    public String toView(String viewName){

        return viewName;
    }


    /*

        商品的查询
    *
    * */

    @ResponseBody
    @RequestMapping("getQueryGoods")
    public SendPage getQueryGoods(ReceivePage r, MallAttr m) {
        SendPage sp=goodsService.getQueryGoods(r,m);
        return sp;
    }









}
