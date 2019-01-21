package com.jk.service;

import com.jk.bean.*;

import java.util.List;

public interface GoodKcService {

    List<MallAttr> getSx(String id);

    List<MallValue> getValue(Integer id);

    SendPage getkucun(MallSku t, ReceivePage receivePage);
}
