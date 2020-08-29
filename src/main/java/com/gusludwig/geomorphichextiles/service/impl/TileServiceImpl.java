package com.gusludwig.geomorphichextiles.service.impl;

import com.gusludwig.geomorphichextiles.persistence.dao.TileRepository;
import com.gusludwig.geomorphichextiles.persistence.model.Face;
import com.gusludwig.geomorphichextiles.persistence.model.FacesMapKeys;
import com.gusludwig.geomorphichextiles.persistence.model.Tile;
import com.gusludwig.geomorphichextiles.service.FaceService;
import com.gusludwig.geomorphichextiles.service.generic.TileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class TileServiceImpl implements TileService {

    private TileRepository tileRepository;

    private FaceService faceService;

    @Autowired
    public TileServiceImpl(TileRepository tileRepository, FaceService faceService) {
        this.tileRepository = tileRepository;
        this.faceService = faceService;
    }

    @Override
    public Tile create(String description) {
        Tile tile = new Tile();
        tile.setDescription(description);
        return this.save(tile);
    }

    @Override
    public Tile create(String description, Map<String, Face> facesMap) {

        if(facesMap.containsKey(FacesMapKeys.values())) {
            Tile tile = new Tile();
            tile.setDescription(description);

        }

        return null;
    }

    private boolean validateFace(Face face) {
        if ()
        return false;
    }


    @Override
    public Tile update(String id, String description, Map<String, Face> facesMap) {
        return null;
    }

    @Override
    @Transactional
    public Tile findById(String id) {
        return this.tileRepository.getOne(id);
    }

    @Override
    @Transactional
    public Tile save(Tile pojo) {
//        if()
        Tile tile = this.tileRepository.save(pojo);
        log.info(String.format("Successfully created entity with id ' %s ' ", tile.getId()));
        return tile;
    }

    @Override
    @Transactional
    public void remove(String id) {
        Tile tile = this.tileRepository.getOne(id);
        this.tileRepository.delete(tile);
        log.info(String.format("Successfully removed entity with id ' %s ' ", tile.getId()));
    }

    @Override
    @Transactional
    public List<Tile> findAll() {
        return this.tileRepository.findAll();
    }
}
