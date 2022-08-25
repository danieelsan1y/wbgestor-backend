package br.ueg.modelo.application.controller;


import br.ueg.modelo.application.dto.ClienteCriarDTO;
import br.ueg.modelo.application.dto.ClienteListarDTO;
import br.ueg.modelo.application.mapper.ClienteMapper;
import br.ueg.modelo.application.model.Cliente;
import br.ueg.modelo.application.service.ClienteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Cliente API")
@RestController
@RequestMapping(path = "${app.api.base}/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteMapper clienteMapper;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody ClienteCriarDTO clienteCriarDTO) {
        Cliente cliente = clienteMapper.clienteCriarDTOToCliente(clienteCriarDTO);
        clienteService.criar(cliente);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteListarDTO>> listarTodos() {
        List<Cliente> clientes = clienteService.listarTodos();
        List<ClienteListarDTO> clienteListarDTOS = clienteMapper.toClienteListarDTOList(clientes);
        return  ResponseEntity.ok().body(clienteListarDTOS);

    }

    @GetMapping("{id}")
    ResponseEntity<ClienteListarDTO> buscarPorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        ClienteListarDTO clienteListarDTO = clienteMapper.toCLienteListarDTO(cliente);
        return ResponseEntity.ok().body(clienteListarDTO);
    }

    @PutMapping("{id}")
    ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody ClienteCriarDTO clienteCriarDTO) {
        Cliente cliente = clienteMapper.clienteCriarDTOToCliente(clienteCriarDTO);
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "inativo/{id}")
    ResponseEntity<Void> desativar(@PathVariable Long id) {
        clienteService.desativar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "ativo/{id}")
    ResponseEntity<Void> ativar(@PathVariable Long id) {
        clienteService.ativar(id);
        return ResponseEntity.noContent().build();
    }


}
