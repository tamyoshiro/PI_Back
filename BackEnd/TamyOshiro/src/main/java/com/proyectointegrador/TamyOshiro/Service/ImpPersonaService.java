
package com.proyectointegrador.TamyOshiro.Service;

import com.proyectointegrador.TamyOshiro.Entity.Persona;
import java.util.List;
import com.proyectointegrador.TamyOshiro.Interface.IPersonaService;
import org.springframework.stereotype.Service;
import com.proyectointegrador.TamyOshiro.Repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class ImpPersonaService implements IPersonaService {
    @Autowired IPersonaRepository ipersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
}
