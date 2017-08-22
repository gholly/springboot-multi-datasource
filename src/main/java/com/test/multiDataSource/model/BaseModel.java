package com.test.multiDataSource.model;


/**
 * Created by guanguan on 2017/7/31.
 */
public class BaseModel {


    private Integer page = 1;

    private Integer rows = 10;


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
