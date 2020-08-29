package com.gusludwig.geomorphichextiles.service.generic;

import com.gusludwig.geomorphichextiles.persistence.model.BasePojo;

import java.util.List;

public interface CrudService<Pojo extends BasePojo> {

    Pojo findById(final String id);

    Pojo save(Pojo pojo);

    void remove(String id);

    List<Pojo> findAll();
}
