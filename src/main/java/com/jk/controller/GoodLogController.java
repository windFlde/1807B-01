package com.jk.controller;

import com.jk.bean.LoginLog;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("log")
public class GoodLogController {

    @Autowired
    MongoTemplate mongoTemplate;

    @ResponseBody
    @RequestMapping("getLog")
    public SendPage getLog(ReceivePage receivePage) {
        Query query = new Query();
        int total=(int) mongoTemplate.count(query, LoginLog.class);
        query.skip((receivePage.getPage()-1)*receivePage.getRows());
        query.limit(receivePage.getRows());
        List<LoginLog> rows=mongoTemplate.find(query, LoginLog.class);
        SendPage sendPage=new SendPage(total,rows);
        return sendPage;

    }


}
