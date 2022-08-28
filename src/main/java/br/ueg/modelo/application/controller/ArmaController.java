package br.ueg.modelo.application.controller;

import br.ueg.modelo.application.dto.*;
import br.ueg.modelo.application.mapper.ArmaMapper;
import br.ueg.modelo.application.model.Arma;
import br.ueg.modelo.application.model.ModeloArma;
import br.ueg.modelo.application.service.ArmaService;
import br.ueg.modelo.comum.exception.MessageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "Arma API")
@RestController
@RequestMapping(path = "${app.api.base}/arma")

public class ArmaController {

    @Autowired
    ArmaService armaService;

    @Autowired
    ArmaMapper armaMapper;

    @PreAuthorize("hasRole('ROLE_ENTRADAARMA_INCLUIR')")
    @PostMapping("/entrada")
    @ApiOperation(value = "Entrada de Arma.",
            notes = "Dar Entrada em Arma.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ArmaCriarDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = MessageResponse.class)
    })
    public ResponseEntity<Void> realizarEntrada(@RequestBody ArmaCriarDTO armaCriarDTO) {
        Arma arma = armaMapper.armaCriarDTOToArma(armaCriarDTO);
        armaService.realizarEntrada(arma, armaCriarDTO.getModeloArma());
        return ResponseEntity.ok().build();
    }


    @PreAuthorize("hasRole('ROLE_TRAFEGARARMAS_OPERACAO')")
    @PutMapping(path = "operacao/{id:[\\d]+}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Trafegação Arma.",
            notes = "Trafegar Arma.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ArmaGerirDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = MessageResponse.class)
    })
    public ResponseEntity<Void> trafegar(@PathVariable Long id, @RequestBody ArmaGerirDTO armaGerirDTO) {
        armaService.trafegar(id,armaGerirDTO.getStatus(),armaGerirDTO.getCliente());
        return ResponseEntity.ok().build();
    }


    @PreAuthorize("hasRole('ROLE_SAIDAARMA_SAIDA')")
    @PutMapping(path = "saida/{id:[\\d]+}")
    @ApiOperation(value = "Saida Arma.",
            notes = "Sair Arma.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ArmaCriarDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = MessageResponse.class)
    })
    public ResponseEntity<Void> realizarSaida(@PathVariable Long id) {
        armaService.realizarSaida(id);
        return ResponseEntity.ok().build();
    }


    @PreAuthorize("hasRole('ROLE_GERENCIARARMA_VISUALIZAR')")
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    @ApiOperation(value = "Visualizar Arma.",
            notes = "Visualizar Arma.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ArmaListarDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = MessageResponse.class)
    })
    public ResponseEntity<List<ArmaListarDTO>> buscarArmas() {
        List<Arma> armas = armaService.buscarTodas();
        List<ArmaListarDTO> armaListarDTOS = armaMapper.toArmaDTOList(armas);
        return ResponseEntity.ok().body(armaListarDTOS);
    }

    @PreAuthorize("hasRole('ROLE_GERENCIARARMA_ALTERAR')")
    @PutMapping(path = "/{id:[\\d]+}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Alteração de Arma.",
            notes = "Alterar Arma.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ModeloArmaDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = MessageResponse.class)
    })
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody ArmaAtualizarDTO armaAtualizarDTO) {
        Arma arma = armaMapper.ArmaAtualizarDTOToArma(armaAtualizarDTO);
        armaService.atualizar(arma,id, armaAtualizarDTO.getCliente(), armaAtualizarDTO.getModeloArma());
        return ResponseEntity.ok().build();
    }


    @PreAuthorize("hasRole('ROLE_GERENCIARARMA_PESQUISAR')")
    @GetMapping(path = "/{id:[\\d]+}",produces = { MediaType.APPLICATION_JSON_VALUE })
    @ApiOperation(value = "Pesquisa de Arma.",
            notes = "Pesquisar Arma.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ArmaListarDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = MessageResponse.class)
    })
    ResponseEntity<ArmaListarDTO> buscarPorId(@PathVariable Long id) {
        Arma arma = armaService.buscarPorId(id);
        ArmaListarDTO armaListarDTOS = armaMapper.armaListarDTO(arma);
        return ResponseEntity.ok().body(armaListarDTOS);
    }

    @PreAuthorize("hasRole('ROLE_SAIDAARMA_VENDIDASEMESTOQUE')")
    @GetMapping(path = "/vendidas",produces = { MediaType.APPLICATION_JSON_VALUE })
    @ApiOperation(value = "Visualizar Arma.",
            notes = "Visualizar Arma.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ArmaListarDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = MessageResponse.class)
    })
    public ResponseEntity<List<ArmaListarDTO>> buscarArmasVendidasEmEstoque() {
        List<Arma> armas = armaService.buscarArmasVendidasEmEstoque();
        List<ArmaListarDTO> armaListarDTOS = armaMapper.toArmaDTOList(armas);
        return ResponseEntity.ok().body(armaListarDTOS);
    }

}
