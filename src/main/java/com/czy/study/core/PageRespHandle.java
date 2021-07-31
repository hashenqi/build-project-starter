package com.czy.study.core;

import java.util.List;

public  class  PageRespHandle {

    public static<T> PageRespVo<T> of(int pageSize, int pageNum, long total, List<T> result){
        return new PageRespVo<T>(pageSize,pageNum,total,result);
    }
}
