/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.petit.portfolio.repository;

import com.petit.portfolio.model.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author marcelo petit
 */
public interface PersonaRepository extends CrudRepository<Persona, Integer>{
    
}
