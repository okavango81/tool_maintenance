package com.okavango.tool_maintenance.pagination;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponsePaginated<T> {

    private List<T> content;
    private boolean first;
    private boolean last;
    @JsonProperty("page")
    private int number;
    private int size;
    @JsonProperty("elementsOnPage")
    private int numberOfElements;
    private int totalPages;
    private long totalElements;

}
