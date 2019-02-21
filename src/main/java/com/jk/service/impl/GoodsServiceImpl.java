package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.Goods;
import com.jk.bean.MallAttr;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.mapper.GoodsMapepr;
import com.jk.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsService{


    @Resource
    GoodsMapepr goodsMapper;


    @Override
    public SendPage getQueryGoods(ReceivePage r, MallAttr m) {
        List<MallAttr> count = goodsMapper.getQueryGoods(m);
        PageHelper.startPage(r.getPage(),r.getRows());
        List<MallAttr> list = goodsMapper.getQueryGoods(m);
        SendPage ss = new SendPage(count.size(), list);
        return ss;
    }

    @Override
    public void addGoods(Goods goods) {

        goodsMapper.addGoods(goods);
    }

    @Override
    public List<MallAttr> getGoods() {
        MallAttr m = new MallAttr();
        return goodsMapper.getQueryGoods(m);
    }

    @Override
    public List<Goods> daochu(String[] id) {
        return  goodsMapper.daochu(id);
    }

    @Override
    public void daoru(Goods book) {
        goodsMapper.daoru(book);
    }
}
