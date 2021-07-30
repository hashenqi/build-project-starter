package com.czy.study.core;

import lombok.Data;

@Data
public class GlobalException extends RuntimeException {

    private Integer code;
    private String message;


    public GlobalException(Integer code,String message){
        super(message);
        this.code = code;
        this.message = message;
    }

    public GlobalException(Integer code,String message,Throwable e) {
        super(message,e);
        this.code = code;
        this.message = message;
    }

}
