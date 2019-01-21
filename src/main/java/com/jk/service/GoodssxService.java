package com.jk.service;

import com.jk.bean.*;

import java.util.List;

public interface GoodssxService {

    SendPage getGoodsSx(ReceivePage r, MallAttr m);


    void batchadd(ValueBean valueBean);
}
