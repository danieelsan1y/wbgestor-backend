package br.ueg.modelo.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModeloArmaListarDTO {

    private Long id;

    private String tamanho;

    private int quantidadeDeCano;

    private String alma;

    private String calibre;

    private int capacidade;

    private String marca;

    private String modelo;

    private String paisFabricacao;

    private Double preco;

    public ModeloArmaListarDTO() {
    }
}
