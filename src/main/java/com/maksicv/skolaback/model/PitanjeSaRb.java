/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maksicv.skolaback.model;

/**
 *
 * @author bratislav.petrovic
 */
public class PitanjeSaRb {
    private Pitanje pitanje;
    private Integer redniBroj; 
    private Long idAnkete;

    public PitanjeSaRb (Pitanje p,Integer redniBroj , Long idAnkete){
        this.pitanje = p;
        this.redniBroj = redniBroj;
        this.idAnkete = idAnkete;
    }
    public Long getIdAnkete() {
        return idAnkete;
    }

    public void setIdAnkete(Long idAnkete) {
        this.idAnkete = idAnkete;
    }
    public Pitanje getPitanje() {
        return pitanje;
    }

    public void setPitanje(Pitanje pitanje) {
        this.pitanje = pitanje;
    }

    public Integer getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(Integer redniBroj) {
        this.redniBroj = redniBroj;
    }
}
