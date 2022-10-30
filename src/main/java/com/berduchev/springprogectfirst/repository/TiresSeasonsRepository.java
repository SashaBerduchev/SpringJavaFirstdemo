package com.berduchev.springprogectfirst.repository;

import com.berduchev.springprogectfirst.model.TiresSeasons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiresSeasonsRepository extends JpaRepository<TiresSeasons, Long> {
}
