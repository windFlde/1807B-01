package com.jk.service;

import com.jk.bean.Goods;
import com.jk.bean.MallAttr;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;

import java.util.List;

public interface GoodsService {


    SendPage getQueryGoods(ReceivePage r, MallAttr m);

    void addGoods(Goods goods);

    List<MallAttr> getGoods();
}
