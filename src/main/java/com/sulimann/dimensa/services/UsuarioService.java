package com.sulimann.dimensa.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sulimann.dimensa.dtos.CriarUsuarioRequestDTO;
import com.sulimann.dimensa.dtos.CriarUsuarioResponseDTO;
import com.sulimann.dimensa.dtos.ListarUsuarioResponseDTO;
import com.sulimann.dimensa.dtos.UsuarioTesteResponse;
import com.sulimann.dimensa.entities.Usuario;
import com.sulimann.dimensa.mappers.CriarUsuarioMapper;
import com.sulimann.dimensa.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

  private final UsuarioRepository repository;
  private final CriarUsuarioMapper mapper;

  public UsuarioService(UsuarioRepository repository, CriarUsuarioMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Transactional
  public CriarUsuarioResponseDTO criarUsuario(CriarUsuarioRequestDTO request){
    Usuario entity = this.mapper.toEntity(request);
    entity = this.repository.save(entity);
    return this.mapper.toResponse(entity);
  }

  public Page<ListarUsuarioResponseDTO> listarUsuarios(Pageable pageable, Specification spec){
    Page<Usuario> pageUsuarios = this.repository.findAll(spec, pageable);
    return pageUsuarios.map(ListarUsuarioResponseDTO::new);
  }

  public UsuarioTesteResponse teste(Long id){
    return this.repository.retornarEmail(id).get();
  }

}
