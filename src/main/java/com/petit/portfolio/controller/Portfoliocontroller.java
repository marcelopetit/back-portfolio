
package com.petit.portfolio.controller;

import com.petit.portfolio.model.Educacion;
import com.petit.portfolio.model.Experiencia;
import com.petit.portfolio.model.Lenguages;
import com.petit.portfolio.model.Persona;
import com.petit.portfolio.repository.EducacionRepository;
import com.petit.portfolio.repository.PersonaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 *
 * @author marcelo petit
 */
@RestController
public class Portfoliocontroller {
    
    @Autowired 
    private PersonaRepository personaRepository;
    
  
    
    
    
    @GetMapping("/persona")
    public @ResponseBody Iterable<Persona> persona () {
       return personaRepository.findAll();
      }

     @PostMapping(path="/persona") // Map ONLY POST Requests
  public @ResponseBody String addNewPersona (@RequestParam String nombre
      , @RequestParam String apellido, @RequestParam String direccion, @RequestParam String linkedin, @RequestParam String twitter, @RequestParam String web) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    Persona p = new Persona();
    p.setApellido(apellido);
    p.setDireccion(direccion);
    p.setLinkedin(linkedin);
    p.setNombre(nombre);
    p.setTwitter(twitter);
    p.setWeb(web);
    
    
    Educacion educacion1 = new Educacion ();
    educacion1.setEscala("primaria");
    educacion1.setLugar("bsas");
    educacion1.setTiempo("2002-20010");
    educacion1.setPersona(p);
            
    Educacion educacion2 = new Educacion ();
    educacion2.setEscala("secundaria");
    educacion2.setLugar("bsas");
    educacion2.setTiempo("2010-20014");        
    educacion2.setPersona(p);
    
    
    
    
    
    
    
    p.setEducacion(Set.of(educacion1,educacion2));
    
