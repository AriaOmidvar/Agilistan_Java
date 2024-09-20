package com.example.Agilistan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    public String title;
    public int publicationYear;
    public String authors;
    private int edition;
}