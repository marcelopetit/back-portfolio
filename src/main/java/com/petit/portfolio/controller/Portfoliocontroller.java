
package com.petit.portfolio.controller;

import com.petit.portfolio.model.Educacion;
import com.petit.portfolio.model.Experiencia;
import com.petit.portfolio.model.Lenguages;
import com.petit.portfolio.model.Persona;
import com.petit.portfolio.repository.EducacionRepository;
import com.petit.portfolio.repository.ExperienciaRepository;
import com.petit.portfolio.repository.LenguagesRepository;
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
    private EducacionRepository educacionRepository;
    private ExperienciaRepository experienciaRepository;
    private LenguagesRepository lenguagesRepository;
    
    
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
    educacion1.setLugar("Escuela Provincial N??1 ???Jos?? Mar??a Texier???, San Salvador, Entre R??os.Argentina");
    educacion1.setTiempo("1996-2001");
    educacion1.setPersona(p);
            
    Educacion educacion2 = new Educacion ();
    educacion2.setEscala("secundario");
    educacion2.setLugar("Escuela de Nivel Medio N?? 81 ???Francisco Ram??rez???, San Salvador, Entre R??os. T??tulo obtenido: Bachiller con orientaci??n en Cs. Human??sticas.");
    educacion2.setTiempo("2001-2007");        
    educacion2.setPersona(p);
    
     Educacion educacion3 = new Educacion ();
    educacion3.setEscala("Universitario");
    educacion3.setLugar("Universidad Nacional de la Plata");
    educacion3.setTiempo("2008-2014");
    educacion3.setPersona(p);
            
    Lenguages lenguages1= new Lenguages();
    lenguages1.setLenguajes("Espa??ol");
    lenguages1.setPersona(p);
     Lenguages lenguages2= new Lenguages();
    lenguages2.setLenguajes("Portugues");
     lenguages2.setPersona(p);
    Lenguages lenguages3= new Lenguages();
    lenguages3.setLenguajes("Ingles");
    lenguages3.setPersona(p);
    
    Experiencia experiencia1 = new Experiencia();
    experiencia1.setA??o("2007-2009");
    experiencia1.setLugar("Servicio de Catering ???Organizaci??n Mabel??? San Salvador, Entre R??os, Argentina");
    experiencia1.setActividad("Mozo");
     experiencia1.setPersona(p);
    Experiencia experiencia2 = new Experiencia ();
    experiencia2.setA??o("2007-2008");
    experiencia2.setLugar("Discoteca \"La Terraza Disco Pub San Salvador\", Entre R??os");
    experiencia2.setActividad("Barman");
     experiencia2.setPersona(p);
    Experiencia experiencia3 = new Experiencia ();
    experiencia3.setA??o("2007-2009");
    experiencia3.setLugar("Disco-Pub ???G??tica??? San Salvador, Entre R??os");
    experiencia3.setActividad("Barman");
    experiencia3.setPersona(p);
     Experiencia experiencia4 = new Experiencia ();
    experiencia4.setA??o("Mayo-Agosto de 2008");
    experiencia4.setLugar("Estaci??n de servicio ???YPF Servi-compras??? San Salvador, Entre R??os");
     experiencia4.setActividad("Atenci??n al p??blico, manejo de caja, repositor");
    experiencia4.setPersona(p);
      Experiencia experiencia5 = new Experiencia ();
    experiencia5.setA??o("Septiembre 2008- Octubre 2009");
    experiencia5.setLugar("Supermercado Cadena DIA San Salvador, Entre R??os");
    experiencia5.setActividad("Atenci??n al p??blico, manejo de caja, repositor");
     experiencia5.setPersona(p);
     Experiencia experiencia6 = new Experiencia ();
    experiencia6.setA??o("Agosto-Diciembre de 2008 (Turno ma??ana)");
    experiencia6.setLugar("???Tecnocar??? Venta de repuestos del automotor, San Salvador, Entre R??os");
    experiencia6.setActividad("Rider");
      experiencia6.setPersona(p);
      Experiencia experiencia7 = new Experiencia ();
      experiencia7.setA??o("Agosto-Diciembre de 2008 (Turno ma??ana)");
    experiencia7.setLugar("Secci??n Catastro (Archivo de tasas)");
     experiencia7.setActividad("Archivo de tasas");
    experiencia7.setPersona(p);
    Experiencia experiencia8 = new Experiencia ();
    experiencia8.setA??o("A??o:Enero -Diciembre 2009)");
    experiencia8.setLugar("Supermercado ???Super San??? San Salvador, Entre R??os");
     experiencia8.setActividad("Mantener lleno, limpios y ordenados los lineales de cada sector garantizando la variedad de productos y una excelente experiencia de Compra al cliente tareasCajero/a de supermercado Manejo de la caja registradora Cobro al cliente");
    experiencia8.setPersona(p);
    Experiencia experiencia9 = new Experiencia ();
    experiencia9.setA??o("2009");
    experiencia9.setLugar("Confiter??a Drac??? La Plata, Buenos Aires");
    experiencia9.setActividad("Mozo en eventos");
     experiencia9.setPersona(p);
    Experiencia experiencia10 = new Experiencia ();
    experiencia10.setA??o("2010 - 2021");
    experiencia10.setLugar("Barman");
    experiencia10.setActividad("Mozo en eventos");
     experiencia10.setPersona(p);
    
    
    
    
    
    
    p.setEducacion(Set.of(educacion1,educacion2));
    p.setExperiencia(Set.of(experiencia1,experiencia2,experiencia3,experiencia4,experiencia5,experiencia6,experiencia7,experiencia8,experiencia9,experiencia10));
     p.setLenguages(Set.of(lenguages1,lenguages2,lenguages3));
    
    personaRepository.save(p);
      
      return "carga completa";
  }
  
  
    @GetMapping("/educacion")
    public @ResponseBody Iterable<Educacion> educacion () {
       return educacionRepository.findAll();
      }
  
  
   @GetMapping("/experiencia")
    public @ResponseBody Iterable<Experiencia> experiencia () {
       return experienciaRepository.findAll();
      }
  
     @GetMapping("/lenguages")
    public @ResponseBody Iterable<Lenguages> lenguages () {
       return lenguagesRepository.findAll();
      }
    
    
 /**   @GetMapping("/educacion")
    public String educacion () {
    //    ArrayList <Educacion> educaciones = new ArrayList<>();
    //    Educacion educacion = new Educacion("Escuela Provincial N??1 ???Jos?? Mar??a Texier???, San Salvador, Entre R??os.Argentina","PrimarioPrimario","1996-2001");
    //    Educacion educacion2 = new Educacion("Escuela Provincial N??2 ???Jos?? Mar??a Texier???, San Salvador, Entre R??os.Argentina","PrimarioPrimario","1996-2001");
    //    educaciones.add(educacion);
    //    educaciones.add(educacion2);
        return "asd";
      }
    
    @GetMapping("/lenguage")
        public String lenguages () {
            Lenguages lenguages = new Lenguages("Espa??ol Ingles Portugues");
                 
            
            
            return lenguages.getLenguajes();
        }
  
        
        @GetMapping("/experiencia")
        public ArrayList<Experiencia> experiencia () {
            ArrayList <Experiencia> experiencias = new ArrayList<>();
            Experiencia   experiencia= new Experiencia("Servicio de Catering Organizaci??n Mabel??? San Salvador, Entre R??os, Argentina","2007-2009");
            Experiencia   experiencia2 = new Experiencia("Barman Discoteca La Terraza Disco Pub San Salvador,Entre R??os", "2007-2008");
            Experiencia   experiencia3 = new Experiencia("Estaci??n de servicio ???YPF Servi-compras??? San Salvador, Entre R??os", "Mayo-Agosto de 2008"); 
            Experiencia   experiencia4 = new Experiencia("Supermercado Cadena DIA San Salvador, Entre R??os", "Septiembre 2008- Octubre 2009");
            Experiencia   experiencia5 = new Experiencia("Rider Tecnocar Venta de repuestos del automotor, San Salvador  Entre R??os", "Agosto-Diciembre de 2008");
            Experiencia   experiencia6 = new Experiencia("Secci??n Catastro (Archivo de tasas)", "Agosto-Diciembre de 2008");
            Experiencia   experiencia7 = new Experiencia("Supermercado Super San San, Mantener lleno limpios y ordenados los lineales de cada sector garantizando la variedad de productos y una excelente experiencia de Compra al cliente tareasCajero/a de supermercado, manejo de la caja registradora, Cobro al cliente", "Enero -Diciembre 2009");
            Experiencia  experiencia8 = new Experiencia("Municipalidad San Salvador seccion Catastro", "Agosto-Diciembre de 2008"  );
            Experiencia  experiencia9 = new Experiencia("Confiter??a Drac??? La Plata", "A??o: 2009");
            Experiencia  experiencia10 = new Experiencia("Servicio de barras m??viles Help Drink", "A??o: 2010");
             
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
              
        
    
    
    
    
    
    


   