/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petit.portfolio.model;


import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 *
 * @author marcelo petit
 */

@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;
     private String apellido;
     private String nombre;
     private String twitter;        
     private String web;        
     private String direccion;
     private String linkedin;
     private String telefono;
     
     
     @OneToMany(mappedBy="persona", cascade = CascadeType.ALL)
     private Set<Educacion> educacion;

     @OneToMany(mappedBy="persona", cascade = CascadeType.ALL)
     private Set<Lenguages> lenguages;

     @OneToMany(mappedBy="persona", cascade = CascadeType.ALL)
     private Set<Experiencia> experiencia;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

     
     
    public Set<Lenguages> getLenguages() {
        return lenguages;
    }

    public void setLenguages(Set<Lenguages> lenguages) {
        this.lenguages = lenguages;
    }

    public Set<Experiencia> getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Set<Experiencia> experiencia) {
        this.experiencia = experiencia;
    }

     
    public Set<Educacion> getEducacion() {
        return educacion;
    }

    public void setEducacion(Set<Educacion> educacion) {
        this.educacion = educacion;
    }
     
     

 //   public Persona(String apellido, String nombre, String twitter, String web, String direccion, String linkedin) {
 //       this.apellido = apellido;
 //       this.nombre = nombre;
 //       this.twitter = twitter;
 //       this.web = web;
 //       this.direccion = direccion;
 //       this.linkedin = linkedin;
 //   }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the twitter
     */
    public String getTwitter() {
        return twitter;
    }

    /**
     * @param twitter the twitter to set
     */
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    /**
     * @return the web
     */
    public String getWeb() {
        return web;
    }

    /**
     * @param web the web to set
     */
    public void setWeb(String web) {
        this.web = web;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the linkedin
     */
    public String getLinkedin() {
        return linkedin;
    }

    /**
     * @param linkedin the linkedin to set
     */
    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
}
