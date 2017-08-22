package com.test.multiDataSource.model.manage;

import com.test.multiDataSource.model.BaseModel;

import java.util.Date;

/**
 * Created by guanguan on 2017/8/22.
 */
public class LoginLog extends BaseModel {
    private Integer id;
    private String userId;
    private Integer status;
    private Date  loginTime;
    private String loginIp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
}
