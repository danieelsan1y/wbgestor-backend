package br.ueg.modelo.application.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ClienteCriarDTO {
    private Long id;

    private String nome;
    private String statusCliente;
    private String cpf;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataDeNacimento;
    private String endereco;
    private String telefone;
    private String cr;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate validadeCR;

    public ClienteCriarDTO() {
    }

    public ClienteCriarDTO(Long id, String nome, String statusCliente, String cpf, LocalDate dataDeNacimento, String endereco, String telefone, String cr, LocalDate validadeCR) {
        this.id = id;
        this.nome = nome;
        this.statusCliente = statusCliente;
        this.cpf = cpf;
        this.dataDeNacimento = dataDeNacimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cr = cr;
        this.validadeCR = validadeCR;
    }

    public ClienteCriarDTO(String nome, String cpf, LocalDate dataDeNacimento, String endereco, String telefone, String cr, LocalDate validadeCR) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNacimento = dataDeNacimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cr = cr;
        this.validadeCR = validadeCR;
    }

    public ClienteCriarDTO(String statusCliente) {
        this.statusCliente = statusCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeNacimento() {
        return dataDeNacimento;
    }

    public void setDataDeNacimento(LocalDate dataDeNacimento) {
        this.dataDeNacimento = dataDeNacimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCr() {
        return cr;
    }

    public void setCr(String cr) {
        this.cr = cr;
    }

    public LocalDate getValidadeCR() {
        return validadeCR;
    }

    public void setValidadeCR(LocalDate validadeCR) {
        this.validadeCR = validadeCR;
    }

    public String getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(String statusCliente) {
        this.statusCliente = statusCliente;
    }
}
