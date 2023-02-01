package com.springcourse.project2Boot.repositories;


import com.springcourse.project2Boot.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitleAndAuthor(String title, String author);

    List<Book> findByTitleStartingWith(String startWith);
}
