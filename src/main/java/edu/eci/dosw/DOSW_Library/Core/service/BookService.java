package edu.eci.dosw.DOSW_Library.Core.service;

import edu.eci.dosw.DOSW_Library.Core.model.Book;
import edu.eci.dosw.DOSW_Library.Core.exception.BookNotAvailableException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private Map<String, Book> books = new HashMap<>();

    public Book createBook(Book book) {
        books.put(book.getId(), book);
        return book;
    }

    public Book getBook(String id) {
        return books.get(id);
    }

    public void decreaseStock(String bookId) {
        Book book = getBook(bookId);
        if (book.getAvailableCopies() <= 0) {
            throw new BookNotAvailableException("No hay libros disponibles");
        }
        book.setAvailableCopies(book.getAvailableCopies() - 1);
    }

    public void increaseStock(String bookId) {
        Book book = getBook(bookId);
        book.setAvailableCopies(book.getAvailableCopies() + 1);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Book updateBook(Book book) {
        books.put(book.getId(), book);
        return book;
    }

    public void deleteBook(String id) {
        books.remove(id);
    }
}
