package com.jk.mapper;

import com.jk.bean.User;

import java.util.List;

public interface PhoneMapper {
    List<User> selectPhoneBlacklist();

    void deletePhone(String ids);

    void updatePhone(User user);

    void insertPhone(User user);

    User selectByid(User user);
}
