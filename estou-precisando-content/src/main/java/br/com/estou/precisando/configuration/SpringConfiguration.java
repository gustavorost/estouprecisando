package br.com.estou.precisando.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "br.com.estou.precisando")
@EnableJpaRepositories(basePackages={"br.com.estou.precisando"})
@ComponentScan("br.com.estou.precisando")
@EnableAutoConfiguration
@SpringBootApplication
public class SpringConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfiguration.class, args);
	}

}
