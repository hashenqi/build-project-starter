package com.czy.study.core;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class  ResponseVo<T> {

    private Integer code;

    private String msg;

    private T data;

    public static<T> ResponseVo<T> success(T data){
        return new ResponseVo<T>(200,"成功",data);
    }

    public static ResponseVo success(){
        return new ResponseVo(200,"成功",null);
    }

    public static ResponseVo fail(){
        return new ResponseVo(500,"内部服务错误",null);
    }

}
