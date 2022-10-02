package com.mykyta.crud.repository;

import java.util.List;

public interface GenericRepository <T,ID> {
    List<T> getAll();
    T getById(ID id);
    T create(T entity);
    T update(T entity);
    void deleteById(ID id);
}
