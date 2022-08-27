package br.ueg.modelo.application.controller;


import br.ueg.modelo.application.dto.AmigoDTO;
import br.ueg.modelo.application.dto.ModeloArmaDTO;
import br.ueg.modelo.application.dto.ModeloArmaListarDTO;
import br.ueg.modelo.application.mapper.ModeloArmaMapper;
import br.ueg.modelo.application.model.ModeloArma;
import br.ueg.modelo.application.service.ModeloArmaService;
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

@Api(tags = "Arma API")
@RestController
@RequestMapping(path = "${app.api.base}/modeloarma")

public class ModeloArmaController {

    @Autowired
    ModeloArmaService modeloArmaService;

    @Autowired
    ModeloArmaMapper modeloArmaMapper;


    @PreAuthorize("hasRole('ROLE_MODELOARMA_INCLUIR')")
    @PostMapping
    @ApiOperation(value = "Inclusão de ModeloArma.",
            notes = "Incluir ModeloArma.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = AmigoDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = MessageResponse.class)
    })
    public ResponseEntity<Void> criar(@RequestBody ModeloArmaDTO modeloArmaDTO) {
        ModeloArma modeloArma = modeloArmaMapper.toModeloArma(modeloArmaDTO);
        modeloArmaService.criar(modeloArma);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ROLE_MODELOARMA_VISUALIZAR')")
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    @ApiOperation(value = "Visualizar ModeloArma.",
            notes = "Visualizar ModeloArma.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = AmigoDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = MessageResponse.class)
    })
    public ResponseEntity<List<ModeloArmaListarDTO>> listarTodos() {
        List<ModeloArma> modeloArmas = modeloArmaService.listarTodos();
        List<ModeloArmaListarDTO> modeloArmaListarDTOS = modeloArmaMapper.toModeloArmaListarDTOList(modeloArmas);
        return ResponseEntity.ok().body(modeloArmaListarDTOS);
    }


    @PreAuthorize("hasRole('ROLE_MODELOARMA_ALTERAR')")
    @PutMapping(path = "/{id:[\\d]+}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Alteração ModeloArma.",
            notes = "Alterar ModeloArma.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = AmigoDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = MessageResponse.class)
    })
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody ModeloArmaDTO modeloArmaDTO) {
        ModeloArma modeloArma = modeloArmaMapper.toModeloArma(modeloArmaDTO);
        modeloArmaService.atualizar(id, modeloArma);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ROLE_MODELOARMA_PESQUISAR')")
    @GetMapping(path = "/{id:[\\d]+}",produces = { MediaType.APPLICATION_JSON_VALUE })
    @ApiOperation(value = "Pesquisar ModeloArma.",
            notes = "Pesquisar ModeloArma.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = AmigoDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = MessageResponse.class)
    })
    public ResponseEntity<ModeloArmaListarDTO> buscarPorId(@PathVariable Long id) {

        ModeloArma modeloArma = modeloArmaService.buscarPorId(id);
        ModeloArmaListarDTO modeloArmaListarDTO = modeloArmaMapper.toModeloArmaListarDTO(modeloArma);
        return ResponseEntity.ok().body(modeloArmaListarDTO);
    }


}
