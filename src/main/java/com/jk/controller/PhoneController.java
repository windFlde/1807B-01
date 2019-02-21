package com.jk.controller;

import com.jk.bean.User;
import com.jk.service.PhoneService;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("phone")
public class PhoneController {
    @Autowired
    PhoneService phoneService;
    @ResponseBody
    @RequestMapping("selectPhoneBlacklist")
    public SendPage selectPhoneBlacklist(ReceivePage receivePage){
        return phoneService.selectPhoneBlacklist(receivePage);
    }
    @RequestMapping("deletePhone")
    @ResponseBody
    public void deletePhone(String ids){
        phoneService.deletePhone(ids);
    }
    @ResponseBody
    @RequestMapping("insertPhone")
    public void insertPhone(User user){
        phoneService.insertPhone(user);
    }
    @ResponseBody
    @RequestMapping("selectByid")
    public User selectByid(User user){
        return phoneService.selectByid(user);
    }
}
