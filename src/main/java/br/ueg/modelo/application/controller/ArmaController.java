package br.ueg.modelo.application.controller;

import br.ueg.modelo.application.dto.ArmaCriarDTO;
import br.ueg.modelo.application.dto.ArmaGerirDTO;
import br.ueg.modelo.application.dto.ArmaListarDTO;
import br.ueg.modelo.application.mapper.ArmaMapper;
import br.ueg.modelo.application.model.Arma;
import br.ueg.modelo.application.service.ArmaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("entrada")
    public ResponseEntity<Void> realizarEntrada(@RequestBody ArmaCriarDTO armaCriarDTO) {
        Arma arma = armaMapper.armaCriarDTOToArma(armaCriarDTO);
        armaService.realizarEntrada(arma, armaCriarDTO.getModeloArma());
        return ResponseEntity.ok().build();
    }

    @PutMapping("operacao/{id}")
    public ResponseEntity<Void> gerir(@PathVariable Long id, @RequestBody ArmaGerirDTO armaGerirDTO) {
        armaService.gerir(id,armaGerirDTO.getStatus(),armaGerirDTO.getCliente());
        return ResponseEntity.ok().build();
    }


    @PutMapping("saida/{id}")
    public ResponseEntity<Void> realizarSaida(@PathVariable Long id) {
        armaService.realizarSaida(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ArmaListarDTO>> buscarArmas() {
        List<Arma> armas = armaService.buscarTodas();
        List<ArmaListarDTO> armaListarDTOS = armaMapper.toArmaDTOList(armas);
        return ResponseEntity.ok().body(armaListarDTOS);
    }

    @GetMapping("{id}")
    ResponseEntity<ArmaListarDTO> buscarPorId(@PathVariable Long id) {
        Arma arma = armaService.buscarPorId(id);
        ArmaListarDTO armaListarDTOS = armaMapper.armaListarDTO(arma);
        return ResponseEntity.ok().body(armaListarDTOS);
    }

}
