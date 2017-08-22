package com.test.multiDataSource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 获取数据源
 * Created by guanguan on 2017/8/22.
 */
public class DynamicDataSource extends AbstractRoutingDataSource{


    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataHolder.getDataSource();
    }
}
