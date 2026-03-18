package edu.eci.dosw.DOSW_Library.Core.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Loan {
    private String id;
    private User user;
    private Book book;
    private LocalDate loanDate;
    private LocalDate returnDate;
}
