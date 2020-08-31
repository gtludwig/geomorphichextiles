package com.gusludwig.geomorphichextiles.service.generic;

import com.gusludwig.geomorphichextiles.persistence.model.Face;
import com.gusludwig.geomorphichextiles.persistence.model.Tile;

import java.util.Map;
import java.util.Optional;

public interface TileService extends CrudService<Tile> {

    Optional<Tile> create(String description);

    Optional<Tile> create(String description, Map<String, Face> facesMap);

    Optional<Tile> update(String id, String description, Map<String, Face> facesMap);
}
