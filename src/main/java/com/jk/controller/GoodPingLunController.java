package com.jk.controller;

import com.jk.bean.Groud;
import com.jk.bean.PingLun;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.service.PingLunService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("pingLun")
public class GoodPingLunController {

    @Resource
    private PingLunService pingLunService;

    @RequestMapping("queryPingLun")
    @ResponseBody
    public SendPage queryPingLun(PingLun p, ReceivePage r) {

        SendPage sp = pingLunService.queryPingLun(p, r);
        return sp;

    }


    @RequestMapping("updatePinglun")
    @ResponseBody
    public String addPingLun(Integer id) {

        pingLunService.updatePingLun(id);
        return "1";
    }

    @RequestMapping("updateTongguo")
    @ResponseBody
    public String updateTongguo(Integer id) {

        pingLunService.updateTongguo(id);
        return "1";
    }


    @RequestMapping("deletePingLun")
    @ResponseBody
    public String deletePingLun(Integer id) {

        pingLunService.deletePingLun(id);
        return "1";
    }

    @RequestMapping("queryTop")
    @ResponseBody
    public SendPage queryTop(Groud g, ReceivePage r) {

        SendPage sp = pingLunService.queryTop(g, r);
        return sp;

    }

    @RequestMapping("addGroud")
    @ResponseBody
    public Boolean addGroud(Groud groud) {

        try {
            if (groud.getGroudId() == null) {

                pingLunService.addGroud(groud);
            } else {
                pingLunService.updateGroud(groud);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @RequestMapping("deleteGroudByIds")
    @ResponseBody
    public Boolean deleteGroudByIds(String[] ids) {

        try {
            pingLunService.deleteGroudByIds(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("queryTopId")
    @ResponseBody
    public Groud queryTopId(Integer groudId) {

        return pingLunService.queryTopId(groudId);
    }
}