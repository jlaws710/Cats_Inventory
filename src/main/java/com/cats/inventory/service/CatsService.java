package com.cats.inventory.service;

import com.cats.inventory.model.Cats;

import java.util.List;
import java.util.Optional;

public interface CatsService {
    List<Cats> findAll(int pageNo, int pageSize);
    Optional<Cats> findById(int id);
    List<Cats> create(Cats cats);
    void deleteById(int id);
}
