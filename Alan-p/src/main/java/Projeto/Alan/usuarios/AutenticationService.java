package Projeto.Alan.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Projeto.Alan.p.UsuarioRepository;
import Projeto.Alan.usuarios.Usuario;

@Service
public class AutenticationService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        // Busca o usuário pelo login no banco
        Usuario usuario = repository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + login));
        return usuario; // retorna o usuário que implementa UserDetails
    }
}
