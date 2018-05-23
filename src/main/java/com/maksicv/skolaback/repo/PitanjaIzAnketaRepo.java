/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maksicv.skolaback.repo;

import com.maksicv.skolaback.model.PitanjaIzAnketa;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author bratislav.petrovic
 */
public interface PitanjaIzAnketaRepo extends PagingAndSortingRepository <PitanjaIzAnketa,Long> {

    @Modifying(clearAutomatically=true)
    @Transactional
    @Query("update PitanjaIzAnketa as aa set aa.redniBroj = aa.redniBroj + 1 where aa.anketaId=?1 and aa.redniBroj >= ?2 ")
    public void povecajRedniBroj(Long idAnkete,Integer redniBroj);
   
    @Modifying(clearAutomatically=true)
    @Transactional
    @Query("update PitanjaIzAnketa as aa set aa.redniBroj = aa.redniBroj - 1 where aa.anketaId=?1 and aa.redniBroj >= ?2 ")
    public void smanjiRedniBroj(Long idAnkete,Integer redniBroj);
   
    
    @Modifying(clearAutomatically=true)
    @Transactional
    @Query("delete  from PitanjaIzAnketa where anketaId = ?1 and pitanjeId=?2")
    public void izbaciPitanjeizAnkete(Long idAnkete, Long idPitanja);
}
