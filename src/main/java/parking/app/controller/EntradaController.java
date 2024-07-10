package parking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import parking.app.entity.*;
import parking.app.repository.EstanciaRepository;
import parking.app.repository.VehiculoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class EntradaController {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private EstanciaRepository estanciaRepository;

    public void registrarEntrada(String matricula, TipoVehiculo tipo) {
        Optional<Vehiculo> vehiculoOpt = vehiculoRepository.findById(matricula);
        Vehiculo vehiculo;
        if (vehiculoOpt.isEmpty()) {
            switch (tipo) {
                case OFICIAL:
                    vehiculo = new VehiculoOficial(matricula);
                    break;
                case RESIDENTE:
                    vehiculo = new VehiculoResidente(matricula);
                    break;
                case NO_RESIDENTE:
                    vehiculo = new VehiculoNoResidente(matricula);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de vehículo no reconocido");
            }
            vehiculoRepository.save(vehiculo);
        } else {
            vehiculo = vehiculoOpt.get();
        }
        Estancia estancia = new Estancia(LocalDateTime.now(), vehiculo);
        estanciaRepository.save(estancia);
    }

    public void registrarSalida(String matricula) {
        List<Estancia> estancias = estanciaRepository.findAll();
        Optional<Estancia> estanciaOpt = estancias.stream()
                .filter(e -> e.getVehiculo().getMatricula().equals(matricula) && e.getHoraSalida() == null)
                .findFirst();
        if (estanciaOpt.isPresent()) {
            Estancia estancia = estanciaOpt.get();
            estancia.registrarSalida(LocalDateTime.now());
            estanciaRepository.save(estancia);
            long duracion = estancia.calcularDuracion();
            System.out.println("Duración de la estancia: " + duracion + " minutos");

            Vehiculo vehiculo = estancia.getVehiculo();
            if (vehiculo instanceof VehiculoResidente) {
                ((VehiculoResidente) vehiculo).acumularTiempo((int) duracion);
                vehiculoRepository.save(vehiculo);
            } else if (vehiculo instanceof VehiculoNoResidente) {
                double importe = duracion * 0.02;
                System.out.println("Importe a pagar: " + importe + " euros");
            }
        } else {
            System.out.println("No se encontró una estancia en curso para la matrícula: " + matricula);
        }
    }
}
