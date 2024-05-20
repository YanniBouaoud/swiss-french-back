package fr.yanni.swissfrench;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "fr.yanni.swissfrench")
public class SwissFrenchApplication {

	/**
	 * launch point for the app.
	 *
	 * @param args arguments
	 */
	public static void main(final String[] args) {
		SpringApplication.run(SwissFrenchApplication.class, args);
	}

}
