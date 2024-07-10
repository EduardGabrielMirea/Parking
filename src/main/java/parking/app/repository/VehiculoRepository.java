package parking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import parking.app.entity.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {
}
