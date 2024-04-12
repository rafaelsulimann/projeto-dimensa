package com.sulimann.dimensa.dtos;

import com.sulimann.dimensa.constants.ErrorMessage;
import com.sulimann.dimensa.enums.TipoUsuario;
import com.sulimann.dimensa.utils.validators.validenum.ValidEnum;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CriarUsuarioRequestDTO {

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  private String nome;

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  @Email(message = "Email inválido")
  private String email;

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  @Size(min = 6, message = "Mínimo 6 caracteres")
  private String senha;

  @ValidEnum(enumClass = TipoUsuario.class, message = "Tipo Usuário inválido")
  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  private String tipoUsuario;

}
