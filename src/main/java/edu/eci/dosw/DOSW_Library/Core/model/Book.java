package edu.eci.dosw.DOSW_Library.Core.model;

import lombok.Data;

@Data
public class Book {
    private String id;
    private String title;
    private String author;
    private int availableCopies;
}
