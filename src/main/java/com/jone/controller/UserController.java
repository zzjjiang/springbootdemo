package com.jone.controller;

import com.jone.controller.vo.AddUserVO;
import com.jone.controller.vo.PageVO;
import com.jone.controller.vo.TreeVO;
import com.jone.controller.vo.UserVO;
import com.jone.exception.BizException;
import com.jone.model.User;
import com.jone.service.UserService;
import com.jone.util.FastUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zzj
 * @description
 * @date 2020.09.09
 */
@Api(tags = "用户测试")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getUser")
    @ResponseBody
    @ApiOperation("获取用户信息")
    public User getUser() {
        User user = new User();
        user.setUserName("test");
        user.setRealName("testReal");
        user.setPhone("13148733577");
        return user;
    }

    @PostMapping("save")
    @ResponseBody
    @ApiOperation("获取用户信息")
    public String save(@ModelAttribute AddUserVO userVO) {
        User user = FastUtils.convert(userVO, User.class);
        User save = userService.save(user);
        if (save != null) {
            return "1";
        }
        return "-1";
    }

    @GetMapping("userManger")
    public String userManger() {
        return "user/userManager";
    }

    @GetMapping("findById")
    public ModelAndView getUserById(String modelId) {
        ModelAndView mav = new ModelAndView("user/addEditUser");
        if(!StringUtils.isEmpty(modelId)) {
            User user = userService.findById(modelId);
            UserVO userVO = FastUtils.convert(user, UserVO.class);
            mav.addObject("obj",userVO);
        }
        return mav;
    }

    @GetMapping("findList")
    @ResponseBody
    @ApiOperation("获取用户信息列表")
    public PageVO<UserVO> getUserList(HttpServletRequest request) {
        String page = request.getParameter("page");
        String pageSize = request.getParameter("limit");
        //关键字
        String keyname = request.getParameter("keyName");

        StringBuilder sqlBf = new StringBuilder();
        if (!StringUtils.isEmpty(keyname)) {
            sqlBf.append(" and (user_name like '%").append(keyname).append("%' ");
            sqlBf.append(" or real_name like '%").append(keyname).append("%' )");
        }
        return userService.findList(Integer.parseInt(page),
                Integer.parseInt(pageSize), sqlBf.toString(), null);
    }


    @PostMapping("deleteById")
    @ResponseBody
    public String deleteById(String modelId) {
        if(StringUtils.isEmpty(modelId)){
            throw new BizException("modelId 不能为空");
        }
        boolean isDel = userService.deleteById(modelId);
        if(isDel){
            return "1";
        }
        return "-1";
    }


    @GetMapping("nameUnique")
    @ResponseBody
    @ApiOperation("根据ID获取用户信息")
    public boolean nameUnique(@ApiParam("用户ID") @RequestParam(required = false) String id,
                              @ApiParam(value = "用户姓名") @RequestParam String name) {
        return userService.nameUnique(id, name);
    }

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @PostMapping("login")
    @ResponseBody
    public String login(String username, String password, HttpSession session) {
        if (username != null && password != null) {
            User loginUser = userService.login(username, password);
            if (loginUser != null) {
                session.setAttribute("userInfo",loginUser);
                return "1";
            } else {
                // 用户名或密码错误
                return "-2";
            }
        }
        return "-1";
    }

    @GetMapping("loginOut")
    public String loginOut(HttpSession session) {
        User user = (User) session.getAttribute("userInfo");
        if (user != null) {
            session.invalidate();
        }
        return "index";
    }

    @GetMapping("main")
    public ModelAndView main(HttpSession session) {
        ModelAndView mav = new ModelAndView("main");
        User user = (User) session.getAttribute("userInfo");
        mav.addObject("obj",user);
        return mav;
    }

    @GetMapping("welcome")
    public ModelAndView welcome(HttpSession session) {
        ModelAndView mav = new ModelAndView("welcome");
        User user = (User) session.getAttribute("userInfo");
        mav.addObject("obj",user);
        return mav;
    }

    @GetMapping("leftMenus")
    @ResponseBody
    public PageVO<TreeVO> leftMenus() {
        PageVO<TreeVO> pageVO = new PageVO<>();
        pageVO.setCode(200);
        List<TreeVO> menus = new ArrayList<>();
        TreeVO treeVO = new TreeVO();
        treeVO.setId("12345678");
        treeVO.setHref("userManger");
        treeVO.setTitle("用户管理");
        treeVO.setIcon("&#xe770;");
        treeVO.setIsTab(0);
        menus.add(treeVO);
        pageVO.setData(menus);
        return pageVO;
    }

    @GetMapping("testException")
    @ResponseBody
    public String testException(String modelId){
        if(StringUtils.isEmpty(modelId)){
            throw new BizException("modelId 不能为空");
        }
        return "1";
    }
}
