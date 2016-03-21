package kh.com.kshrd;

import java.io.File;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("kh.com.kshrd.repositories")
@ComponentScan("kh.com.kshrd")
public class KshrdExcelToDbApplication {

	public static String ROOT = "files/excels";
	
	public static void main(String[] args) {
		SpringApplication.run(KshrdExcelToDbApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init() {
        return (String[] args) -> {
        	if(!new File(ROOT).exists()){
        		new File(ROOT).mkdirs();
        	}
        };
    }
}
