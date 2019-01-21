package com.jk.service;

import com.jk.bean.MallAttr;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;

public interface GoodssxService {

    SendPage getGoodsSx(ReceivePage r, MallAttr m);
}
