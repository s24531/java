package com.example.demo.contract;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.Year;
import java.util.Date;

@Getter
@Setter
public class BookDto {
    private Long id;
    @JsonProperty("category")
    private String category;
    @JsonProperty("title")
    private String title;
    @JsonProperty("author")
    private String author;
    private Integer numbOfPages;
    private Year yearOfPublication;


}
