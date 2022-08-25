package br.ueg.modelo.application.repository;

import br.ueg.modelo.application.model.Arma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmaRepository extends JpaRepository<Arma,Long> {

    @Query("SELECT a FROM Arma a WHERE a.id = :id")
    public Arma buscarPorId(@Param("id") Long id);

}
