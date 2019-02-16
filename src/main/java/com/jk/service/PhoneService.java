package com.jk.service;

import com.jk.bean.User;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;

public interface PhoneService {
    SendPage selectPhoneBlacklist(ReceivePage receivePage);

    void deletePhone(String ids);

    void insertPhone(User user);

    User selectByid(User user);
}
