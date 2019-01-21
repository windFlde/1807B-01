package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.MallAttr;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.MallValue;
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
        if(r!=null){
            System.out.println(r.getPage());
            System.out.println(r.getRows());
        }

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

//    @Override
//    public List<MallAttr> getShuValue(MallAttr m) {
//        List<MallAttr> list = goodssxMapper.getGoodsSx(m);
//        System.out.println(list);
//        for (MallAttr mallAttr : list) {
//            String mm="";
//            List<MallValue>   mv=goodssxMapper.getMallValues(mallAttr.getId());
//                for (MallValue value : mv) {
//                        mm+=value.getShxzh()+value.getShxzh_mch()+"    ";
//                }
//            mallAttr.setShxzh(mm);
//        }
//        return list;
//    }

}
