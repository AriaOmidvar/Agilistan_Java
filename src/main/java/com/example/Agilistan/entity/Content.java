package com.example.Agilistan.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Content {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Enumerated(STRING)
    private ContentType contentType;
    @NonNull
    private String title;
    private Integer publicationYear;
    @OneToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Person author;
}
