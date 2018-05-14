/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maksicv.skolaback.repo;

import com.maksicv.skolaback.model.Anketa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author bratislav.petrovic
 */
public interface AnketaRepo extends PagingAndSortingRepository <Anketa,Long> {

    public Page<Anketa> findAll(Pageable page);
    
}
