package com.jk.mapper;

import com.jk.bean.Goods;
import com.jk.bean.MallAttr;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface GoodsMapepr {



    List<MallAttr> getQueryGoods(MallAttr m);

    void addGoods(Goods goods);
}
