package fr.tao.remoteapi.utils.http;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.net.ssl.SSLException;

import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import fr.tao.remoteapi.utils.exceptions.TAOException;
import nl.altindag.ssl.SSLFactory;
import nl.altindag.ssl.util.NettySslUtils;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.ProxyProvider;

public class SpringWebClientUtils {
	
	private static final String KEYSTORE_TYPE = "PKCS12";

	private SpringWebClientUtils() {
		throw new IllegalStateException("SpringWebClientUtils -- Utility class");
	}
	
	/**
	 * Renvoie l'objet WebClient avec gestion du proxy 
	 * 
	 * @param proxyHost
	 * @param proxyPort
	 * @param timeout
	 * @return
	 */
	public static WebClient getWebClientProxy(final String proxyHost, final int proxyPort, final Integer timeout) {
		var httpClient = HttpClient.create()
				.proxy(proxy -> proxy.type(ProxyProvider.Proxy.HTTP)
						.host(proxyHost)
						.port(proxyPort)
						.connectTimeoutMillis(timeout));

		return WebClient.builder()
				.clientConnector(new ReactorClientHttpConnector(httpClient))
				.build();
	}
	
	/**
	 * Renvoie l'objet WebClient avec gestion du proxy et le certificat de sécurité SSL
	 * 
	 * @param proxyHost
	 * @param proxyPort
	 * @param timeout
	 * @param trustStorePath
	 * @param trustStorePassword
	 * @param keyStorePath
	 * @param keyStorePassword
	 * @return
	 * @throws TAOException
	 */
	public static WebClient getWebClientSSLProxy(final String proxyHost, final int proxyPort, final String trustStorePath, 
			final String trustStorePassword, final String keyStorePath, final String keyStorePassword) throws TAOException  {	
		try {	
			var sslFactory = SSLFactory.builder()
	                .withSwappableIdentityMaterial()
	                .withIdentityMaterial(new FileInputStream(keyStorePath), 
	                		keyStorePassword.toCharArray(), KEYSTORE_TYPE)
	                .withSwappableTrustMaterial()
	                .withTrustMaterial(new FileInputStream(trustStorePath) , 
	                		trustStorePassword.toCharArray())
	                .build();
	
			var sslContext  = NettySslUtils.forClient(sslFactory).build();
			
			var httpClient = HttpClient.create()
					.secure(sslSpec -> sslSpec.sslContext(sslContext))
					.proxy(proxy -> proxy.type(ProxyProvider.Proxy.HTTP)
							.host(proxyHost)
							.port(proxyPort));
	
			return WebClient.builder()
					.clientConnector(new ReactorClientHttpConnector(httpClient))
					.build();	
			
		} catch (SSLException | FileNotFoundException e) {
			throw new TAOException(e.getMessage(), e);
		} 

	}
}
