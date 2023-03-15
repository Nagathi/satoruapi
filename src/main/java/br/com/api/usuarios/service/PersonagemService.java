package br.com.api.usuarios.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.usuarios.modelo.PersonagemModel;
import br.com.api.usuarios.repositorio.PersonagemRepository;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository pr;

    public List<PersonagemModel> listar_personagens(){
        return (List<PersonagemModel>) pr.findAll();
    }

    public ResponseEntity<PersonagemModel> cadastrar_personagens(PersonagemModel pm){
        return new ResponseEntity<PersonagemModel>(pr.save(pm), HttpStatus.CREATED);
    }

    public ResponseEntity<PersonagemModel> editar_personagens(PersonagemModel pm){
        return new ResponseEntity<PersonagemModel>(pr.save(pm), HttpStatus.CREATED);
    }

}
