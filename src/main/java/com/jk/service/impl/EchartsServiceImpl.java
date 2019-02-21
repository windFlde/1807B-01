package com.jk.service.impl;

import com.jk.bean.Echarts;
import com.jk.mapper.EchartsMapper;
import com.jk.service.EchartsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EchartsServiceImpl implements EchartsService {

    @Resource
    private EchartsMapper echartsMapper;

    @Override
    public List<Echarts> queryEcharts() {
        return echartsMapper.queryEcharts();
    }

    @Override
    public List<Echarts> queryEcharts2() {
        return echartsMapper.queryEcharts2();
    }
}
