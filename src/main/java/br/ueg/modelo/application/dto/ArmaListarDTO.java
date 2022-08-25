package br.ueg.modelo.application.dto;

import br.ueg.modelo.application.enums.StatusArma;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArmaListarDTO {

    private Long id;
    private String serie;
    private String cor;

    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private StatusArma status;
    private String modeloArma;

    private String cliente;

    public ArmaListarDTO() {
    }

}