    personaRepository.save(p);
   // educacionRepository.save(educacion1);
   // educacionRepository.save(educacion2);
    
    
    return "Persona Guardada";
  }
    
  @PostMapping(path="/cargainicial")
  public @ResponseBody String cargaInicial (){
      
      personaRepository.deleteAll();
      
      Persona p = new Persona();
    p.setApellido("Petit");
    p.setDireccion("Direccion: 67 numero 105");
    p.setLinkedin("https://ar.linkedin.com/in/marcelo-petit-5606b7b4");
    p.setNombre("Marcelo");
    p.setTwitter("https://twitter.com/marcelopetit9");
    p.setWeb("portfoliosite.com");
    p.setTelefono("+54 221 5588249");
    
    
    Educacion educacion1 = new Educacion ();
    educacion1.setEscala("primario");
    educacion1.setLugar("Escuela Provincial N°1 “José María Texier”, San Salvador, Entre Ríos.Argentina");
    educacion1.setTiempo("1996-2001");
    educacion1.setPersona(p);
            
    Educacion educacion2 = new Educacion ();
    educacion2.setEscala("secundario");
    educacion2.setLugar("Escuela de Nivel Medio N° 81 “Francisco Ramírez”, San Salvador, Entre Ríos. Título obtenido: Bachiller con orientación en Cs. Humanísticas.");
    educacion2.setTiempo("2001-2007");        
    educacion2.setPersona(p);
    
     Educacion educacion3 = new Educacion ();
    educacion3.setEscala("Universitario");
    educacion3.setLugar("Universidad Nacional de la Plata");
    educacion3.setTiempo("2008-2014");
    educacion3.setPersona(p);
            
    Lenguages lenguages1= new Lenguages();
    lenguages1.setLenguajes("Español");
    lenguages1.setPersona(p);
     Lenguages lenguages2= new Lenguages();
    lenguages2.setLenguajes("Portugues");
     lenguages2.setPersona(p);
    Lenguages lenguages3= new Lenguages();
    lenguages3.setLenguajes("Ingles");
    lenguages3.setPersona(p);
    
    Experiencia experiencia1 = new Experiencia();
    experiencia1.setAño("2007-2009");
    experiencia1.setLugar("Servicio de Catering “Organización Mabel” San Salvador, Entre Ríos, Argentina");
    experiencia1.setActividad("Mozo");
     experiencia1.setPersona(p);
    Experiencia experiencia2 = new Experiencia ();
    experiencia2.setAño("2007-2008");
    experiencia2.setLugar("Discoteca \"La Terraza Disco Pub San Salvador\", Entre Ríos");
    experiencia2.setActividad("Barman");
     experiencia2.setPersona(p);
    Experiencia experiencia3 = new Experiencia ();
    experiencia3.setAño("2007-2009");
    experiencia3.setLugar("Disco-Pub “Gótica” San Salvador, Entre Ríos");
    experiencia3.setActividad("Barman");
    experiencia3.setPersona(p);
     Experiencia experiencia4 = new Experiencia ();
    experiencia4.setAño("Mayo-Agosto de 2008");
    experiencia4.setLugar("Estación de servicio “YPF Servi-compras” San Salvador, Entre Ríos");
     experiencia4.setActividad("Atención al público, manejo de caja, repositor");
    experiencia4.setPersona(p);
      Experiencia experiencia5 = new Experiencia ();
    experiencia5.setAño("Septiembre 2008- Octubre 2009");
    experiencia5.setLugar("Supermercado Cadena DIA San Salvador, Entre Ríos");
    experiencia5.setActividad("Atención al público, manejo de caja, repositor");
     experiencia5.setPersona(p);
     Experiencia experiencia6 = new Experiencia ();
    experiencia6.setAño("Agosto-Diciembre de 2008 (Turno mañana)");
    experiencia6.setLugar("“Tecnocar” Venta de repuestos del automotor, San Salvador, Entre Ríos");
    experiencia6.setActividad("Rider");
      experiencia6.setPersona(p);
      Experiencia experiencia7 = new Experiencia ();
      experiencia7.setAño("Agosto-Diciembre de 2008 (Turno mañana)");
    experiencia7.setLugar("Sección Catastro (Archivo de tasas)");
     experiencia7.setActividad("Archivo de tasas");
    experiencia7.setPersona(p);
    Experiencia experiencia8 = new Experiencia ();
    experiencia8.setAño("Año:Enero -Diciembre 2009)");
    experiencia8.setLugar("Supermercado “Super San” San Salvador, Entre Ríos");
     experiencia8.setActividad("Mantener lleno, limpios y ordenados los lineales de cada sector garantizando la variedad de productos y una excelente experiencia de Compra al cliente tareasCajero/a de supermercado Manejo de la caja registradora Cobro al cliente");
    experiencia8.setPersona(p);
    Experiencia experiencia9 = new Experiencia ();
    experiencia9.setAño("2009");
    experiencia9.setLugar("Confitería Drac” La Plata, Buenos Aires");
    experiencia9.setActividad("Mozo en eventos");
     experiencia9.setPersona(p);
    Experiencia experiencia10 = new Experiencia ();
    experiencia10.setAño("2010 - 2021");
    experiencia10.setLugar("Barman");
    experiencia10.setActividad("Mozo en eventos");
     experiencia10.setPersona(p);
    
    
    
    
    
    
    p.setEducacion(Set.of(educacion1,educacion2));
    p.setExperiencia(Set.of(experiencia1,experiencia2,experiencia3,experiencia4,experiencia5,experiencia6,experiencia7,experiencia8,experiencia9,experiencia10));
     p.setLenguages(Set.of(lenguages1,lenguages2,lenguages3));
    
    personaRepository.save(p);
      
      return "carga completa";
  }
  
  
 /**   @GetMapping("/educacion")
    public String educacion () {
    //    ArrayList <Educacion> educaciones = new ArrayList<>();
    //    Educacion educacion = new Educacion("Escuela Provincial N°1 “José María Texier”, San Salvador, Entre Ríos.Argentina","PrimarioPrimario","1996-2001");
    //    Educacion educacion2 = new Educacion("Escuela Provincial N°2 “José María Texier”, San Salvador, Entre Ríos.Argentina","PrimarioPrimario","1996-2001");
    //    educaciones.add(educacion);
    //    educaciones.add(educacion2);
        return "asd";
      }
    
    @GetMapping("/lenguage")
        public String lenguages () {
            Lenguages lenguages = new Lenguages("Español Ingles Portugues");
                 
            
            
            return lenguages.getLenguajes();
        }
  
        
        @GetMapping("/experiencia")
        public ArrayList<Experiencia> experiencia () {
            ArrayList <Experiencia> experiencias = new ArrayList<>();
            Experiencia   experiencia= new Experiencia("Servicio de Catering Organización Mabel” San Salvador, Entre Ríos, Argentina","2007-2009");
            Experiencia   experiencia2 = new Experiencia("Barman Discoteca La Terraza Disco Pub San Salvador,Entre Ríos", "2007-2008");
            Experiencia   experiencia3 = new Experiencia("Estación de servicio “YPF Servi-compras” San Salvador, Entre Ríos", "Mayo-Agosto de 2008"); 
            Experiencia   experiencia4 = new Experiencia("Supermercado Cadena DIA San Salvador, Entre Ríos", "Septiembre 2008- Octubre 2009");
            Experiencia   experiencia5 = new Experiencia("Rider Tecnocar Venta de repuestos del automotor, San Salvador  Entre Ríos", "Agosto-Diciembre de 2008");
            Experiencia   experiencia6 = new Experiencia("Sección Catastro (Archivo de tasas)", "Agosto-Diciembre de 2008");
            Experiencia   experiencia7 = new Experiencia("Supermercado Super San San, Mantener lleno limpios y ordenados los lineales de cada sector garantizando la variedad de productos y una excelente experiencia de Compra al cliente tareasCajero/a de supermercado, manejo de la caja registradora, Cobro al cliente", "Enero -Diciembre 2009");
            Experiencia  experiencia8 = new Experiencia("Municipalidad San Salvador seccion Catastro", "Agosto-Diciembre de 2008"  );
            Experiencia  experiencia9 = new Experiencia("Confitería Drac” La Plata", "Año: 2009");
            Experiencia  experiencia10 = new Experiencia("Servicio de barras móviles Help Drink", "Año: 2010");
             
              experiencias.add(experiencia);
              experiencias.add(experiencia2);
              experiencias.add(experiencia3);
              experiencias.add(experiencia4);
              experiencias.add(experiencia5);
              experiencias.add(experiencia6);
              experiencias.add(experiencia7);
              experiencias.add(experiencia8);
              experiencias.add(experiencia9);
              experiencias.add(experiencia10);
              
              return experiencias;
        }
   **/     
}
              
        
    
    
    
    
    
    


   