package com.berduchev.springprogectfirst.repository;

import com.berduchev.springprogectfirst.model.Tires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiresRepository extends JpaRepository<Tires, Long> {
}
