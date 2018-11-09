package com.sombra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sombra.entity.Authors;

import java.util.List;

@Repository
public interface AuthorsService extends JpaRepository<Authors, Integer> {

    @Query(value ="SELECT * from Authors where YEAR(CURDATE()) - YEAR(born) > 55", nativeQuery = true)
    List<Authors> getOldAuthors();
}
