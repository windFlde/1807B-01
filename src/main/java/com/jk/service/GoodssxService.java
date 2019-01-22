package com.jk.service;

import com.jk.bean.MallAttr;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.ValueBean;

public interface GoodssxService {

    SendPage getGoodsSx(MallAttr m,ReceivePage r);

    void batchadd(ValueBean valueBean);

//    List<MallAttr> getShuValue(MallAttr m);
}
