package com.czy.study.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.czy.study.entity.Course;
import java.util.List;


public interface CourseMapper extends BaseMapper<Course> {
    List<Course> selectAll();
}
