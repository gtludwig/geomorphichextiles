package com.gusludwig.geomorphichextiles.service;

import com.gusludwig.geomorphichextiles.persistence.model.ContactPoint;
import com.gusludwig.geomorphichextiles.persistence.model.Face;
import com.gusludwig.geomorphichextiles.service.generic.CrudService;

public interface FaceService extends CrudService<Face> {

    Face create(ContactPoint[] contactPoints);

    Face update(String id, ContactPoint[] contactPoints);

    boolean validateFace(Face face);
}
