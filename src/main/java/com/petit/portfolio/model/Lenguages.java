/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petit.portfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author marcelo petit
 */

@Entity 
public class Lenguages {
    
     @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;
    private String lenguajes;


 @ManyToOne()
    @JoinColumn(name = "persona_id")
    @JsonBackReference
    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
 
    /**
     * @return the lenguajes
     */
    public String getLenguajes() {
        return lenguajes;
    }

    /**
     * @param lenguajes the lenguajes to set
     */
    public void setLenguajes(String lenguajes) {
        this.lenguajes = lenguajes;
    }
     
}
