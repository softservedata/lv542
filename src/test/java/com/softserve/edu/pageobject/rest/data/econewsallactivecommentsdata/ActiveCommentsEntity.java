package com.softserve.edu.pageobject.rest.data.econewsallactivecommentsdata;

import java.util.List;

public class ActiveCommentsEntity {
    private List<PageEntity> page;
    private long totalElements;
    private long currentPage;
    private long totalPages;

    public ActiveCommentsEntity(List<PageEntity> pageEntity, int totalElements, int currentPage, int totalPages) {
        this.page = pageEntity;
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
    }

    public List<PageEntity> getPage() {
        return page;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public long getTotalPages() {
        return totalPages;
    }

    @Override
    public String toString() {
        return "ActiveCommentsEntity{" +
                "pageEntity=" + page + "\n" +
                ", totalElements=" + totalElements + "\n" +
                ", currentPage=" + currentPage + "\n" +
                ", totalPages=" + totalPages + "\n" +
                '}';
    }
}
