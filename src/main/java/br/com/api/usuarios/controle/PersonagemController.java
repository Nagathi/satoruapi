package br.com.api.usuarios.controle;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.usuarios.modelo.PersonagemModel;
import br.com.api.usuarios.service.PersonagemService;

@RestController
@CrossOrigin(origins = "*")
public class PersonagemController {

    @Autowired
    private PersonagemService ps;

    @GetMapping("/listar_personagens")
    public List<PersonagemModel> listar_personagens(){
        return ps.listar_personagens();
    }

    @PostMapping("/cadastrar_personagens")
    public ResponseEntity<?> cadastrar_personagens(@RequestBody PersonagemModel pm){
        return ps.cadastrar_personagens(pm);
    }

    @PutMapping("/editar_personagens")
    public ResponseEntity<?> editar_personagens(@RequestBody PersonagemModel pm){
        return ps.editar_personagens(pm);
    }

}
