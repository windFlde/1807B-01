package com.jk.service.impl;

import com.jk.bean.MallAttr;
import com.jk.mapper.PoiGoodsSxMapper;
import com.jk.service.PoiGoodsSxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PoiGoodsSxServiceImpl implements PoiGoodsSxService {

    @Resource
    private PoiGoodsSxMapper poiGoodsSxMapper;


    @Override
    public List<MallAttr> saveMallAttr(String[] id) {
        return poiGoodsSxMapper.saveMallAttr(id);
    }
}
