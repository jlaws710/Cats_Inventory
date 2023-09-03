package com.cats.inventory.repository;

import com.cats.inventory.model.Cats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatsRepository extends JpaRepository<Cats, Integer> {
}
