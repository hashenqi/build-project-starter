package com.czy.study.core;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserLoginHandler {
    private final static ThreadLocal<UserContent> threadLocal = new ThreadLocal<UserContent>();

    private final static ConcurrentHashMap<String,UserContent> userMap = new ConcurrentHashMap<>();

    public static UserContent get(){
        return threadLocal.get();
    }

    public static void set(UserContent userContent){
        threadLocal.set(userContent);
    }

    public static void setUserMap(String token,UserContent userContent) {
        userMap.put(token,userContent);
    }

    public static UserContent getCurrentUser(String token){
        return userMap.get(token);
    }

    public static void remove(String token){
        threadLocal.remove();
        userMap.remove(token);
    }


}
