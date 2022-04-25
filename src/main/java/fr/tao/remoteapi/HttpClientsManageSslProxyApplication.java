package fr.tao.remoteapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class HttpClientsManageSslProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpClientsManageSslProxyApplication.class, args);
	}

}
