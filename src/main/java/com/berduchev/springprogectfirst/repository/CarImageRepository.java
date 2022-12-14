package com.berduchev.springprogectfirst.repository;

import com.berduchev.springprogectfirst.model.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarImageRepository extends JpaRepository<CarImage, Long> {
}
