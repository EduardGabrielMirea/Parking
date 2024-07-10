package parking.app.ui;

import parking.app.controller.AltaController;
import parking.app.controller.EntradaController;
import parking.app.controller.MenuController;
import parking.app.entity.Window;
import parking.app.repository.EstanciaRepository;
import parking.app.repository.VehiculoRepository;
import parking.app.services.AppService;

import javax.swing.*;

public class AltaUI {

    private final MenuController menuController;
    private final EntradaController entradaController;
    private final AltaController altaController;
    private final EstanciaRepository estanciaRepository;
    private final VehiculoRepository vehiculoRepository;
    private final JFrame frame = Window.frame;
    private JPanel altaJPanel;
    private JPanel oficialJPanel;
    private JPanel residenteJPanel;
    private JButton oficialButton;
    private JTextField oficialText;
    private JPanel buttonOficialJPanel;
    private JPanel textOficialJPanel;
    private JButton residenteButton;
    private JPanel buttonResidenteJPanel;
    private JPanel textResidenteJPanel;
    private JTextField residenteText;

    public AltaUI(AppService appService) {
        this.entradaController = appService.getEntradaController();
        this.altaController = appService.getAltaController();
        this.vehiculoRepository = appService.getVehiculoRepository();
        this.estanciaRepository = appService.getEstanciaRepository();
        this.menuController = appService.getMenuController();;


    }
}
