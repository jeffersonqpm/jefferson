package com.jefferson.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jefferson.api.model.Cliente;
import com.jefferson.api.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    public ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteService.cadastrarCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> litarClientes(){

        return ResponseEntity.ok(clienteService.listarCliente());
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> obterDadosPorId(@PathVariable Long id){

        Optional<Cliente> cliente = clienteService.obterDadosCliente(id);

        if(cliente.isEmpty()){

            return ResponseEntity.notFound().build();
            
        }
        return ResponseEntity.ok(cliente.get());
    }

}
