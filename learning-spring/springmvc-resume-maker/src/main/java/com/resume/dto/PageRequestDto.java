package com.resume.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageRequestDto {
    private int page = 0;

    private int perPage = 10;

    private String direction = "asc";

    private String sortBy = "id";

    public Pageable getPageable() {
        int pageNumber = Math.max(this.page - 1, 0);
        int pageSize = Math.max(this.perPage, 1);
        Sort.Direction sortDirection = Sort.Direction.fromString(this.direction.equalsIgnoreCase("desc") ? this.direction : "asc");

        return PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, this.sortBy));
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
