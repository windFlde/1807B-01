package com.jk.mapper;

import com.jk.bean.MallAttr;
import com.jk.bean.MallValue;

import java.util.List;

public interface GoodssxMapper {

    List<MallAttr> getGoodsSx(MallAttr m);


    void batchadd(List<MallValue> value);
}
