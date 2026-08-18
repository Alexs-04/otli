package com.korebit.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class BookRecordEntity extends PanacheEntity {
    private Long id;
    private String title;
    private String author;
    private LocalDate publicationDate;
}
