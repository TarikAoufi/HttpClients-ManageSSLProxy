package fr.tao.remoteapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import fr.tao.remoteapi.clientapache.RestApacheClient;
import fr.tao.remoteapi.clientapache.RestApacheClientImpl;
import fr.tao.remoteapi.clientjava11.RestJava11Client;
import fr.tao.remoteapi.clientjava11.RestJava11ClientImpl;
import fr.tao.remoteapi.clientweb.RestWebClient;
import fr.tao.remoteapi.clientweb.RestWebClientImpl;

@Configuration
@PropertySource("classpath:remote_api.properties")
public class AppConfig {

	@Bean
    public RestApacheClient restApacheClient() {
        return new RestApacheClientImpl();
    }
	
	@Bean
    public RestJava11Client restJava11Client() {
        return new RestJava11ClientImpl();
    }
	
	@Bean
    public RestWebClient restWebClient() {
        return new RestWebClientImpl();
    }

}
