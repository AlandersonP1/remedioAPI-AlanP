package Projeto.Alan.p;

import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projeto.Alan.infra.TokenService;
import Projeto.Alan.usuarios.DadosAuteticacao;
import Projeto.Alan.usuarios.Usuario;

@RestController
@RequestMapping("/auth")
public class AuthenticacaoController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // DTO simples para resposta
    public static record TokenResponse(String token, String senhaCriptografada) {}

    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAuteticacao dados) {
        try {
            // Cria token de autenticação com os dados recebidos
            var authToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

            // Autentica o usuário
            Authentication authentication = authenticationManager.authenticate(authToken);

            // Busca o usuário no banco
            Optional<Usuario> optUsuario = usuarioRepository.findByLogin(dados.login());
            if (optUsuario.isEmpty()) {
                return ResponseEntity.status(401).body("Usuário não encontrado");
            }

            Usuario usuario = optUsuario.get();

            // Gera o JWT
            String jwt = tokenService.gerarToken(usuario);

            // Retorna o token e a senha criptografada (opcional)
            return ResponseEntity.ok(new TokenResponse(jwt, usuario.getSenha()));

        } catch (AuthenticationException ex) {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        } catch (Exception ex) {
            return ResponseEntity.status(500).body("Erro interno: " + ex.getMessage());
        }
    }
}

