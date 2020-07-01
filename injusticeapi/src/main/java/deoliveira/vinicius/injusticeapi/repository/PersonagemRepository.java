package deoliveira.vinicius.injusticeapi.repository;

import deoliveira.vinicius.injusticeapi.model.PersonagemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * @Author Vinícius de Oliveira
 * @Version 1.0
 */

@Repository
public interface PersonagemRepository extends CrudRepository<PersonagemEntity, Long> {
}
