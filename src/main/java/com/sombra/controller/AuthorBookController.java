package com.sombra.controller;

import com.sombra.repository.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authorBook")
public class AuthorBookController {

    @Autowired
    AuthorBookService authorBookService;

    //authors who published more than one book
    @RequestMapping("/MoreThanOneBook")
    public List<Object> getAuthorWithMoreThanOneBook() {
        System.out.println(authorBookService.getAuthorWithMoreThanOneBook());
        return authorBookService.getAuthorWithMoreThanOneBook();
    }

    //author with most books
    @RequestMapping("/mostBooks")
    public List<Object> getAuthorWithMostBooks() {
        return authorBookService.getAuthorWithMostBooks();
    }

}
