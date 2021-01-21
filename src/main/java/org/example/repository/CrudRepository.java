package org.example.repository;

import org.example.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface CrudRepository<T extends BaseEntity, ID extends Serializable> {

    List<T> getAll();

    T get(ID id);

    T save(T entity);

    void delete(ID id);

}
