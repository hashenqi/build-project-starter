package com.czy.study.repository;

import com.czy.study.core.BaseRepository;
import com.czy.study.entity.Course;
import com.czy.study.mapper.CourseMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository extends BaseRepository<CourseMapper, Course> {


    public void select(){
        baseMapper.selectAll();
    }
}
