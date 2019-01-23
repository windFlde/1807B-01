package com.jk.mapper;

import com.jk.bean.MallAttr;
import com.jk.bean.MallValue;
import com.jk.bean.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodssxMapper {

    List<MallAttr> getGoodsSx(MallAttr mallAttr);

    List<MallValue> getMallValues(Integer id);

    void batchadd(List<MallValue> value);

    void addGoodssx(@Param("shxm") String shxm, @Param("pid") Integer pid);

    void addAttr_value(@Param("mallValue") MallValue mallValue, @Param("pid")Integer pid);
}
