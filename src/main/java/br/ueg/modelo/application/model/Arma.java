package br.ueg.modelo.application.model;


import br.ueg.modelo.application.enums.StatusArma;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_arma")
@ToString
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
public class Arma {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arma",length = 9)
    private Long id;

    @Column(name = "serie_arma")
    private String serie;

    @Column(name = "cor_arma")
    private String cor;

    @Column(name = "data_entrada_arma")
    private LocalDate dataEntrada;

    @Column(name = "data_saida_arma")
    private LocalDate dataSaida;

    @Column(name = "status_arma")
    private StatusArma status;

    @ManyToOne
    @JoinColumn(name = "id_modelo_arma")
    private ModeloArma modeloArma;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Arma() {
    }

    public Arma(String serie, String cor, ModeloArma modeloArma) {
        this.serie = serie;
        this.cor = cor;
        this.modeloArma = modeloArma;
    }

    public Arma(Long id, String serie, String cor, LocalDate dataEntrada, LocalDate dataSaida, StatusArma status, ModeloArma modeloArma, Cliente cliente) {
        this.id = id;
        this.serie = serie;
        this.cor = cor;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.status = status;
        this.modeloArma = modeloArma;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public StatusArma getStatus() {
        return status;
    }

    public void setStatus(StatusArma status) {
        this.status = status;
    }

    public ModeloArma getModeloArma() {
        return modeloArma;
    }

    public void setModeloArma(ModeloArma modeloArma) {
        this.modeloArma = modeloArma;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
