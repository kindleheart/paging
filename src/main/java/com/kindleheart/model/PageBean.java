package com.kindleheart.model;

import java.util.List;

public class PageBean<T> {
    private List<T> pageList;//分页的记录信息
    private int pageSize;//页面大小
    private int rowCount;//总记录数
    private int pageCount;//总页面数
    private int currentPage;//当前页面
    private int previousPage;//前一页的页数
    private int nextPage;//后一页的页数
    private int rowStart;//记录起始处
    private int startPage;//开始页码
    private int endPage;//结束页码

    public PageBean(int currentPage, int rowCount, int pageSize) {
        this.currentPage = currentPage;
        this.rowCount = rowCount;
        this.pageSize = pageSize;
        //总页面数
        pageCount = (rowCount+pageSize-1)/pageSize;
        //记录起始处
        rowStart = (currentPage-1)*pageSize;

        startPage = currentPage - 2;
        endPage = currentPage + 2;

        if(pageCount > 5) {
            if(startPage < 1) {
                startPage = 1;
                endPage = startPage + 4;
            }
            if(endPage > pageCount) {
                endPage = rowCount;
                startPage = endPage - 4;
            }
        } else {
            startPage = 1;
            endPage = pageCount;
        }

    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPreviousPage() {
        previousPage = currentPage - 1;
        if(previousPage < 1) previousPage = 1;
        return previousPage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public int getNextPage() {
        nextPage = currentPage + 1;
        if(nextPage > pageCount) nextPage = pageCount;
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getRowStart() {
        return rowStart;
    }

    public void setRowStart(int rowStart) {
        this.rowStart = rowStart;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
}
