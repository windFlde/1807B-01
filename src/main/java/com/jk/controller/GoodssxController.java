package com.jk.controller;

import com.jk.bean.*;
import com.jk.service.GoodssxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("goodssx")
public class GoodssxController {

    @Resource
    private GoodssxService goodssxService;

    @ResponseBody
    @RequestMapping("getGoodsSx")
    public SendPage getGoodsSx(MallAttr m,ReceivePage r) {
        SendPage sp=goodssxService.getGoodsSx(m,r);
        return sp;
    }


    @RequestMapping("batchadd")
    public String batchadd(ValueBean valueBean) {

        goodssxService.batchadd(valueBean);

        return  "index";
    }
    @RequestMapping("addGoodssx")
    public String addGoodssx(QueryParam queryParam) {

        goodssxService.addGoodssx(queryParam);

        return  "mallGoodssx";
    }

    @RequestMapping("toAddGoodssx")
    public String toAddGoodssx(String pid, Model model) {
        model.addAttribute("pid",pid);
        return "addGoodssx";
    }

}
