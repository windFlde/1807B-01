package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.*;
import com.jk.mapper.GoodKcMapper;
import com.jk.service.GoodKcService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.print.Book;
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
    public List<MallValue> getValue(Integer id) {
        return goodKcMapper.getValue(id);
    }

    @Override
    public SendPage getkucun(MallSku t, ReceivePage receivePage) {
        List <MallSku> sum=goodKcMapper.getkucuns(t);
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List <MallSku> list=goodKcMapper.getkucuns(t); //当前页面数据 其大小取决于 每页多少条
        SendPage sendPage = new SendPage(sum.size(),list);
        return sendPage;

    }
}
