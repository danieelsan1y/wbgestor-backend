package br.ueg.modelo.application.model;


import br.ueg.modelo.application.enums.StatusCliente;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    private Long id;

    @Column(name = "nome_cliente")
    private String nome;

    @Column(name = "status_cliente")
    private StatusCliente statusCliente;

    @Column(name = "cpf_cliente")
    private String cpf;

    @Column(name = "data_de_nascimento_cliente")
    private LocalDate dataDeNacimento;

    @Column(name = "endereco_cliente")
    private String endereco;

    @Column(name = "telefone_cliente")
    private String telefone;

    @Column(name = "cr_cliente")
    private String cr;

    @Column(name = "validade_cr_cliente")
    private LocalDate validadeCR;

    @OneToMany(mappedBy = "cliente")
    private List<Arma> armas;

    @OneToMany(mappedBy = "cliente")
    private List<Municao> municoes;

    @OneToMany(mappedBy = "cliente")
    private List<Movimentacao> movimentacoes;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String cpf, LocalDate dataDeNacimento, String endereco, String telefone, String cr, LocalDate validadeCR) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNacimento = dataDeNacimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cr = cr;
        this.validadeCR = validadeCR;
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

    public StatusCliente getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(StatusCliente statusCliente) {
        this.statusCliente = statusCliente;
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

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    @Override
    public String toString() {
        return nome ;
    }
}
