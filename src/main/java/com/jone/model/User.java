package com.jone.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description
 * 用户
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String note;
    private Integer orderBy;
    private Integer isDelete;
    private String createDate;

    /**
     *  用户名
     */
    private String userName;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别1女2男
     */
    private Integer sex;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机
     */
    private String phone;
    /**
     * 用户状态 用户状态(0启动1锁定2停用)
     */
    private Integer userStatus;
}