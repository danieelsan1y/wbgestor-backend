package br.ueg.modelo.application.controller;


import br.ueg.modelo.application.dto.AmigoDTO;
import br.ueg.modelo.application.dto.ClienteCriarDTO;
import br.ueg.modelo.application.dto.ClienteListarDTO;
import br.ueg.modelo.application.mapper.ClienteMapper;
import br.ueg.modelo.application.model.Cliente;
import br.ueg.modelo.application.service.ClienteService;
import br.ueg.modelo.comum.exception.MessageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ROLE_CLIENTE_INCLUIR')")
    @PostMapping
    @ApiOperation(value = "Inclusão de Cliente.",
            notes = "Incluir Cliente.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = AmigoDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = MessageResponse.class)
    })
    public ResponseEntity<Void> criar(@RequestBody ClienteCriarDTO clienteCriarDTO) {
        Cliente cliente = clienteMapper.clienteCriarDTOToCliente(clienteCriarDTO);
        clienteService.criar(cliente);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE_VISUALIZAR')")
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    @ApiOperation(value = "Visualizar Cliente.",
            notes = "Visualizar Cliente.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = AmigoDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = MessageResponse.class)
    })
    public ResponseEntity<List<ClienteListarDTO>> listarTodos() {
        List<Cliente> clientes = clienteService.listarTodos();
        List<ClienteListarDTO> clienteListarDTOS = clienteMapper.toClienteListarDTOList(clientes);
        return  ResponseEntity.ok().body(clienteListarDTOS);

    }

    @PreAuthorize("hasRole('ROLE_CLIENTE_PESQUISAR')")
    @GetMapping(path = "/{id:[\\d]+}",produces = { MediaType.APPLICATION_JSON_VALUE })
    @ApiOperation(value = "Pesquisar Cliente.",
            notes = "Pesquisar Cliente.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = AmigoDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = MessageResponse.class)
    })
    ResponseEntity<ClienteListarDTO> buscarPorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        ClienteListarDTO clienteListarDTO = clienteMapper.toCLienteListarDTO(cliente);
        return ResponseEntity.ok().body(clienteListarDTO);
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE_ALTERAR')")
    @PutMapping(path = "/{id:[\\d]+}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Alteração Cliente.",
            notes = "Alterar Cliente.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = AmigoDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = MessageResponse.class)
    })
    ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody ClienteCriarDTO clienteCriarDTO) {
        Cliente cliente = clienteMapper.clienteCriarDTOToCliente(clienteCriarDTO);
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok().build();
    }


    @PreAuthorize("hasRole('ROLE_CLIENTE_STATUS')")
    @PutMapping(path = "inativo/{id:[\\d]+}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Inativar Cliente.",
            notes = "Inativação Cliente.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = AmigoDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = MessageResponse.class)
    })
    ResponseEntity<Void> desativar(@PathVariable Long id) {
        clienteService.desativar(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE_STATUS')")
    @PutMapping(path = "ativo/{id:[\\d]+}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ativar Cliente.",
            notes = "Ativação Status Cliente.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = AmigoDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = MessageResponse.class)
    })
    ResponseEntity<Void> ativar(@PathVariable Long id) {
        clienteService.ativar(id);
        return ResponseEntity.noContent().build();
    }


}
