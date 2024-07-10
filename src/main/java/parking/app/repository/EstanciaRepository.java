package parking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parking.app.entity.Estancia;

public interface EstanciaRepository extends JpaRepository<Estancia,Long> {

}
