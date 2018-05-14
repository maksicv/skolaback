/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maksicv.skolaback.ctrl;

import com.maksicv.skolaback.model.Anketa;
import com.maksicv.skolaback.repo.AnketaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author bratislav.petrovic
 */
@RestController
public class AnketaCtrl {
    
    @Autowired
    private AnketaRepo anketaRepo;
    
    
    @PostMapping("/api/anketa")
    public void save(@RequestBody Anketa anketa){
        anketaRepo.save(anketa);
    }
    
    @GetMapping("/api/anketa")
    public Page<Anketa> getPage(Pageable page){
        return anketaRepo.findAll(page);
    }
    
}
