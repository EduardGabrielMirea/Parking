package parking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import parking.app.entity.*;
import parking.app.repository.EstanciaRepository;
import parking.app.repository.VehiculoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public class ParkingController {

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

    public void darDeAltaVehiculoOficial(String matricula) {
        Vehiculo vehiculo = new VehiculoOficial(matricula);
        vehiculoRepository.save(vehiculo);
    }

    public void darDeAltaVehiculoResidente(String matricula) {
        VehiculoResidente vehiculo = new VehiculoResidente(matricula);
        vehiculoRepository.save(vehiculo);
    }

    public void comenzarMes() {
        List<Estancia> estancias = estanciaRepository.findAll();
        estancias.clear();
        estanciaRepository.saveAll(estancias);
        List<Vehiculo> vehiculosResidentes = vehiculoRepository.findAll();
        for (Vehiculo v : vehiculosResidentes) {
            if (v instanceof VehiculoResidente) {
                ((VehiculoResidente) v).acumularTiempo(0);
                vehiculoRepository.save(v);
            }
        }
    }

    public void generarInformePagosResidentes() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        System.out.println("Generando informe de pagos de residentes...");
        for (Vehiculo v : vehiculos) {
            if (v instanceof VehiculoResidente) {
                int tiempo = ((VehiculoResidente) v).getTiempoAcumulado();
                double importe = tiempo * 0.002;
                System.out.println("Matrícula: " + v.getMatricula() + " - Tiempo: " + tiempo + " minutos - Importe: " + importe + " euros");
            }
        }
    }
}