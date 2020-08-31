package com.gusludwig.geomorphichextiles.service.generic;

import com.gusludwig.geomorphichextiles.persistence.model.BasePojo;

import java.util.List;
import java.util.Optional;

public interface CrudService<Pojo extends BasePojo> {

    Optional<Pojo> findById(final String id);

    Optional<Pojo> save(Pojo pojo);

    void remove(String id);

    List<Pojo> findAll();
}
