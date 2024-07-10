package parking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import parking.app.entity.Vehiculo;
import parking.app.entity.VehiculoOficial;
import parking.app.entity.VehiculoResidente;
import parking.app.repository.EstanciaRepository;
import parking.app.repository.VehiculoRepository;

public class AltaController {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private EstanciaRepository estanciaRepository;

    public void darDeAltaVehiculoOficial(String matricula) {
        Vehiculo vehiculo = new VehiculoOficial(matricula);
        vehiculoRepository.save(vehiculo);

    }

    public void darDeAltaVehiculoResidente(String matricula) {
        VehiculoResidente vehiculo = new VehiculoResidente(matricula);
        vehiculoRepository.save(vehiculo);
    }
}
