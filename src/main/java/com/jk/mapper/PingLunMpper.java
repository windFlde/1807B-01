package com.jk.mapper;

import com.jk.bean.Groud;
import com.jk.bean.PingLun;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PingLunMpper {


    List<PingLun> queryPingLun(PingLun p);


    void updatePingLun(PingLun pingLun);

    void updateTongguo(Integer id);

    void pingLunMpper(Integer id);

    List<Groud> queryTop(Groud g);

    void addGroud(Groud groud);

    void updateGroud(Groud groud);

    void deleteGroudByIds(String[] ids);

    Groud queryTopId(Integer groudId);

    List<PingLun> getAllPingLun(@Param("id") String id);
}
