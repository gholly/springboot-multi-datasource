package com.test.multiDataSource.config;

import com.test.multiDataSource.enums.DataSourceType;

/**
 * 数据源操作的类
 * Created by guanguan on 2017/8/22.
 */
public class DynamicDataHolder {


    //线程本地环境
    private static final ThreadLocal<DataSourceType> dataSources = new ThreadLocal<DataSourceType>();


    //设置数据源
    public static void setDataSources(DataSourceType dataSourceType){
        dataSources.set(dataSourceType);
    }

    //获取数据源
    public static DataSourceType getDataSource(){
        return dataSources.get();
    }


    //清除数据源
    public static void clearDataSource(){
        dataSources.remove();
    }



}
