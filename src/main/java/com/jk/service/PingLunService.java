package com.jk.service;

import com.jk.bean.*;

import java.util.List;


public interface PingLunService {


    SendPage queryPingLun(PingLun p, ReceivePage r);


    void updatePingLun(PingLun pingLun);

    void updateTongguo(Integer id);

    void deletePingLun(Integer id);

    SendPage queryTop(Groud g, ReceivePage r);

    void addGroud(Groud groud);

    void updateGroud(Groud groud);

    void deleteGroudByIds(String[] ids);

    Groud queryTopId(Integer groudId);


    List<PingLun> getAllPingLun(String id);
}
