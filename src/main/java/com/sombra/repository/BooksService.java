package com.sombra.repository;


import com.sombra.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksService extends JpaRepository<Books, Integer> {

    @Query(value = "select genre, count(*) c from books group by genre order by c desc", nativeQuery = true)
    List<Object> showByGenreCount();
}
