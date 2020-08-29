package com.gusludwig.geomorphichextiles.service.generic;

import com.gusludwig.geomorphichextiles.persistence.model.Face;
import com.gusludwig.geomorphichextiles.persistence.model.Tile;

import java.util.Map;

public interface TileService extends CrudService<Tile> {

    Tile create(String description);

    Tile create(String description, Map<String, Face> facesMap);

    Tile update(String id, String description, Map<String, Face> facesMap);
}
