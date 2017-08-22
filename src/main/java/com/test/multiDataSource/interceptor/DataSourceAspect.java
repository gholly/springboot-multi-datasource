package com.test.multiDataSource.interceptor;

import com.test.multiDataSource.config.DynamicDataHolder;
import com.test.multiDataSource.enums.DataSourceType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by guanguan on 2017/8/22.
 */
@Aspect  //aop切面拦截
@Component //组件,启动时加载
public class DataSourceAspect {


    /**
     * 在通用方法中拦截操作数据库的方法
     * @param point
     */
    @Before("execution(* com.test.multiDataSource.service.Services.*(..))")
    public void setDataSourceKeyByPublic(JoinPoint point){
        String targetStr = point.getTarget().toString();
        setDataSourceKey(targetStr);
    }



    @Before("execution(* com.test.multiDataSource.service.*.*.*(..))")
    public void setDataSourceKeyByPrivate(JoinPoint point){
        String targetStr = point.getTarget().toString();
        setDataSourceKey(targetStr);
    }




    private void setDataSourceKey(String targetStr){
        if(targetStr.contains("manage")){
            DynamicDataHolder.setDataSources(DataSourceType.manage);
        }else if(targetStr.contains("test")){
            DynamicDataHolder.setDataSources(DataSourceType.test);
        }
    }
}
