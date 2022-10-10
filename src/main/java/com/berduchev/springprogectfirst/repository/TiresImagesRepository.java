package com.berduchev.springprogectfirst.repository;

import com.berduchev.springprogectfirst.model.TiresImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiresImagesRepository extends JpaRepository<TiresImages, Long> {
}
