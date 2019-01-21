package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.Goods;
import com.jk.bean.MallAttr;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.mapper.GoodsMapepr;
import com.jk.service.GoodsService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsService{


    @Autowired
    GoodsMapepr goodsMapper;


    @Override
    public SendPage getQueryGoods(ReceivePage r, MallAttr m) {

        List<MallAttr> count = goodsMapper.getQueryGoods(m);
        PageHelper.startPage(r.getPage(),r.getRows());
        List<MallAttr> list = goodsMapper.getQueryGoods(m);
        SendPage ss = new SendPage(count.size(), list);
        return ss;


    }
}
