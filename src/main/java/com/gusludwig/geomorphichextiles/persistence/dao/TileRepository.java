package com.gusludwig.geomorphichextiles.persistence.dao;

import com.gusludwig.geomorphichextiles.persistence.model.Tile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TileRepository extends JpaRepository<Tile, String> {
}
