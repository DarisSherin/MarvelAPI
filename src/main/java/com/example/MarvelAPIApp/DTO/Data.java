package com.example.MarvelAPIApp.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public class Data {

    @JsonProperty("count")
    private Long count;
    @JsonProperty("limit")
    private Long limit;
    @JsonProperty("offset")
    private Long offset;
    @JsonProperty("results")
    private List<Result> results;
    @JsonProperty("total")
    private Long total;
    
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getLimit() {
		return limit;
	}
	public void setLimit(Long limit) {
		this.limit = limit;
	}
	public Long getOffset() {
		return offset;
	}
	public void setOffset(Long offset) {
		this.offset = offset;
	}
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}

}

