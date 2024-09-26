package org.example.common;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class PageSupport<T> {

	public static final String FIRST_PAGE_NUM = "0";
	public static final String DEFAULT_PAGE_SIZE = "20";

	List<T> content;
	int pageNumber;
	int pageSize;
	long totalElements;

	public long totalPages() {
		return pageSize > 0 ? (totalElements + pageSize - 1) / pageSize : 0;
	}

	@JsonProperty
	public boolean first() {
		return pageNumber == 0;
	}

	@JsonProperty
	public boolean last() {
		return (pageNumber + 1) * pageSize >= totalElements;
	}

}
