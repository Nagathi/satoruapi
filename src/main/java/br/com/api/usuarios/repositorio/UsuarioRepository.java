package br.com.api.usuarios.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import br.com.api.usuarios.modelo.UsuarioModel;

public interface UsuarioRepository extends CrudRepository <UsuarioModel, Long> {
    Optional<UsuarioModel> findByUsuarioAndSenha(String usuario, String senha);
}
