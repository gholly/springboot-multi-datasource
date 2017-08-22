package com.test.multiDataSource.service;

import com.test.multiDataSource.dao.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by guanguan on 2017/7/21.
 */
@Service
public class ServicesImpl<T> implements Services<T> {
    @Autowired
    public Mappers<T> mappers;

     public void insert(T t) {
        mappers.insert(t);

    }

     public Integer insertBatch(List<T> t) {
        return mappers.insertBatch(t);
    }

     public List<T> findBy(HashMap<?, ?> params) {
        return mappers.findBy(params);
    }

     public void update(T t) {
        mappers.update(t);

    }

     public void delete(Integer id) {
        mappers.delete(id);

    }

     public void deleteBatch(Object[] t) {
        mappers.deleteBatch(t);

    }

     public T getEntityById(Integer id) {
        return (T) mappers.getEntityById(id);
    }

     public Integer countBy(HashMap<?, ?> params) {
        return mappers.countBy(params);
    }


}
