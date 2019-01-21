package com.jk.controller;

import com.jk.bean.MallAttr;
import com.jk.bean.MallValue;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.service.GoodssxService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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

//    @ResponseBody
//    @RequestMapping("getShuValue")
//    public List<MallAttr> getShuValue(MallAttr m) {
//
//        return goodssxService.getShuValue(m);
//    }

}
