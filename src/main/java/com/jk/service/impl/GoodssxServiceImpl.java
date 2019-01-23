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
    public SendPage getGoodsSx(MallAttr m,ReceivePage r) {

        List<MallAttr> count = goodssxMapper.getGoodsSx(m);
        PageHelper.startPage(r.getPage(),r.getRows());
        List<MallAttr> list = goodssxMapper.getGoodsSx(m);
        for (MallAttr mallAttr : list) {
            String mm="";
            List<MallValue>   mv=goodssxMapper.getMallValues(mallAttr.getId());
            for (MallValue value : mv) {
                mm+=value.getShxzh()+value.getShxzh_mch()+"    ";
            }
            mallAttr.setShxzh(mm);
        }
        SendPage ss = new SendPage(count.size(), list);
        return ss;
    }

    @Override
    public void batchadd(ValueBean valueBean) {
        goodssxMapper.batchadd(valueBean.getValue());
    }

    @Override
    public void addGoodssx(QueryParam queryParam) {
        goodssxMapper.addGoodssx(queryParam);
        List<MallValue> attr_value = queryParam.getAttr_value();
        for (MallValue mallAttr : attr_value) {
            if(mallAttr.getShxzh()!=null){
                goodssxMapper.addAttr_value(mallAttr,queryParam.getId());
            }
        }

    }


}
