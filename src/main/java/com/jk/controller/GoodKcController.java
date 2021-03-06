package com.jk.controller;




import com.jk.bean.*;

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

    @RequestMapping("toView")
    public String toView(String viewName){

        return viewName;
    }

    @ResponseBody
    @RequestMapping("getSx")
    public List<MallAttr> getSx (String pid){

        return goodKcService.getSx(pid);
    }

    @ResponseBody
    @RequestMapping("getValue")
    public List<MallValue> getValue(String ids){

        return goodKcService.getValue(ids);
    }

    //查询
    @ResponseBody
    @RequestMapping("getkucun")
    public SendPage getkucun(MallSku t, ReceivePage receivePage) {
        SendPage  sp = goodKcService.getkucun(t, receivePage);
        return sp;
    }




    @ResponseBody
    @RequestMapping("addSku")
    public String addSku(MallSku mallSku){
        goodKcService.addSku(mallSku);
        return "1";


    }

    @ResponseBody
    @RequestMapping("getGoodName")
    public List<Goods> getGoodName(String ppid) {
        return goodKcService.getGoodName(ppid);
    }

}
