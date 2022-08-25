package br.ueg.modelo.application.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ArmaCriarDTO {
    private String serie;
    private  String cor;
    private Long modeloArma;

    public ArmaCriarDTO() {
    }
}
