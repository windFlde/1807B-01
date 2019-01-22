package com.jk.mapper;

import com.jk.bean.Goods;
import com.jk.bean.MallAttr;
import com.jk.bean.MallSku;
import com.jk.bean.MallValue;
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

    void addSkuAndattrAndvalue(@Param("attrVal")ArrayList<MallValue> attrVal,@Param("shp_id")Integer shp_id);


}
