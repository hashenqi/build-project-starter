package com.czy.study.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageRespVo <T>{
    private int pageSize;
    private int pageNum;
    private long total;
    private List<T> list;
}
