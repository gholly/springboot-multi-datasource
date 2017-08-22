package com.test.multiDataSource.service.test;

import com.github.pagehelper.PageHelper;
import com.test.multiDataSource.dao.test.UserMapper;
import com.test.multiDataSource.model.test.User;
import com.test.multiDataSource.service.ServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by guanguan on 2017/7/20.
 */
@Service
public class UserServiceImpl extends ServicesImpl<User> implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public List<User> getAll(User user){
        if(user.getPage()!=null && user.getRows()!=null){
            PageHelper.startPage(user.getPage(),user.getRows());
        }
        HashMap<String,Object> params= new HashMap<String, Object>();
        return userMapper.findBy(new HashMap<Object, Object>());

    }

}

