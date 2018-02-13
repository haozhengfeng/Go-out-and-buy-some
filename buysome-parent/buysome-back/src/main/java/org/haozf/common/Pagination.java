package org.haozf.common;

import com.github.pagehelper.PageInfo;

public class Pagination {

    private int pageNum;
    private int pageSize;
    private long totalCount;
    private int pageCount;
    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public long getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
  
    public Pagination handler(PageInfo<?> page) {
        this.setPageNum(page.getPageNum());
        this.setPageSize(page.getPageSize());
        this.setPageCount(page.getPages());
        this.setTotalCount(page.getTotal());
        return this;
    }
    
}
