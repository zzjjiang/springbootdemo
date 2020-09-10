package com.jone.service.impl;

import com.jone.controller.vo.Page;
import com.jone.controller.vo.PageVO;
import com.jone.controller.vo.UserVO;
import com.jone.dao.UserMapper;
import com.jone.model.User;
import com.jone.service.UserService;
import com.jone.util.FastUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
    public PageVO<UserVO> findList(int page, int pageSize, String sql, String parms) {
        PageVO<UserVO> result = new PageVO<>();
        result.setCode(0);
        int count = userMapper.count(sql);
        if(count > 0){
            Page param = new Page();
            param.setSql(sql);
            param.setPage((page-1)*pageSize);
            param.setPageSize(pageSize);
            List<User> list = userMapper.findList(param);
            result.setData(FastUtils.convert(list,UserVO.class));
            result.setCount(count);
        }else{
            List<UserVO> list = new ArrayList<>();
            result.setData(list);
            result.setCount(0);
        }
        return result;
    }

    @Override
    public User findById(String id) {
        return userMapper.findById(id);
    }

    @Override
    public boolean nameUnique(String id, String name) {
        return userMapper.nameUnique(id,name) <= 0;
    }

    @Override
    public User login(String userName, String password) {
        return userMapper.login(userName,password);
    }

    @Override
    public boolean deleteById(String modelId) {
        return userMapper.deleteById(modelId) > 0;
    }


}
