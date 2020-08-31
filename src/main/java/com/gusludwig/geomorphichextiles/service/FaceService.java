package com.gusludwig.geomorphichextiles.service;

import com.gusludwig.geomorphichextiles.persistence.model.ContactPoint;
import com.gusludwig.geomorphichextiles.persistence.model.Face;
import com.gusludwig.geomorphichextiles.service.generic.CrudService;

import java.util.Optional;

public interface FaceService extends CrudService<Face> {

    Optional<Face> create(ContactPoint[] contactPoints);

    Optional<Face> update(String id, ContactPoint[] contactPoints);

    boolean validateFace(Face face);

    Optional<Face> createOneRandomFace();
}
