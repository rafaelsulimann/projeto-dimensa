package com.sulimann.dimensa.mappers;

import org.springframework.stereotype.Component;

import com.sulimann.dimensa.dtos.CriarUsuarioRequestDTO;
import com.sulimann.dimensa.dtos.CriarUsuarioResponseDTO;
import com.sulimann.dimensa.entities.Usuario;
import com.sulimann.dimensa.enums.TipoUsuario;

@Component
public class CriarUsuarioMapper {

  public Usuario toEntity(CriarUsuarioRequestDTO request){
    return new Usuario(request.getNome(), request.getEmail(), request.getSenha(), TipoUsuario.valueOf(request.getTipoUsuario()));
  }

  public CriarUsuarioResponseDTO toResponse(Usuario entity){
    return CriarUsuarioResponseDTO.builder()
            .id(entity.getId())
            .nome(entity.getNome())
            .email(entity.getEmail())
            .senha(entity.getSenha())
            .tipoUsuario(entity.getTipoUsuario()).build();
  }

}
