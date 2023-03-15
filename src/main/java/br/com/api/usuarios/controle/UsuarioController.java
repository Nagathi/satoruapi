package br.com.api.usuarios.controle;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.usuarios.modelo.UsuarioModel;
import br.com.api.usuarios.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {
    
    @Autowired
    private UsuarioService us;

    @GetMapping("/listar_usuarios")
    public List<UsuarioModel> listar_usuarios(){
        return us.listar_usuarios();
    }

    @PostMapping("/cadastrar_usuarios")
    public ResponseEntity<?> cadastrar_usuarios(@RequestBody UsuarioModel um){
        return us.cadastrar_usuarios(um);
    }
}
