package parking.app.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehiculo {

    @Id
    private String matricula;

    @Enumerated(EnumType.STRING)
    private TipoVehiculo tipo;
    public Vehiculo() {
    }

    public Vehiculo(String matricula, TipoVehiculo tipo) {
        this.matricula = matricula;
        this.tipo = tipo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }
}
