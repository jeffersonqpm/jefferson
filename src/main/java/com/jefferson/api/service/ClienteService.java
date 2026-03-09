package com.jefferson.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jefferson.api.model.Cliente;

import com.jefferson.api.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    public ClienteRepository clienteRepository;

    public List<Cliente> listarCliente() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obterDadosCliente(Long id) {
        return clienteRepository.findById(id);

    }

    public Cliente cadastrarCliente(Cliente cliente) {

        return clienteRepository.save(cliente);

    }

    public Cliente atualizarCliente(Long id, Cliente cliente) {

        cliente.setId(id);

        return clienteRepository.save(cliente);

    }

    public void excluir(Long id) {

        clienteRepository.deleteById(id);

    }
}
