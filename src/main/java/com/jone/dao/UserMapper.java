package com.jone.dao;

import com.jone.controller.vo.Page;
import com.jone.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public int save(User t);

    public int update(User t);

    public List<User> findList(Page page);

    public int count(@Param("tmpSql") String tmpSql);

    public User findById(@Param("id") String id);

    public int nameUnique(@Param("id") String id, @Param("name") String name);

    public User login(String userName, String password);

    public int deleteById(@Param("id") String modelId);
}
