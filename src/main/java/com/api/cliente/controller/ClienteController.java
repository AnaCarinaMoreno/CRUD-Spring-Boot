package com.api.cliente.controller;

import com.api.cliente.entity.Cliente;
import com.api.cliente.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @GetMapping("/cliente")

    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable Integer id) {
        try {
            Cliente cliente = clienteService.getClienteById(id);
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);

        } catch (Exception exception) {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/clientes")
    public void guardarCliente(@RequestBody Cliente cliente){
        clienteService.guardarCliente(cliente);
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente cliente, @PathVariable Integer id) {

        try {
            Cliente Existecliente = clienteService.getClienteById(id);
            clienteService.guardarCliente(cliente);
            return new ResponseEntity<Cliente>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity <Cliente> eliminarCliente(@PathVariable Integer id){
        try {
            Cliente existeCliente = clienteService.getClienteById(id);
            clienteService.deleteClienteById(id);
            return new ResponseEntity<Cliente>(existeCliente, HttpStatus.OK);

        }catch (Exception exception){
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);

        }

    }

}
