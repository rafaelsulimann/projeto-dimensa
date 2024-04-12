package com.sulimann.dimensa.dtos;

import com.sulimann.dimensa.enums.TipoUsuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CriarUsuarioResponseDTO {

  private Long id;
  private String nome;
  private String email;
  private String senha;
  private TipoUsuario tipoUsuario;

}
