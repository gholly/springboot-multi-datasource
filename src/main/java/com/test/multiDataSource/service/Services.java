package com.test.multiDataSource.service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by guanguan on 2017/7/21.
 */
public interface Services<T> {

    void insert(T t);

    Integer insertBatch(List<T> t);

    List<T> findBy(HashMap<?, ?> params);

    void update(T t);

    void delete(Integer id);

    void deleteBatch(Object[] t);

    T getEntityById(Integer id);

    Integer countBy(HashMap<?, ?> params);

}
