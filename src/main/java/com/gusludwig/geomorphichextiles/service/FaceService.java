package com.gusludwig.geomorphichextiles.service;

import com.gusludwig.geomorphichextiles.persistence.model.ContactPointType;
import com.gusludwig.geomorphichextiles.persistence.model.Face;
import com.gusludwig.geomorphichextiles.service.generic.CrudService;

import java.util.List;
import java.util.Optional;

public interface FaceService extends CrudService<Face> {

    Optional<Face> create(ContactPointType[] contactPointTypes);

    Optional<Face> update(String id, ContactPointType[] contactPointTypes);

    boolean validateFace(Face face);

    Optional<Face> createOneRandomFace();

    Optional<List<Face>> createRandomFaces(int numberOfFaces);

    Face reverseFace(Face face);
}
