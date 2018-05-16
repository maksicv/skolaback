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


/**
 *
 * @author bratislav.petrovic
 */
@Entity
public class Pitanje {
    @Id
    @GeneratedValue
    private Long Id;
    
    @Column(length=2000)
    private String description;
    
    @Column(length=2000)
    private String ponudjeniOdgovori;  /* Ovo je string sprakovan kao niz "[dobar, los, zao']" */
    
    
    private String tipPitanja; /* OPEN.. ocekuje string kao odgovor .. RESTRICTED ... izbor iz podnudjeni */

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPonudjeniOdgovori() {
        return ponudjeniOdgovori;
    }

    public void setPonudjeniOdgovori(String ponudjeniOdgovori) {
        this.ponudjeniOdgovori = ponudjeniOdgovori;
    }

    public String getTipPitanja() {
        return tipPitanja;
    }

    public void setTipPitanja(String tipPitanja) {
        this.tipPitanja = tipPitanja;
    }
    
    public void setPonudjeniOdgovori(String[] ponudjeni ){
        this.ponudjeniOdgovori = String.join(",", ponudjeni);
    }
    
    public String[] ponudjeniOdgovori( ){
        String[] ret = this.ponudjeniOdgovori.split(",",-1); 
        return ponudjeniOdgovori();
    }
    
}
