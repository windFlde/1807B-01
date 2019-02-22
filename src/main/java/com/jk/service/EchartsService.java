package com.jk.service;

import com.jk.bean.Echarts;
import com.jk.bean.Groud;

import java.util.List;

public interface EchartsService {


    List<Echarts> queryEcharts();

    List<Echarts> queryEcharts2();

    void importq(Groud groud);


    List<Groud> exportq(String [] id);
}
