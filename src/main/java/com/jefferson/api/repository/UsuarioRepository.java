package com.jefferson.api.repository;

import org.springframework.stereotype.Repository;

import com.jefferson.api.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

}
