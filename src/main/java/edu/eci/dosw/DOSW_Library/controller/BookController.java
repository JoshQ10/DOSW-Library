package edu.eci.dosw.DOSW_Library.controller;

import edu.eci.dosw.DOSW_Library.Core.model.Book;
import edu.eci.dosw.DOSW_Library.Core.service.BookService;
import edu.eci.dosw.DOSW_Library.controller.dto.BookDTO;
import edu.eci.dosw.DOSW_Library.controller.mapper.BookMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public BookDTO create(@RequestBody BookDTO dto) {
        Book book = BookMapper.toModel(dto);
        return BookMapper.toDTO(bookService.createBook(book));
    }

    @GetMapping("/{id}")
    public BookDTO get(@PathVariable String id) {
        Book book = bookService.getBook(id);
        return BookMapper.toDTO(book);
    }

    @GetMapping
    public List<BookDTO> getAll() {
        return bookService.getAllBooks().stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public BookDTO update(@PathVariable String id, @RequestBody BookDTO dto) {
        Book book = BookMapper.toModel(dto);
        book.setId(id);
        return BookMapper.toDTO(bookService.updateBook(book));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        bookService.deleteBook(id);
    }
}
