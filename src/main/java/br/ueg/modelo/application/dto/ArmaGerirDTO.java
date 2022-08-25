package br.ueg.modelo.application.dto;


import br.ueg.modelo.application.enums.StatusArma;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ArmaGerirDTO {

    private StatusArma status;
    private Long cliente;

    public ArmaGerirDTO() {
    }
}
