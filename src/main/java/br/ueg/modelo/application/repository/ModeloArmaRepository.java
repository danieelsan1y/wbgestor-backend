package br.ueg.modelo.application.repository;

import br.ueg.modelo.application.model.ModeloArma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ModeloArmaRepository extends JpaRepository<ModeloArma,Long> {

    @Query("SELECT m FROM ModeloArma m WHERE m.id = :id")
    public ModeloArma buscarPorId(@Param("id") Long id);
}
