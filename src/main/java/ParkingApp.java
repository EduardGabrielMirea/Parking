import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.*;

@SpringBootApplication
public class ParkingApp {
    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(ParkingApp.class)
                        .headless(false)
                        .web(WebApplicationType.NONE)
                        .run(args);
/*
        EventQueue.invokeLater(() -> {
            // Obtenemos los objetos form a través de Spring
            //Inicio de Sesión UI
            InicioSesionUI inicioSesionUI = context.getBean(InicioSesionUI.class);
            inicioSesionUI.main();
            UIService.musicInLoop("src/main/resources/audio/PokemonRoute201.wav");
        });

 */

    }
}
