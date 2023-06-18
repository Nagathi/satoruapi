package br.com.api.usuarios.repositorio;

import java.util.*;
import org.springframework.data.repository.CrudRepository;

import br.com.api.usuarios.modelo.PersonagemModel;

public interface PersonagemRepository extends CrudRepository <PersonagemModel, Long>{

    List<PersonagemModel> findByNome(String nome);
    List<PersonagemModel> findByAnime(String anime);

}
