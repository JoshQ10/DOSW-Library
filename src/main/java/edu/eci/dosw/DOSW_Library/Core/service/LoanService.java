package edu.eci.dosw.DOSW_Library.Core.service;

import edu.eci.dosw.DOSW_Library.Core.model.Loan;
import edu.eci.dosw.DOSW_Library.Core.model.User;
import edu.eci.dosw.DOSW_Library.Core.model.Book;
import edu.eci.dosw.DOSW_Library.Core.Util.IdGeneratorUtil;
import edu.eci.dosw.DOSW_Library.Core.Util.DateUtil;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    private List<Loan> loans = new ArrayList<>();

    private final BookService bookService;
    private final UserService userService;

    public LoanService(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    public Loan createLoan(String userId, String bookId) {

        // validar usuario
        User user = userService.getUser(userId);

        // validar disponibilidad libro
        bookService.decreaseStock(bookId);
        Book book = bookService.getBook(bookId);

        Loan loan = new Loan();
        loan.setId(IdGeneratorUtil.generate());
        loan.setUser(user);
        loan.setBook(book);
        loan.setLoanDate(DateUtil.now());

        loans.add(loan);

        return loan;
    }

    public void returnBook(String loanId) {
        Loan loan = loans.stream()
                .filter(l -> l.getId().equals(loanId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Prestamo no encontrado"));

        bookService.increaseStock(loan.getBook().getId());
        loans.remove(loan);
    }

    public List<Loan> getAllLoans() {
        return loans;
    }

    public Loan getLoan(String id) {
        return loans.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Loan not found"));
    }
}
