package com.sulimann.dimensa.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.dimensa.constants.Path;
import com.sulimann.dimensa.dtos.CriarUsuarioRequestDTO;
import com.sulimann.dimensa.dtos.CriarUsuarioResponseDTO;
import com.sulimann.dimensa.dtos.ListarUsuarioResponseDTO;
import com.sulimann.dimensa.dtos.UsuarioTesteResponse;
import com.sulimann.dimensa.services.UsuarioService;
import com.sulimann.dimensa.specification.UsuarioSpecification;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = Path.USUARIO)
public class UsuarioController {

  private final UsuarioService service;

  public UsuarioController(UsuarioService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<CriarUsuarioResponseDTO> criarUsuario(@RequestBody @Valid CriarUsuarioRequestDTO request){
    return ResponseEntity.status(HttpStatus.CREATED).body(this.service.criarUsuario(request));
  }

  @GetMapping
  public ResponseEntity<Page<ListarUsuarioResponseDTO>> listarUsuario(UsuarioSpecification spec,
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
    return ResponseEntity.status(HttpStatus.OK).body(this.service.listarUsuarios(pageable, spec));
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<UsuarioTesteResponse> retornarEmail(@PathVariable Long id){
    return ResponseEntity.status(HttpStatus.OK).body(this.service.teste(id));
  }
}
