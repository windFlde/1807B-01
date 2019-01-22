package com.jk.mapper;

import com.jk.bean.MallAttr;
import com.jk.bean.MallValue;
import com.jk.bean.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodssxMapper {

    List<MallAttr> getGoodsSx(MallAttr m);

    List<MallValue> getMallValues(Integer id);

    void batchadd(List<MallValue> value);

    void addGoodssx(QueryParam queryParam);

    void addAttr_value(MallAttr mallAttr, Integer id);
}
