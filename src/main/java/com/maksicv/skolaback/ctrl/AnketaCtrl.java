/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maksicv.skolaback.ctrl;

import com.maksicv.skolaback.model.Anketa;
import com.maksicv.skolaback.repo.AnketaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author bratislav.petrovic
 */
@RestController
public class AnketaCtrl {
    
    @Autowired
    private AnketaRepo anketaRepo;
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @PostMapping("/api/anketa")
    public Anketa save(@RequestBody Anketa anketa){
        anketaRepo.save(anketa);
        return anketa;
        }
    
    @GetMapping("/api/deleteanketa/{id}")
    public void deleteOne(@PathVariable("id") Long id){
        anketaRepo.deleteById(id);
    }
            
    
    @GetMapping("/api/anketa")
    public Page<Anketa> getPage(@RequestParam(value="page") Integer pageNumber,
                                @RequestParam(value="rowsPerPage") Integer rowsPerPage )  {
        
        log.info("page number =" + pageNumber + " rows " + rowsPerPage);
        return anketaRepo.findAll(PageRequest.of(pageNumber,rowsPerPage));
    }
    
}
