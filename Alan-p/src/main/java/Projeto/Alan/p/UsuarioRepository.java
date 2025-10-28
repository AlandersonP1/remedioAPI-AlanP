package Projeto.Alan.p;

import org.springframework.data.jpa.repository.JpaRepository;

import Projeto.Alan.usuarios.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);
}
