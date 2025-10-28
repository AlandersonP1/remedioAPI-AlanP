package Projeto.Alan.p;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import Projeto.Alan.Remedio;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {
    List<Remedio> findAllByAtivoTrue();
}
