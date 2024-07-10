package parking.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parking.app.controller.MenuController;
import parking.app.controller.RegistroController;
import parking.app.controller.VehiculoController;

@Service
public class AppService {
    private final MenuController menuController;
    private final RegistroController registroController;
    private final VehiculoController vehiculoController;

    @Autowired
    public AppService(MenuController menuController, RegistroController registroController, VehiculoController vehiculoController) {
        this.menuController = menuController;
        this.registroController = registroController;
        this.vehiculoController = vehiculoController;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public RegistroController getRegistroController() {
        return registroController;
    }

    public VehiculoController getVehiculoController() {
        return vehiculoController;
    }
}
