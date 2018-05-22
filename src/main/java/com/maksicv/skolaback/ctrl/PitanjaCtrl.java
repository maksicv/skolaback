/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maksicv.skolaback.ctrl;
import com.maksicv.skolaback.model.Pitanje;
import com.maksicv.skolaback.model.PitanjeSaRb;
import com.maksicv.skolaback.repo.PitanjeRepo;
import java.util.List;
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
        Pitanje  old= null;
        if ( pitanje.getId() != null ) {
            old = pitanjeRepo.findById(pitanje.getId()).get();
        }  else {
            old = new Pitanje();
        }
        old.setDescription(pitanje.getDescription());
        old.setPonudjeniOdgovori(pitanje.getPonudjeniOdgovori());
        old.setTipPitanja(pitanje.getTipPitanja() );
        pitanjeRepo.save(old);
        return old;
        }
    
    
    @GetMapping("/api/pitanjaizankete/{id}")
    public List<PitanjeSaRb> getPitanjaIzAnkete(@PathVariable Long id){
        return pitanjeRepo.getPitanjaIzAnkete(id);
    } 
   
    @GetMapping("/api/pitanjavanankete/{id}")
    public List<Pitanje> getPitanjaVanAnkete(@PathVariable Long id){
        return pitanjeRepo.getPitanjaVanAnkete(id);
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
            return pitanjeRepo.findAll(PageRequest.of( pageNumber, rowsPerPage ));
        } else {
            search = "%" + search + "%";
            Page<Pitanje> ret = pitanjeRepo.searchDesc(search   , PageRequest.of(pageNumber,rowsPerPage));
            return  ret;
        }
    }
}
