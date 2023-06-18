package br.com.api.usuarios.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.usuarios.modelo.PersonagemModel;
import br.com.api.usuarios.repositorio.PersonagemRepository;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemRepository pr;

    @GetMapping("/listar_personagens")
    public List<PersonagemModel> listar_personagens(){
        return (List<PersonagemModel>) pr.findAll();
    }

    @GetMapping("/buscar_nome")
    public ResponseEntity<List<PersonagemModel>> pesquisarPersonagemPorNome(@RequestParam(value = "nome") String nome) {
        List<PersonagemModel> personagens;
        
        if (nome != null && !nome.isEmpty()) {
            // Busca por nome
            personagens = pr.findByNome(nome);
        }else{
            return ResponseEntity.notFound().build();
        }
    
        return ResponseEntity.ok(personagens);
    }

    @GetMapping("/buscar_anime")
    public ResponseEntity<List<PersonagemModel>> pesquisarPersonagemPorAnime(@RequestParam(value = "anime") String anime) {
        List<PersonagemModel> personagens;
        
        if (anime != null && !anime.isEmpty()) {
            // Busca por anime
            personagens = pr.findByAnime(anime);
        } else {
            return ResponseEntity.notFound().build();
        }
    
        return ResponseEntity.ok(personagens);
    }
    
    @PostMapping("/cadastrar_personagens")
    public ResponseEntity<PersonagemModel> cadastrar_personagens(@RequestBody PersonagemModel pm){
        PersonagemModel novoPersonagem = pr.save(pm);
        return ResponseEntity.ok(novoPersonagem);
    }

    @PutMapping("/editar_personagens")
    public ResponseEntity<?> editar_personagens(@RequestBody PersonagemModel pm){
        return new ResponseEntity<PersonagemModel>(pr.save(pm), HttpStatus.CREATED);
    }

}
