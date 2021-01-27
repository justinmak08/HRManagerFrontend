package com.southwind.entity;

import lombok.Data;

import java.util.List;

@Data
public class BookVO {
    private Integer total;
    private List<Book> data;
    private Integer pageSize;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Book> getData() {
        return data;
    }

    public void setData(List<Book> data) {
        this.data = data;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
