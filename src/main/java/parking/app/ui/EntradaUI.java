package parking.app.ui;

import org.springframework.stereotype.Component;
import parking.app.controller.AltaController;
import parking.app.controller.EntradaController;
import parking.app.controller.MenuController;
import parking.app.entity.Window;
import parking.app.repository.EstanciaRepository;
import parking.app.repository.VehiculoRepository;
import parking.app.services.AppService;

import javax.swing.*;

@Component
public class EntradaUI {
    private final MenuController menuController;
    private final EntradaController entradaController;
    private final AltaController altaController;
    private final EstanciaRepository estanciaRepository;
    private final VehiculoRepository vehiculoRepository;
    private final JFrame frame = Window.frame;

    public EntradaUI(AppService appService){
        this.entradaController = appService.getEntradaController();
        this.altaController = appService.getAltaController();
        this.vehiculoRepository = appService.getVehiculoRepository();
        this.estanciaRepository = appService.getEstanciaRepository();
        this.menuController = appService.getMenuController();;


    }
}
