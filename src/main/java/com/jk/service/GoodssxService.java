package com.jk.service;

import com.jk.bean.*;

public interface GoodssxService {

    SendPage getGoodsSx(MallAttr m,ReceivePage r);

    void batchadd(ValueBean valueBean);

    void addGoodssx(QueryParam queryParam);
}
