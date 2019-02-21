package com.jk.service;

import com.jk.bean.Goods;
import com.jk.bean.MallAttr;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import java.util.List;

public interface GoodsService {


    SendPage getQueryGoods(ReceivePage r, MallAttr m);

    void addGoods(Goods goods);

    List<Goods> daochu(@Param("id") String[] id);

    void daoru(Goods book);

    List<MallAttr> getGoods();
}
