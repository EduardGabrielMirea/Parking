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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class MenuUI {
    private JPanel menuJPanel;
    private JPanel bannerJPanel;
    private JLabel bannerLabel;
    private JPanel footerJPanel;
    private JLabel footerLabel;
    private JPanel registrosJPanel;
    private JLabel titleRegLabel;
    private JButton registroEntradaButton;
    private JButton registroSalidaButton;
    private JPanel altasJPanel;
    private JLabel tilteAltasLabel;
    private JButton altaOficialButton;
    private JButton altaResidenteButton;
    private JPanel herramientasJPanel;
    private JButton comienzaMesButton;
    private JButton pagosResidentesButton;

    private final MenuController menuController;
    private final EntradaController entradaController;
    private final AltaController altaController;
    private final EstanciaRepository estanciaRepository;
    private final VehiculoRepository vehiculoRepository;
    private final JFrame frame = Window.frame;

    public MenuUI(AppService appService) {
        this.entradaController = appService.getEntradaController();
        this.altaController = appService.getAltaController();
        this.vehiculoRepository = appService.getVehiculoRepository();
        this.estanciaRepository = appService.getEstanciaRepository();
        this.menuController = appService.getMenuController();;

        registroEntradaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                EntradaUI entradaUI = new EntradaUI(appService);
                entradaUI.runEntradaUI(Window.frame);
            }
        });
        registroSalidaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                SalidaUI salidaUI = new SalidaUI(appService);
                salidaUI.runSalidaUI(Window.frame);
            }
        });
        altaOficialButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AltaUI altaUI = new AltaUI(appService);
                altaUI.runAltaUI(Window.frame);
            }
        });
        altaResidenteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AltaUI altaUI = new AltaUI(appService);
                altaUI.runAltaUI(Window.frame);
            }
        });
        comienzaMesButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                menuController.comenzarMes();
            }
        });
        pagosResidentesButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
              menuController.generarInformePagosResidentes();
            }
        });
    }

    public void runMenuUI() {
        frame.setContentPane(menuJPanel);
        frame.setVisible(true);
    }

}
