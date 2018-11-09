package com.sombra.controller;

import com.sombra.entity.Books;
import com.sombra.repository.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BooksService booksService;

    @PostMapping
    public Books addBook() {
        return booksService.save(new Books("Монах который продал свой феррари", new Date(), "self help", 1));
    }

    @GetMapping
    public Books getBook() {
        return booksService.getOne(1);
    }

    @PutMapping
    public Books updateBook() {
        return booksService.save(new Books("Монах который продал свой феррари", new Date(), "self help", 1));
    }

    @DeleteMapping
    public void deleteBook() {
        booksService.deleteById(11);
    }

    @RequestMapping("/genre")
    private List<Object> showByGenre() {
        return booksService.showByGenreCount();
    }
}
