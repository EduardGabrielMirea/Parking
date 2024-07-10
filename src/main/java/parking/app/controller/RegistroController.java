package parking.app.controller;

import org.springframework.stereotype.Component;
import parking.app.entity.Estancia;
import parking.app.entity.Vehiculo;

import java.time.LocalDateTime;

@Component
public class RegistroController {

/*
    public void registrarEntrada(String matricula, TipoVehiculo tipo) {
        Estancia nuevaEstancia = new Estancia(LocalDateTime.now());
        estancias.add(nuevaEstancia);
        System.out.println("Entrada registrada para vehículo con matrícula: " + matricula);
    }

    public void registrarSalida(String matricula) {
        Estancia estanciaActual = estancias.stream()
                .filter(e -> e.getHoraSalida() == null)
                .findFirst()
                .orElse(null);

        if (estanciaActual != null) {
            estanciaActual.registrarSalida(LocalDateTime.now());
            long duracion = estanciaActual.calcularDuracion();
            System.out.println("Salida registrada para vehículo con matrícula: " + matricula);
            System.out.println("Duración de la estancia: " + duracion + " minutos");

            // Lógica de cobro según el tipo de vehículo
            Vehiculo vehiculo = buscarVehiculo(matricula);
            if (vehiculo instanceof VehiculoResidente) {
                ((VehiculoResidente) vehiculo).acumularTiempo((int) duracion);
            } else if (vehiculo instanceof VehiculoNoResidente) {
                double importe = duracion * 0.02;
                System.out.println("Importe a pagar: " + importe + " euros");
            }
        } else {
            System.out.println("No se encontró una estancia en curso para la matrícula: " + matricula);
        }
    }



    public void generarInformePagosResidentes(String nombreFichero) {
        // Implementación de generación de informe
        // Ejemplo de salida por consola en lugar de fichero para simplicidad
        System.out.println("Generando informe de pagos de residentes...");
        for (Vehiculo v : vehiculosResidentes) {
            if (v instanceof VehiculoResidente) {
                int tiempo = ((VehiculoResidente) v).getTiempoAcumulado();
                double importe = tiempo * 0.002;
                System.out.println("Matrícula: " + v.getMatricula() + " - Tiempo: " + tiempo + " minutos - Importe: " + importe + " euros");
            }
        }
    }

 */

}
