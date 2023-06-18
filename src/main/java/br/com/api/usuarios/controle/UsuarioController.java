package br.com.api.usuarios.controle;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.usuarios.modelo.UsuarioModel;
import br.com.api.usuarios.repositorio.UsuarioRepository;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository ur;

    @GetMapping("/login")
    public ResponseEntity<Optional<UsuarioModel>> logar(@RequestParam(value = "usuario") String usuario,
                                                    @RequestParam(value = "senha") String senha) {
                                                        
        Optional<UsuarioModel> usuarios = ur.findByUsuarioAndSenha(usuario, senha);
        
        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
    
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/cadastrar_usuarios")
    public ResponseEntity<?> cadastrar_usuarios(@RequestBody UsuarioModel um){
        return new ResponseEntity<UsuarioModel>(ur.save(um), HttpStatus.CREATED);
    }
}
