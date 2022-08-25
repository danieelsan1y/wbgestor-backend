package br.ueg.modelo.application.model;

import br.ueg.modelo.application.enums.AlmaArma;
import br.ueg.modelo.application.enums.TamanhoArma;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "tb_modelo_arma")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ModeloArma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modelo_arma",length = 9)
    private Long id;

    @Column(name = "tamanho_modelo_arma")
    private TamanhoArma tamanhoArma;

    @Column(name = "quantidade_de_cano_modelo_arma")
    private int quantidadeDeCano;

    @Column(name = "alma_modelo_arma")
    private AlmaArma almaArma;

    @Column(name = "calibre_modelo_arma")
    private String calibre;

    @Column(name = "capacidade_modelo_arma")
    private int capacidade;

    @Column(name = "marca_modelo_arma")
    private String marca;

    @Column(name = "modelo_modelo_arma")
    private String modelo;

    @Column(name = "pais_fabricacao_modelo_arma")
    private String paisFabricacao;

    @Column(name = "preco_modelo_arma")
    private Double preco;

    @JsonIgnore
    @OneToMany(mappedBy = "modeloArma")
    private List<Arma> armas;

    public ModeloArma(TamanhoArma tamanhoArma, int quantidadeDeCano, AlmaArma almaArma, String calibre, int capacidade, String marca, String modelo, String paisFabricacao, Double preco) {
        this.tamanhoArma = tamanhoArma;
        this.quantidadeDeCano = quantidadeDeCano;
        this.almaArma = almaArma;
        this.calibre = calibre;
        this.capacidade = capacidade;
        this.marca = marca;
        this.modelo = modelo;
        this.paisFabricacao = paisFabricacao;
        this.preco = preco;
    }
}
