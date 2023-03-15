package br.com.api.usuarios.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.api.usuarios.modelo.UsuarioModel;
import br.com.api.usuarios.repositorio.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository ur;

    public List<UsuarioModel> listar_usuarios(){
        return (List<UsuarioModel>) ur.findAll();
    }

    public ResponseEntity<UsuarioModel> cadastrar_usuarios(UsuarioModel um){
        return new ResponseEntity<UsuarioModel>(ur.save(um), HttpStatus.CREATED);
    }
}
