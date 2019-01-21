package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.*;
import com.jk.mapper.GoodssxMapper;
import com.jk.service.GoodssxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodssxServiceImpl implements GoodssxService {

    @Resource
    private GoodssxMapper goodssxMapper;


    @Override
    public SendPage getGoodsSx(ReceivePage r, MallAttr m) {
        List<MallAttr> count = goodssxMapper.getGoodsSx(m);
        PageHelper.startPage(r.getPage(),r.getRows());
        List<MallAttr> list = goodssxMapper.getGoodsSx(m);
        SendPage ss = new SendPage(count.size(), list);
        return ss;
    }

    @Override
    public void batchadd(ValueBean valueBean) {
        goodssxMapper.batchadd(valueBean.getValue());
    }


}
