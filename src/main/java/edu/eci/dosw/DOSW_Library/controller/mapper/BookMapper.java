package edu.eci.dosw.DOSW_Library.controller.mapper;

import edu.eci.dosw.DOSW_Library.Core.model.Book;
import edu.eci.dosw.DOSW_Library.controller.dto.BookDTO;

public class BookMapper {

    public static Book toModel(BookDTO dto) {
        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setAvailableCopies(dto.getAvailableCopies());
        return book;
    }

    public static BookDTO toDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setAvailableCopies(book.getAvailableCopies());
        return dto;
    }
}
