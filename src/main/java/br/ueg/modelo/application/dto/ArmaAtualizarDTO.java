package br.ueg.modelo.application.dto;

import br.ueg.modelo.application.enums.StatusArma;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArmaAtualizarDTO {


    private String serie;
    private String cor;
    private StatusArma status;
    private Long modeloArma;

    private Long cliente;

    public ArmaAtualizarDTO() {
    }

}
