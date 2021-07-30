package com.czy.study.controller;

import com.czy.study.core.ResponseVo;
import com.czy.study.core.UserContent;
import com.czy.study.core.UserLoginHandler;
import com.czy.study.params.LoginReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web")
public class LoginController {

    @PostMapping("/login")
    public ResponseVo login(@RequestBody LoginReq req){
        UserContent userContent = new UserContent(req.getId(),req.getName());
        UserLoginHandler.set(userContent);
        return ResponseVo.success();
    }
}
