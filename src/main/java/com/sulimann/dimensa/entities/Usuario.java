package com.sulimann.dimensa.entities;

import com.sulimann.dimensa.constants.TableName;
import com.sulimann.dimensa.enums.TipoUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = TableName.USUARIO)
@NoArgsConstructor
@Data
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome")
  private String nome;

  private String email;
  private String senha;

  @Enumerated(EnumType.STRING)
  private TipoUsuario tipoUsuario;

  public Usuario(String nome, String email, String senha, TipoUsuario tipoUsuario) {
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.tipoUsuario = tipoUsuario;
  }

}
