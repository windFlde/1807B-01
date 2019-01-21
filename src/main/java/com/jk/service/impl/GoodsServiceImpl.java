package com.jk.service.impl;

import com.jk.bean.Goods;
import com.jk.mapper.GoodsMapepr;
import com.jk.service.GoodsService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsService{


    @Autowired
    GoodsMapepr goodsMapper;



    @Override
    public Object getGoodsQuery(int page, int rows, Goods model) {


//总条数
        long totalCount = goodsMapper.getqueryTotal(model);
//				当前页数据————————oracle分页   关键字 rownum    两个参数：起始位置、结束位置
//				起始位置 =（当前页-1）*每页条数
        int start = (page-1)*rows;
//				结束位置 = 起始位置+每页条数
        int end = start + rows;
//				查询当前页数据
        List<Goods> shares = goodsMapper.getqueryPage(start,end,model);

        JSONObject json = new JSONObject();

        try {
            json.put("toatal",totalCount);
            json.put("rows",shares);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }
}
