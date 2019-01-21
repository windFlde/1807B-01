package com.jk.controller;

import com.jk.bean.MallAttr;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.service.GoodssxService;
import org.springframework.stereotype.Controller;
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
    public SendPage getGoodsSx(ReceivePage r, MallAttr m) {
        SendPage sp=goodssxService.getGoodsSx(r,m);
        return sp;
    }

}
