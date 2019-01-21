package com.jk.controller;

import com.jk.bean.MallAttr;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.ValueBean;
import com.jk.service.GoodssxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("goodssx")
public class GoodssxController {

    @Autowired
    private GoodssxService goodssxService;

    @ResponseBody
    @RequestMapping("getGoodsSx")
    public SendPage getGoodsSx(ReceivePage r, MallAttr m) {
        SendPage sp=goodssxService.getGoodsSx(r,m);
        return sp;
    }

    @RequestMapping("batchadd")
    public String batchadd(ValueBean valueBean) {

        goodssxService.batchadd(valueBean);

        return "goodssx";
    }

}
