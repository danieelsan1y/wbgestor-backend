package br.ueg.modelo.application.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
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

}
