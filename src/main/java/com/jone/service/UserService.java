package com.jone.service;

import com.jone.model.User;

import java.util.List;

public interface UserService {

    public User save(User t);

    public List<User> findList(String sql);

    public User findById(String id);

    public boolean nameUnique(String id, String name);
}
