package com.sulimann.dimensa.dtos;

import com.sulimann.dimensa.entities.Usuario;
import com.sulimann.dimensa.enums.TipoUsuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ListarUsuarioResponseDTO {

  private Long id;
  private String nome;
  private String email;
  private String senha;
  private TipoUsuario tipoUsuario;

  public ListarUsuarioResponseDTO(Usuario entity) {
    this.id = entity.getId();
    this.nome = entity.getNome();
    this.email = entity.getEmail();
    this.senha = entity.getSenha();
    this.tipoUsuario = entity.getTipoUsuario();
  }
}
