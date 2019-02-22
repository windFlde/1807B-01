package com.jk.mapper;

import com.jk.bean.Echarts;
import com.jk.bean.Groud;

import java.util.List;

public interface EchartsMapper {

    List<Echarts> queryEcharts();

    List<Echarts> queryEcharts2();

    void importq(Groud groud);

    List<Groud> exportq(String[] id);
}
