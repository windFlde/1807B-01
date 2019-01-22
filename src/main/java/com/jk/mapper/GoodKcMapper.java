package com.jk.mapper;

import com.jk.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface GoodKcMapper {

    List<MallAttr> getSx(String id);


    List<MallValue> getValue(Integer id);

    List<MallSku> getkucuns(MallSku t);

    List<MallValue> getValue(String id);

    void addSku(MallSku mallSku);

    List<Goods> getGoodName(String id);

    void addMallSkuAttrValue(MallSkuValue value);
}
