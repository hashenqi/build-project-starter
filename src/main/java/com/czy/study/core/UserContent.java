package com.czy.study.core;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserContent {
    /**
     * 当前用户ID
     */
    private Long currentUserId;
    /**
     * 当前用户名称
     */
    private String currentUserName;

}
