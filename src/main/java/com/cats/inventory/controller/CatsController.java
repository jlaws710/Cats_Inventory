package com.cats.inventory.controller;

import com.cats.inventory.model.Cats;
import com.cats.inventory.service.CatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class CatsController {

    @Autowired
    private CatsService catsService;

    @GetMapping("/cats")
    public ResponseEntity<List<Cats>> findAll(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                              @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {

        return new ResponseEntity<>(catsService.findAll(pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping("/cats/{id}")
    public ResponseEntity<Optional<Cats>> findById(@PathVariable (value = "id") int id) {
        return ResponseEntity.ok(catsService.findById(id));
    }

    @PostMapping("/cats")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<Cats>> create(@RequestBody Cats cats) {
        return new ResponseEntity<>(catsService.create(cats), HttpStatus.CREATED);
    }

    @DeleteMapping("/cats/{id}")
    public ResponseEntity<String> deleteById(@PathVariable (value = "id") int id) {
        catsService.deleteById(id);

        return new ResponseEntity<>("Cat deleted", HttpStatus.OK);
    }
}
