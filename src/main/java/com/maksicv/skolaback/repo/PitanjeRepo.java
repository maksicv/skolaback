/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maksicv.skolaback.repo;

import com.maksicv.skolaback.model.Pitanje;
import com.maksicv.skolaback.model.PitanjeSaRb;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author bratislav.petrovic
 */
public interface PitanjeRepo extends PagingAndSortingRepository <Pitanje,Long> {

    public Page<Pitanje> findAll(Pageable page);
    @Query( "select p from Pitanje p where description like ?1 ")
    public Page<Pitanje> searchDesc(String desc,Pageable page);
    
    @Query("select new com.maksicv.skolaback.model.PitanjeSaRb(p, a.redniBroj,a.anketaId) from Pitanje p , PitanjaIzAnketa a where  a.anketaId = ?1 and a.pitanjeId = p.id " )
    public List<PitanjeSaRb> getPitanjaIzAnkete(Long idAnkete);
    
    @Query("select p  from Pitanje p , PitanjaIzAnketa a where  a.anketaId = ?1 and a.pitanjeId <> p.id " )
    public List<Pitanje> getPitanjaVanAnkete(Long idAnkete);
    
}
