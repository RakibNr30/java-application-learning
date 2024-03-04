package com.resume.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageRequestDto {
    private int page = 0;

    private int size = 10;

    private String direction = "asc";

    private String sort = "id";

    public Pageable getPageable() {
        int pageNumber = Math.max(this.page - 1, 0);
        int pageSize = Math.max(this.size, 1);
        Sort.Direction sortDirection = Sort.Direction.fromString(this.direction.equalsIgnoreCase("desc") ? this.direction : "asc");
        String sortField = this.sort;

        return PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField));
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
