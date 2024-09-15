package com.berduchev.springprogectfirst.repository;

import com.berduchev.springprogectfirst.model.BooksShelf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksShelfRepository extends JpaRepository<BooksShelf, Long> {
}
