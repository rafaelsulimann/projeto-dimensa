package com.sulimann.dimensa.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sulimann.dimensa.entities.Usuario;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@And({
  @Spec(path = "nome", spec = LikeIgnoreCase.class),
  @Spec(path = "email", spec = Equal.class)
})
public interface UsuarioSpecification extends Specification<Usuario>{

}
