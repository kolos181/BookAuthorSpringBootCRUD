package com.sombra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sombra.entity.AuthorBook;

import java.util.List;

@Repository
public interface AuthorBookService extends JpaRepository<AuthorBook, Integer> {

    @Query(value = "select distinct a.name, count(*) c from author_book ab inner join authors a on ab.author_id = a.author_id GROUP BY a.author_id HAVING c > 1;", nativeQuery = true)
    List<Object> getAuthorWithMoreThanOneBook();

    @Query(value = "select distinct a.name, count(book_id) c from author_book ab inner join authors a on ab.author_id = a.author_id group by a.author_id order by c desc limit 1", nativeQuery = true)
    List<Object> getAuthorWithMostBooks();
}
