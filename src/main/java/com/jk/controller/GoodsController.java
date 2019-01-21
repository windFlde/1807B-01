package com.jk.controller;

import com.jk.bean.Goods;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;



/**
 * @program: boot_demo
 * @description:
 * @author: Mr.Xue
 * @create: 2019-01-21 11:16
 **/
@Controller
@RequestMapping("goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;


    @RequestMapping("toView")
    public String toView(String viewName){
        return viewName;
    }

    @ResponseBody
    @RequestMapping("addGoods")
    public String addGoods(Goods goods){
        return "";
    }

    @ResponseBody
    @RequestMapping("uploadGoods")
    public String uploadGoods(HttpServletRequest request, MultipartFile img){
        return FileUtil.upload(img, request);
    }
}
