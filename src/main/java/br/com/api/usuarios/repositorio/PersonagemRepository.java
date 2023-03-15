package br.com.api.usuarios.repositorio;

import org.springframework.data.repository.CrudRepository;
import br.com.api.usuarios.modelo.PersonagemModel;

public interface PersonagemRepository extends CrudRepository <PersonagemModel, Long>{
    
}
