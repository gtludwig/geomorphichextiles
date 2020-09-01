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
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service(value = "tileService")
public class TileServiceImpl implements TileService {

    private TileRepository tileRepository;

    private FaceService faceService;

    @Autowired
    public TileServiceImpl(TileRepository tileRepository, FaceService faceService) {
        this.tileRepository = tileRepository;
        this.faceService = faceService;
    }

    @Override
    public Optional<Tile> create(String description) {
        Tile tile = new Tile();
        tile.setDescription(description);
        return this.save(tile);
    }

    @Override
    public Optional<Tile> create(String description, Map<String, Face> facesMap) {

        if(facesMap.containsKey(FacesMapKeys.values())) {
            Tile tile = new Tile();
            tile.setDescription(description);

        }

        return null;
    }

    private boolean validateFace(Face face) {
        if (faceService.validateFace(face)) {
            return true;
        }
        return false;
    }


    @Override
    public Optional<Tile> update(String id, String description, Map<String, Face> facesMap) {
        return null;
    }

    @Override
    @Transactional
    public Optional<Tile> findById(String id) {
        return Optional.of(this.tileRepository.getOne(id));
    }

    @Override
    @Transactional
    public Optional<Tile> save(Tile pojo) {
        Optional<Tile> tile = Optional.of(this.tileRepository.save(pojo));
        log.info(String.format("Successfully created entity with id ' %s ' ", tile.get().getId()));
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
