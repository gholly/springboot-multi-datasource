package com.test.multiDataSource.service.test;

import com.test.multiDataSource.model.test.User;
import com.test.multiDataSource.service.Services;

import java.util.List;

/**
 * Created by guanguan on 2017/7/20.
 */
public interface UserService extends Services<User> {


     List<User> getAll(User user);


     }
