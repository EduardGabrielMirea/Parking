package parking.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parking.app.controller.AltaController;
import parking.app.controller.EntradaController;
import parking.app.controller.MenuController;
import parking.app.repository.EstanciaRepository;
import parking.app.repository.VehiculoRepository;

import javax.xml.stream.events.EntityReference;

@Service
public class AppService {

    private final MenuController menuController;
    private final EntradaController entradaController;
    private final AltaController altaController;
    private final EstanciaRepository estanciaRepository;
    private final VehiculoRepository vehiculoRepository;

    @Autowired
    public AppService(MenuController menuController, EntradaController entradaController, AltaController altaController, EstanciaRepository estanciaRepository, VehiculoRepository vehiculoRepository) {
        this.menuController = menuController;
        this.entradaController = entradaController;
        this.altaController = altaController;
        this.estanciaRepository = estanciaRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    public EntradaController getEntradaController() {
        return entradaController;
    }

    public AltaController getAltaController() {
        return altaController;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public EstanciaRepository getEstanciaRepository() {
        return estanciaRepository;
    }

    public VehiculoRepository getVehiculoRepository() {
        return vehiculoRepository;
    }
}
