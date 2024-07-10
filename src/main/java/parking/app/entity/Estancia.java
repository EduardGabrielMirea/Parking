package parking.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@Entity
public class Estancia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;

    @ManyToOne
    private Vehiculo vehiculo;

    public Estancia() {}

    public Estancia(LocalDateTime horaEntrada, Vehiculo vehiculo) {
        this.horaEntrada = horaEntrada;
        this.vehiculo = vehiculo;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void registrarSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public long calcularDuracion() {
        return java.time.Duration.between(horaEntrada, horaSalida).toMinutes();
    }
}