package com.jk.controller;

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

    @RequestMapping("toView")
    public String toView(String viewName){

        return viewName;
    }



    /*

        商品的查询
    *
    * */

    @RequestMapping("getGoodsQuery")
    @ResponseBody
    public Object getGoodsQuery(int page,int rows,Goods model){
        Object json=goodsService.getGoodsQuery(page,rows,model);
        return json;
    }










}
