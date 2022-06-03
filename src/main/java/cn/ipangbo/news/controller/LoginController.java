package cn.ipangbo.news.controller;

import cn.ipangbo.news.entity.MessageModel;
import cn.ipangbo.news.entity.User;
import cn.ipangbo.news.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/login")
public class LoginController {
    @PostMapping("")
    public MessageModel login(@RequestBody User user) {
        if ("ipangbo".equals(user.getUserName()) && "123".equals(user.getUserPass())) {
            log.info(user.getUserName() + "登录了");
            return MessageModel.builder().status(200).token(JwtUtils.creatToken()).build();
        } else {
            return MessageModel.builder().status(401).message("登陆失败").build();
        }
    }
}
