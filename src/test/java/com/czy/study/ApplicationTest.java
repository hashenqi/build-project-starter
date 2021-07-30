package com.czy.study;

import com.alibaba.fastjson.JSONObject;
import com.czy.study.mapper.CourseMapper;
import com.czy.study.entity.Course;
import com.czy.study.repository.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationTest {

    @Autowired
    private CourseMapper mapper;

    @Resource
    private CourseRepository courseRepository;

    @Test
    public void test(){
        List<Course> courses = mapper.selectAll();
        System.out.println(JSONObject.toJSONString(courses));
    }

    @Test
    public void test2(){
        courseRepository.select();
        Course course = courseRepository.selectById(621288054119727104L);
        System.out.println(course);
    }

}
