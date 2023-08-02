package com.api.cliente.services;

import com.api.cliente.entity.Cliente;
import com.api.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> listarClientes(){
        return  clienteRepository.findAll();
    }

    public void guardarCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public Cliente getClienteById(Integer id){
        return clienteRepository.findById(id).get();
    }

    public void deleteClienteById(Integer id){
        clienteRepository.deleteById(id);
    }
}
