package br.ueg.modelo.application.model;

import br.ueg.modelo.application.enums.TipoMunicao;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_municao")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Municao {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "marca_municao")
    private String marca;

    @Column(name = "calibre_municao")
    private String calibre;

    @Column(name = "projetil_municao")
    private String projetil;

    @Column(name = "peso_municao")
    private Double peso;

    @Column(name = "tipo_municao")
    private TipoMunicao tipo;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "municao")
    private List<Movimentacao> movimentacoes;
}
