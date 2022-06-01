package tup.crud;

/*
Esta es la clase principal de la aplicación.
Vemos que solo tiene las anotaciones de SpringBoot.
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
