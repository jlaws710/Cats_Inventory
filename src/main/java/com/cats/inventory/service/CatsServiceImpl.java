package com.cats.inventory.service;

import com.cats.inventory.repository.CatsRepository;
import com.cats.inventory.model.Cats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatsServiceImpl implements CatsService {

    @Autowired
    private CatsRepository catsRepository;
    @Override
    public List<Cats> findAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Cats> cats = catsRepository.findAll(pageable);
        List<Cats> listOfCats = cats.getContent();
        return listOfCats.stream().collect(Collectors.toList());
        //return (List<Cats>) catsRepository.findAll();
    }

    @Override
    public Optional<Cats> findById(int id) {
        return catsRepository.findById(id);
    }

    @Override
    public List<Cats> create(Cats cats) {
        return Collections.singletonList(catsRepository.save(cats));
    }

    @Override
    public void deleteById(int id) {
        catsRepository.deleteById(id);
    }
}
