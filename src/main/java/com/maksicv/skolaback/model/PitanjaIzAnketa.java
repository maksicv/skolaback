/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maksicv.skolaback.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

import com.maksicv.skolaback.model.Anketa;
import com.maksicv.skolaback.model.Pitanje;


/**
 *
 * @author bratislav.petrovic
 */
@Entity
public class PitanjaIzAnketa {
    @Id
    @GeneratedValue
    private Long Id;
    
    private Long anketaId;
    private Long pitanjeId;
    private Integer redniBroj;

    
    
    
    
    public Integer getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(Integer redniBroj) {
        this.redniBroj = redniBroj;
    }
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Long getAnketaId() {
        return anketaId;
    }

    public void setAnketaId(Long anketaId) {
        this.anketaId = anketaId;
    }

    public Long getPitanjeId() {
        return pitanjeId;
    }

    public void setPitanjeId(Long pitanjeId) {
        this.pitanjeId = pitanjeId;
    }
    
    

}
