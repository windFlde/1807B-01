package com.jk.service;

import com.jk.bean.MallAttr;
import com.jk.bean.MallValue;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;

import java.util.List;

public interface GoodssxService {

    SendPage getGoodsSx(MallAttr m,ReceivePage r);

//    List<MallAttr> getShuValue(MallAttr m);
}
