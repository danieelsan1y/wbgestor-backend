package br.ueg.modelo.application.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ModeloArmaDTO {


    private String tamanho;

    private int quantidadeDeCano;

    private String alma;

    private String calibre;

    private int capacidade;

    private String marca;

    private String modelo;

    private String paisFabricacao;

    private Double preco;

}
