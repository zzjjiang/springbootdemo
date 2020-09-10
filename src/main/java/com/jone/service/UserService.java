package com.jone.service;

import com.jone.controller.vo.PageVO;
import com.jone.controller.vo.UserQueryVO;
import com.jone.controller.vo.UserVO;
import com.jone.model.User;

import java.util.List;

public interface UserService {

    public User save(User t);

    public PageVO<UserVO> findList(int page, int pageSize, String sql, String parms);;

    public User findById(String id);

    public boolean nameUnique(String id, String name);

    public User login(String username, String password);

    public boolean deleteById(String modelId);
}
