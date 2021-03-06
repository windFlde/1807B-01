package com.jk.service;


import com.jk.bean.*;

import com.jk.bean.Goods;
import com.jk.bean.MallAttr;
import com.jk.bean.MallSku;
import com.jk.bean.MallValue;


import java.util.List;

public interface GoodKcService {

    List<MallAttr> getSx(String id);


    List<MallValue> getValue(Integer id);

    SendPage getkucun(MallSku t, ReceivePage receivePage);

    List<MallValue> getValue(String id);

    void addSku(MallSku mallSku);

    List<Goods> getGoodName(String id);

}
