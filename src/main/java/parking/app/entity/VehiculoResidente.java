package parking.app.entity;

import jakarta.persistence.Entity;

@Entity
public class VehiculoResidente extends Vehiculo {
    private int tiempoAcumulado; // en minutos

    public VehiculoResidente() {
        super();
    }

    public VehiculoResidente(String matricula) {
        super(matricula, TipoVehiculo.RESIDENTE);
        this.tiempoAcumulado = 0;
    }

    public int getTiempoAcumulado() {
        return tiempoAcumulado;
    }

    public void acumularTiempo(int minutos) {
        this.tiempoAcumulado += minutos;
    }
}
