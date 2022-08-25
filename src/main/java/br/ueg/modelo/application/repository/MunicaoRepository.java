package br.ueg.modelo.application.repository;


import br.ueg.modelo.application.model.Municao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicaoRepository extends JpaRepository<Municao,Long> {
}
