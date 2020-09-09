package com.jone.controller;

import com.jone.controller.vo.AddUserVO;
import com.jone.controller.vo.UserVO;
import com.jone.model.User;
import com.jone.service.UserService;
import com.jone.util.FastUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zzj
 * @description
 * @date 2020.09.09
 */
@Api(tags="用户测试")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getUser")
    @ApiOperation("获取用户信息")
    public User getUser(){
        User user = new User();
        user.setUserName("test");
        user.setRealName("testReal");
        user.setPhone("13148733577");
        return user;
    }

    @PostMapping("save")
    @ApiOperation("获取用户信息")
    public User save(@RequestBody AddUserVO userVO){
        User user = FastUtils.convert(userVO, User.class);
        return userService.save(user);
    }

    @GetMapping("getUserById")
    @ApiOperation("根据ID获取用户信息")
    public UserVO getUserById(@ApiParam("用户ID") @RequestParam String id){
        User user = userService.findById(id);
        return FastUtils.convert(user,UserVO.class);
    }

    @GetMapping("getUserList")
    @ApiOperation("获取用户信息列表")
    public List<UserVO> getUserList(){
        List<User> users = userService.findList(null);
        return FastUtils.convert(users,UserVO.class);
    }

    @GetMapping("nameUnique")
    @ApiOperation("根据ID获取用户信息")
    public boolean nameUnique(@ApiParam("用户ID") @RequestParam(required = false) String id,
                           @ApiParam(value = "用户姓名") @RequestParam String name){
        return userService.nameUnique(id,name);
    }
}
