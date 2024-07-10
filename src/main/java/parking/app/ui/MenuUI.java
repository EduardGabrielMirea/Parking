package parking.app.ui;

import org.springframework.stereotype.Component;
import parking.app.controller.MenuController;
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



    public MenuUI(AppService appService) {
        this.menuController = appService.getMenuController();


        registroEntradaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        registroSalidaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        altaOficialButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        altaResidenteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        comienzaMesButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                /*
                estancias.clear();
                for (Vehiculo v : vehiculosResidentes) {
                    if (v instanceof VehiculoResidente) {
                        ((VehiculoResidente) v).acumularTiempo(0);
                    }
                }
                System.out.println("Nuevo mes comenzado. Estancias y tiempos acumulados reiniciados.");
           */
            }

        });
        pagosResidentesButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });
    }
/*
    public static void main() {
        JFrame frame = new JFrame("MenuUI");
        frame.setContentPane(new MenuUI().menuJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

 */
}
