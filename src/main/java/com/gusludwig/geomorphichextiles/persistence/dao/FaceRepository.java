package com.gusludwig.geomorphichextiles.persistence.dao;

import com.gusludwig.geomorphichextiles.persistence.model.Face;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaceRepository extends JpaRepository<Face, String> {
}
