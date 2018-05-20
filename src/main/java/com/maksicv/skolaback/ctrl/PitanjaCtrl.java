/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maksicv.skolaback.ctrl;
import com.maksicv.skolaback.model.Pitanje;
import com.maksicv.skolaback.repo.PitanjeRepo;
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
public class PitanjaCtrl {
    
    @Autowired
    private PitanjeRepo pitanjeRepo;
    
     private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @PostMapping("/api/pitanje")
    public Pitanje save(@RequestBody Pitanje pitanje){
        log.info(pitanje.getPonudjeniOdgovori());
        pitanjeRepo.save(pitanje);
        return pitanje;
        }
    
    @GetMapping("/api/deletepitanje/{id}")
    public void deltePitanje( @PathVariable Long id  ){
        pitanjeRepo.deleteById(id);
    } 
    
    @GetMapping("/api/pitanje")
    public Page<Pitanje> getPage(@RequestParam(value="page") Integer pageNumber,
                                 @RequestParam(value="rowsPerPage") Integer rowsPerPage,
                                 @RequestParam(value="search" , required = false ) String search )  {
           
        if ( search == null ) {
            log.info(" ALLL ");
            return pitanjeRepo.findAll(PageRequest.of( pageNumber, rowsPerPage ));
        } else {
            search = "%" + search + "%";
            log.info(" SEARCH" + search);
            Page<Pitanje> ret = pitanjeRepo.searchDesc(search   , PageRequest.of(pageNumber,rowsPerPage));
            log.info(" SIZE " + ret.getTotalElements()  );
            return  ret;
        }
    }
}
