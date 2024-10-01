package com.example.Agilistan.controller;

import com.example.Agilistan.entity.ContentType;
import com.example.Agilistan.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ContentForm {
    private ContentType contentType;
    private String title;
    private Integer publicationYear;
    private Person author;
}
