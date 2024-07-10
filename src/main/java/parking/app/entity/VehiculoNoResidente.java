package parking.app.entity;

import jakarta.persistence.Entity;

@Entity
public class VehiculoNoResidente extends Vehiculo {
    public VehiculoNoResidente() {
        super();
    }

    public VehiculoNoResidente(String matricula) {
        super(matricula, TipoVehiculo.NO_RESIDENTE);
    }
}
