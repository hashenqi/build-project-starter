package com.czy.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.czy.study.core.GlobalException;
import com.czy.study.core.ResponseVo;
import com.czy.study.core.UserContent;
import com.czy.study.core.UserLoginHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/aa")
    public ResponseVo aa(String name)  {
        UserContent userContent = UserLoginHandler.get();
        log.info(JSONObject.toJSONString(userContent));
        if (true) {
            throw new GlobalException(1001,"运算错误");
        }

        return ResponseVo.success();
    }
}
