package parking.app.entity;

import jakarta.persistence.Entity;

@Entity
public class VehiculoOficial extends Vehiculo {
    public VehiculoOficial() {
        super();
    }

    public VehiculoOficial(String matricula) {
        super(matricula, TipoVehiculo.OFICIAL);
    }
}
