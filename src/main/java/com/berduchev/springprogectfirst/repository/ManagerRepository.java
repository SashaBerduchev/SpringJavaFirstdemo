package com.berduchev.springprogectfirst.repository;

import com.berduchev.springprogectfirst.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
