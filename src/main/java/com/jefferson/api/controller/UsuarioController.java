package com.jefferson.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jefferson.api.model.Usuario;
import com.jefferson.api.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.cadastrarUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuario() {
        return ResponseEntity.ok(usuarioService.listarUser());
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> obeterDadosPeloId(@PathVariable Long id) {

        Optional<Usuario> usuario = usuarioService.obterDadosUsuarios(id);

        if (usuario.isEmpty()) {
            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(usuario.get());

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.obterDadosUsuarios(id);

        if (usuario.isEmpty()) {

            return ResponseEntity.notFound().build();

        }

        usuarioService.excluirUsuario(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario dadosUsuario) {
        Optional<Usuario> usuario = usuarioService.obterDadosUsuarios(id);

        if (usuario.isEmpty()) {

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(usuarioService.atualizarUsuario(id, dadosUsuario));

    }

}
