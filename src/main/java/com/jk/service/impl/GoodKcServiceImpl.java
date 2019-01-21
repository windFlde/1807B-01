package com.jk.service.impl;

import com.jk.bean.Goods;
import com.jk.bean.MallAttr;
import com.jk.bean.MallSku;
import com.jk.bean.MallValue;
import com.jk.mapper.GoodKcMapper;
import com.jk.service.GoodKcService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodKcServiceImpl implements GoodKcService {

    @Resource
    private GoodKcMapper goodKcMapper;

    @Override
    public List<MallAttr> getSx(String id) {
        return goodKcMapper.getSx(id);
    }

    @Override
    public List<MallValue> getValue(String id) {
        return goodKcMapper.getValue(id);
    }

    @Override
    public void addSku(MallSku mallSku) {
        goodKcMapper.addSku(mallSku);
    }


    @Override
    public List<Goods> getGoodName(String id) {
        return goodKcMapper.getGoodName(id);
    }

}
