package com.jk.mapper;

import com.jk.bean.Goods;

import java.util.List;

public interface GoodsMapepr {


    long getqueryTotal(Goods model);

    List<Goods> getqueryPage(int start, int end, Goods model);



}
