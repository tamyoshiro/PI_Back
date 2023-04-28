
package com.proyectointegrador.TamyOshiro.Security.Repository;

import com.proyectointegrador.TamyOshiro.Security.Entity.Rol;
import com.proyectointegrador.TamyOshiro.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
