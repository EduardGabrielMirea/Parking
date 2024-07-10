package parking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import parking.app.entity.Estancia;
import parking.app.entity.Vehiculo;
import parking.app.entity.VehiculoResidente;
import parking.app.repository.EstanciaRepository;
import parking.app.repository.VehiculoRepository;

import java.util.List;

public class MenuController {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private EstanciaRepository estanciaRepository;


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
