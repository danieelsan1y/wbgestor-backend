package br.ueg.modelo.application.controller;


import br.ueg.modelo.application.dto.ModeloArmaDTO;
import br.ueg.modelo.application.dto.ModeloArmaListarDTO;
import br.ueg.modelo.application.mapper.ModeloArmaMapper;
import br.ueg.modelo.application.model.ModeloArma;
import br.ueg.modelo.application.service.ModeloArmaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Arma API")
@RestController
@RequestMapping(path = "${app.api.base}/modeloarma")

public class ModeloArmaController {

    @Autowired
    ModeloArmaService modeloArmaService;

    @Autowired
    ModeloArmaMapper modeloArmaMapper;



    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody ModeloArmaDTO modeloArmaDTO) {
        ModeloArma modeloArma = modeloArmaMapper.toModeloArma(modeloArmaDTO);
        modeloArmaService.criar(modeloArma);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ModeloArmaListarDTO>> listarTodos() {
        List<ModeloArma> modeloArmas = modeloArmaService.listarTodos();
        List<ModeloArmaListarDTO> modeloArmaListarDTOS = modeloArmaMapper.toModeloArmaListarDTOList(modeloArmas);
        return ResponseEntity.ok().body(modeloArmaListarDTOS);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody ModeloArmaDTO modeloArmaDTO) {
        ModeloArma modeloArma = modeloArmaMapper.toModeloArma(modeloArmaDTO);
        modeloArmaService.atualizar(id, modeloArma);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloArmaListarDTO> buscarPorId(@PathVariable Long id) {

        ModeloArma modeloArma = modeloArmaService.buscarPorId(id);
        ModeloArmaListarDTO modeloArmaListarDTO = modeloArmaMapper.toModeloArmaListarDTO(modeloArma);
        return ResponseEntity.ok().body(modeloArmaListarDTO);
    }


}
