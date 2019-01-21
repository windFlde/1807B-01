package com.jk.service.impl;

import com.jk.mapper.GoodssxMapper;
import com.jk.service.GoodssxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodssxServiceImpl implements GoodssxService {

    @Resource
    private GoodssxMapper goodssxMapper;



}
