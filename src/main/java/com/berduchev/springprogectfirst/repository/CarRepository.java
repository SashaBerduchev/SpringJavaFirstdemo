package com.berduchev.springprogectfirst.repository;

import com.berduchev.springprogectfirst.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
