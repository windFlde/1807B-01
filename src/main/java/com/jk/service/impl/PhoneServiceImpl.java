package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.mapper.PhoneMapper;
import com.jk.service.PhoneService;
import com.jk.bean.User;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {
    @Resource
    PhoneMapper phoneMapper;

    @Override
    public SendPage selectPhoneBlacklist(ReceivePage receivePage) {
        int total=phoneMapper.selectPhoneBlacklist().size();
        PageHelper.startPage(receivePage.getPage(), receivePage.getRows());
        List<User> rows=phoneMapper.selectPhoneBlacklist();
        SendPage sp=new SendPage(total, rows);
        return sp;
    }

    @Override
    public void deletePhone(String ids) {
        phoneMapper.deletePhone(ids);
    }

    @Override
    public void insertPhone(User user) {
        if(user.getId()!=null)
            phoneMapper.updatePhone(user);
        else
            phoneMapper.insertPhone(user);
    }

    @Override
    public User selectByid(User user) {
        return phoneMapper.selectByid(user);
    }
}
