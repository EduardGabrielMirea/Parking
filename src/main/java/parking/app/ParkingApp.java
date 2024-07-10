package parking.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import parking.app.ui.MenuUI;

import java.awt.*;

@SpringBootApplication(scanBasePackages = {"ParkinApp.app"})
public class ParkingApp {
    public static void main(String[] args) {
        SpringApplication.run(ParkingApp.class, args);

/*
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(ParkingApp.class)
                        .headless(false)
                        .web(WebApplicationType.NONE)
                        .run(args);

        EventQueue.invokeLater(() -> {
            // Obtenemos los objetos form a través de Spring
            //Inicio de Sesión UI
            MenuUI menuUI = context.getBean(MenuUI.class);
            MenuUI.main();
        });

 */



    }
}
