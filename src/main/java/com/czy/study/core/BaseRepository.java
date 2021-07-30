package com.czy.study.core;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public class BaseRepository<M extends BaseMapper,E>  {

    @Resource
    public  M baseMapper;


    public int insert(E entity) {
        return baseMapper.insert(entity);
    }

    public int deleteById(Serializable id) {
        return baseMapper.deleteById(id);
    }

    public int deleteByMap(Map<String, Object> columnMap) {
        return baseMapper.deleteByMap(columnMap);
    }

    public int delete(Wrapper<E> wrapper) {
        return baseMapper.delete(wrapper);
    }

    public int deleteBatchIds(Collection<? extends Serializable> idList) {
        return baseMapper.deleteBatchIds(idList);
    }

    public int updateById(E entity) {
        return baseMapper.updateById(entity);
    }

    public int update(E entity, Wrapper<E> updateWrapper) {
        return baseMapper.update(entity,updateWrapper);
    }

    public E selectById(Serializable id) {
        return (E) baseMapper.selectById(id);
    }

    public List<E> selectBatchIds(Collection<? extends Serializable> idList) {
        return baseMapper.selectBatchIds(idList);
    }

    public List<E> selectByMap(Map<String, Object> columnMap) {
        return baseMapper.selectByMap(columnMap);
    }

    public E selectOne(Wrapper<E> queryWrapper) {
        return (E) baseMapper.selectOne(queryWrapper);
    }

    public Integer selectCount(Wrapper<E> queryWrapper) {
        return baseMapper.selectCount(queryWrapper);
    }

    public List<E> selectList(Wrapper<E> queryWrapper) {
        return baseMapper.selectList(queryWrapper);
    }

    public List<Map<String, Object>> selectMaps(Wrapper<E> queryWrapper) {
        return baseMapper.selectMaps(queryWrapper);
    }

    public List<Object> selectObjs(Wrapper<E> queryWrapper) {
        return baseMapper.selectObjs(queryWrapper);
    }

    public IPage<E> selectPage(IPage<E> page, Wrapper<E> queryWrapper) {
        return baseMapper.selectPage(page,queryWrapper);
    }

    public IPage<Map<String, Object>> selectMapsPage(IPage<E> page, Wrapper<E> queryWrapper) {
        return baseMapper.selectMapsPage(page,queryWrapper);
    }
}
