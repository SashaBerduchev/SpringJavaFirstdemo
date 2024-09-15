package com.berduchev.springprogectfirst.repository;

import com.berduchev.springprogectfirst.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Books, Long> {
}
