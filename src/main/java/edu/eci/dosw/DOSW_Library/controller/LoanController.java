package edu.eci.dosw.DOSW_Library.controller;

import edu.eci.dosw.DOSW_Library.Core.model.Loan;
import edu.eci.dosw.DOSW_Library.Core.service.LoanService;
import edu.eci.dosw.DOSW_Library.controller.dto.LoanDTO;
import edu.eci.dosw.DOSW_Library.controller.mapper.LoanMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public LoanDTO createLoan(@RequestBody LoanDTO dto) {
        Loan loan = loanService.createLoan(dto.getUserId(), dto.getBookId());
        return LoanMapper.toDTO(loan);
    }

    @PostMapping("/return")
    public void returnBook(@RequestParam String loanId) {
        loanService.returnBook(loanId);
    }

    @GetMapping
    public List<LoanDTO> getAllLoans() {
        return loanService.getAllLoans().stream()
                .map(LoanMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LoanDTO getLoan(@PathVariable String id) {
        Loan loan = loanService.getLoan(id);
        return LoanMapper.toDTO(loan);
    }
}
