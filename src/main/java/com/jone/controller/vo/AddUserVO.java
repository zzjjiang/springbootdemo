package com.jone.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zzj
 * @description
 * @date 2020.09.09
 */
@Data
@ApiModel("新增用户")
public class AddUserVO {

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("真实姓名")
    private String realName;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("性别:1女2男")
    private Integer sex;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机")
    private String phone;

    @ApiModelProperty("用户状态 用户状态(0启动1锁定2停用)")
    private Integer userStatus;

    @ApiModelProperty("说明")
    private String note;

    @ApiModelProperty("创建时间")
    private String createDate;
}
