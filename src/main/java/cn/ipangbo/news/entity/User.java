package cn.ipangbo.news.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class User {
    private Integer userId;   //主键,自增id
    private String userName;  //账号
    private String userPass;  //密码
    private String userNickname;  //昵称
    private String userEmail;  //邮箱
    private String userUrl;  //用户网址
    private String userAvatar;   //头像图片地址
    private String userLastLoginIp;  //最后登录的ip地址
    private LocalDateTime userRegisterTime;  //注册时间
    private LocalDateTime userLastLoginTime; //最后登录时间
    private Integer userStatus;  //用户状态
}
