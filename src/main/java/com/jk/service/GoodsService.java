package com.jk.service;

import com.jk.bean.Goods;

public interface GoodsService {


    Object getGoodsQuery(int page, int rows, Goods model);
}
