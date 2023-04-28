
package com.proyectointegrador.TamyOshiro.Repository;

import com.proyectointegrador.TamyOshiro.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long> {
    
}
