package com.gusludwig.geomorphichextiles.service.generic;

import com.gusludwig.geomorphichextiles.persistence.model.BasePojo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<Pojo extends BasePojo> {

    Pojo findById(final String id);

    Pojo save(Pojo pojo);

    void remove(String id);

    Page<Pojo> findAll(Pageable pageable);
}
