package com.czy.study.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("course_1")
public class Course {

    @TableId("cid")
    private Long cid;
    @TableField("cname")
    private String cname;
    @TableField("user_id")
    private Integer userId;
    @TableField("status")
    private String status;
}
