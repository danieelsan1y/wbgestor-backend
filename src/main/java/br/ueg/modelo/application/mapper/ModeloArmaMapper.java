package br.ueg.modelo.application.mapper;

import br.ueg.modelo.application.dto.ModeloArmaDTO;
import br.ueg.modelo.application.dto.ModeloArmaListarDTO;
import br.ueg.modelo.application.model.ModeloArma;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModeloArmaMapper {
    private static  final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ModeloArmaDTO toModeloArmaDTO(ModeloArma modeloArma) {
        return MODEL_MAPPER.map(modeloArma, ModeloArmaDTO.class);
    }

    public ModeloArmaListarDTO toModeloArmaListarDTO(ModeloArma modeloArma) {
        return MODEL_MAPPER.map(modeloArma, ModeloArmaListarDTO.class);
    }

    public ModeloArma toModeloArma(ModeloArmaDTO modeloArmaDTO) {
        return  MODEL_MAPPER.map(modeloArmaDTO,ModeloArma.class);
    }

    public List<ModeloArmaListarDTO> toModeloArmaListarDTOList(List<ModeloArma> modeloArmas) {
        List<ModeloArmaListarDTO> modeloArmaListarDTOS = modeloArmas.stream().map(modeloArma -> toModeloArmaListarDTO(modeloArma)).collect(Collectors.toList());
        return modeloArmaListarDTOS;
    }

}
