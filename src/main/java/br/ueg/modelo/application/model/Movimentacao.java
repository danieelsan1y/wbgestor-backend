package br.ueg.modelo.application.model;

import br.ueg.modelo.application.enums.TipoMovimentacao;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "tb_movimentacao")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movimentacao {

    @Id
    @Column(name = "id_movimentacao", nullable = false)
    private Long id;



    @Column(name = "tipo_movimentacao")
    private TipoMovimentacao tipoMovimentacao;

    @Column(name = "quantidade_movimentacao")
    private int quantidade;

    @Column(name = "data_movimentacao")
    private LocalDate dataMovimentacao;

    @ManyToOne
    @JoinColumn(name = "id_municao")
    private Municao municao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

}
