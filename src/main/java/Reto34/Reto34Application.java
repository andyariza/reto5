package Reto34;
//1. Modelo
//2. Interface
//3. Repositorio
//4. Servicios
//5. Controlador o Web

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 *
 * @author Andy Ariza
 */
@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"Reto34.Modelo"})
public class Reto34Application {

    public static void main(String[] args) {
        SpringApplication.run(Reto34Application.class, args);
    }

}
