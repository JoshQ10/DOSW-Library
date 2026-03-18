package edu.eci.dosw.DOSW_Library.controller.mapper;

import edu.eci.dosw.DOSW_Library.Core.model.Loan;
import edu.eci.dosw.DOSW_Library.Core.model.User;
import edu.eci.dosw.DOSW_Library.Core.model.Book;
import edu.eci.dosw.DOSW_Library.controller.dto.LoanDTO;

public class LoanMapper {

    public static Loan toModel(LoanDTO dto, User user, Book book) {
        Loan loan = new Loan();
        loan.setId(dto.getId());
        loan.setUser(user);
        loan.setBook(book);
        loan.setLoanDate(dto.getLoanDate());
        loan.setReturnDate(dto.getReturnDate());
        return loan;
    }

    public static LoanDTO toDTO(Loan loan) {
        LoanDTO dto = new LoanDTO();
        dto.setId(loan.getId());
        dto.setUserId(loan.getUser().getId());
        dto.setBookId(loan.getBook().getId());
        dto.setLoanDate(loan.getLoanDate());
        dto.setReturnDate(loan.getReturnDate());
        return dto;
    }
}
