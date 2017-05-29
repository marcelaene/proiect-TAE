package app;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import app.controller.JobController;

@SpringBootApplication(scanBasePackageClasses = {JobController.class})
public class Application {

	public static void main(String[] args) {	
		SpringApplication.run(Application.class, args);
	}

}
