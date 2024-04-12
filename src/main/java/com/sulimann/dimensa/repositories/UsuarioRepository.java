package com.sulimann.dimensa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sulimann.dimensa.dtos.UsuarioTesteResponse;
import com.sulimann.dimensa.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario>{

  boolean existsByNome(String nome);
  Optional<Usuario> findByNome(String nome);

  @Query(value = "SELECT new com.sulimann.dimensa.dtos.UsuarioTesteResponse(obj.email) FROM Usuario obj WHERE obj.id=:id")
  Optional<UsuarioTesteResponse> retornarEmail(@Param("id") Long id);

}
