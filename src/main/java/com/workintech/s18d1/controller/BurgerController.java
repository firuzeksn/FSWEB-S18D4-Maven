package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/burger")
public class BurgerController {

    private final BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger) {
        return burgerDao.save(burger);
    }

    @GetMapping
    public List<Burger> findAll() {
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger find(@PathVariable Long id) {
        return burgerDao.findById(id);
    }

    @PutMapping
    public Burger update(@RequestBody Burger burger) {
        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable Long id) {
        return burgerDao.remove(id);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable Integer price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable String breadType) {
        BreadType bt = BreadType.valueOf(breadType.toUpperCase());
        return burgerDao.findByBreadType(bt);
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable String content) {
        return burgerDao.findByContent(content);
    }
}