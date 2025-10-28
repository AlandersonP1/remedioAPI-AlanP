package Projeto.Alan.p;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  

public class Helloword {

    @GetMapping("/hello") // A anotação para mapear uma requisição GET para o endpoint "/hello"
    public String sayHello() {
        return "Hello, World!"; // O que será retornado quando o endpoint "/hello" for acessado
    }
}
