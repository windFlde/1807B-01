package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.*;
import com.jk.mapper.PingLunMpper;
import com.jk.service.PingLunService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PingLunServiceImpl implements PingLunService {

    @Resource
    private PingLunMpper pingLunMpper;

    @Override
    public SendPage queryPingLun(PingLun p, ReceivePage r) {

        List<PingLun> count = pingLunMpper.queryPingLun(p);
        PageHelper.startPage(r.getPage(),r.getRows());
        List<PingLun> list = pingLunMpper.queryPingLun(p);
        SendPage ss = new SendPage(count.size(), list);
        return ss;
    }


    @Override
    public void updatePingLun(PingLun pingLun) {
        pingLunMpper.updatePingLun(pingLun);
    }



    @Override
    public void deletePingLun(Integer id) {
        pingLunMpper.pingLunMpper(id);
    }

    @Override
    public SendPage queryTop(Groud g, ReceivePage r) {

        List<Groud> count = pingLunMpper.queryTop(g);

        PageHelper.startPage(r.getPage(),r.getRows());

        List<Groud> list = pingLunMpper.queryTop(g);

        SendPage ss = new SendPage(count.size(), list);
        return ss;
    }

    @Override
    public void addGroud(Groud groud) {
        pingLunMpper.addGroud(groud);
    }

    @Override
    public void updateGroud(Groud groud) {
        pingLunMpper.updateGroud(groud);
    }

    @Override
    public void deleteGroudByIds(String[] ids) {
        pingLunMpper.deleteGroudByIds(ids);
    }

    @Override
    public Groud queryTopId(Integer groudId) {
        return pingLunMpper.queryTopId(groudId);
    }

   /* @Override
    public List<PingLun> getAllPingLun(String id) {
        return pingLunMpper.getAllPingLun(id);
    }*/

    @Override
    public List<Goods> queryGoods(Integer pp_id) {
        return pingLunMpper.queryGoods(pp_id);
    }

    @Override
    public List<PingLun> getAllPingLun(String[] id) {
        return pingLunMpper.getAllPingLun(id);
    }
}
