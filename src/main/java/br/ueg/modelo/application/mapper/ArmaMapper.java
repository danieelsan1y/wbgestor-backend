package br.ueg.modelo.application.mapper;
import br.ueg.modelo.application.dto.ArmaAtualizarDTO;
import br.ueg.modelo.application.dto.ArmaCriarDTO;
import br.ueg.modelo.application.dto.ArmaGerirDTO;
import br.ueg.modelo.application.dto.ArmaListarDTO;
import br.ueg.modelo.application.model.Arma;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArmaMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ArmaCriarDTO toArmaCriarDTO(Arma arma) {
        return MODEL_MAPPER.map(arma, ArmaCriarDTO.class);
    }
    public ArmaListarDTO armaListarDTO(Arma arma) {
        return MODEL_MAPPER.map(arma, ArmaListarDTO.class);
    }

    public Arma armaCriarDTOToArma(ArmaCriarDTO armaCriarDTO) {
        return MODEL_MAPPER.map(armaCriarDTO, Arma.class);
    }

    public Arma ArmaGerirDTOToArma(ArmaGerirDTO armaGerirDTO) {
        return MODEL_MAPPER.map(armaGerirDTO, Arma.class);
    }

    public Arma ArmaAtualizarDTOToArma(ArmaAtualizarDTO armaAtualizarDTO) {
        return MODEL_MAPPER.map(armaAtualizarDTO, Arma.class);
    }


    public ArmaAtualizarDTO toArmaAtualizarDTO(Arma arma) {
        return MODEL_MAPPER.map(arma, ArmaAtualizarDTO.class);
    }
    public List<ArmaListarDTO> toArmaDTOList(List<Arma> armas) {
        List<ArmaListarDTO> armaListarDTOS = armas.stream().map(arma -> armaListarDTO(arma)).collect(Collectors.toList());
        return armaListarDTOS;
    }
}
