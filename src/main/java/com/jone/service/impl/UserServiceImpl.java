package com.jone.service.impl;

import com.jone.dao.UserMapper;
import com.jone.model.User;
import com.jone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author zzj
 * @description
 * @date 2020.09.09
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User save(User user) {
        int i;
        if(StringUtils.isEmpty(user.getId())){
            i = userMapper.save(user);
        }else{
            i = userMapper.update(user);
        }
        if(i > 0){
            return user;
        }
        return null;
    }

    @Override
    public List<User> findList(String sql) {
        return userMapper.findList(sql);
    }

    @Override
    public User findById(String id) {
        return userMapper.findById(id);
    }

    @Override
    public boolean nameUnique(String id, String name) {
        return userMapper.nameUnique(id,name) <= 0;
    }
}
