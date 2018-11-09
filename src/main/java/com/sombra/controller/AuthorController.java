package com.sombra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sombra.entity.Authors;
import com.sombra.repository.AuthorsService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {


    @Autowired
    private AuthorsService authorsService;

    @PostMapping("/")
    public String addAuthor() {
        authorsService.save(new Authors("Sharma", "male", new Date()));
        return "home";
    }

    @GetMapping
    public Authors getAuthor() {
        return authorsService.getOne(1);
    }

    @PutMapping
    public Authors updateAuthor() {
        return authorsService.save(new Authors("Sharma", "male", new Date()));
    }

    @DeleteMapping
    public void deleteAuthor() {
        authorsService.deleteById(1);
    }

    //select authors with age > 55
    @RequestMapping("/oldAuthors")
    public List<Authors> getOldAuthors() {
        return authorsService.getOldAuthors();
    }
}
