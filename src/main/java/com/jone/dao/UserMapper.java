package com.jone.dao;

import com.jone.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public int save(User t);

    public int update(User t);

    public List<User> findList(String sql);

    public int count(@Param("tmpSql") String tmpSql);

    public User findById(@Param("id") String id);

    public int nameUnique(@Param("id") String id, @Param("name") String name);

}
