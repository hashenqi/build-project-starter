package com.czy.study;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.czy.study.core.PageRespHandle;
import com.czy.study.core.PageRespVo;
import com.czy.study.mapper.CourseMapper;
import com.czy.study.entity.Course;
import com.czy.study.repository.CourseRepository;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
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

    //乐观锁的使用，在数据库对应的表中加上version字段
    @Test
    public void test3() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        for (int j = 0; j < 10; j++) {
            new Thread(()->{
                Course course = courseRepository.selectById(621288054119727104L);
                course.setCname("aaa");
                int i = courseRepository.updateById(course);
                log.info(i+"修改");
                latch.countDown();
            }).start();
        }
        latch.await();
    }

    //分页查询
    @Test
    public void test4() {
        Page<Course> page = PageHelper.startPage(1, 15).doSelectPage(() -> courseRepository.selectList(new LambdaQueryWrapper<Course>()));
        PageRespVo<Course> pageRespVo = PageRespHandle.of(15, 1, page.getTotal(), page.getResult());
        log.info(JSONObject.toJSONString(pageRespVo));

    }

}
