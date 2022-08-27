package br.ueg.modelo.application.repository;

import br.ueg.modelo.application.model.Cases;
import br.ueg.modelo.application.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Classe de persistência referente a entidade {@link Usuario}.
 *
 * @author UEG
 */
@Repository
public interface CasesRepository extends JpaRepository<Cases, Long>{

}
