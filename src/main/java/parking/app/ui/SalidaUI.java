package parking.app.ui;

import org.springframework.stereotype.Component;
import parking.app.controller.MenuController;
import parking.app.entity.Window;
import parking.app.repository.EstanciaRepository;
import parking.app.repository.VehiculoRepository;
import parking.app.services.AppService;

import javax.swing.*;
@Component
public class SalidaUI {
    private final ParkingController parkingController;
    private final MenuController menuController;
    private final EstanciaRepository estanciaRepository;
    private final VehiculoRepository vehiculoRepository;
    private final JFrame frame = Window.frame;

    public SalidaUI(AppService appService) {
        this.vehiculoRepository = appService.getVehiculoRepository();
        this.estanciaRepository = appService.getEstanciaRepository();
        this.menuController = appService.getMenuController();;
        this.parkingController = appService.getParkingController();

    }
}
