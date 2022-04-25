package fr.tao.remoteapi.utils.http;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.ProxySelector;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;

import fr.tao.remoteapi.utils.exceptions.TAOException;
import nl.altindag.ssl.SSLFactory;

/**
 * Classe utilitaire permet d'utiliser l'API Java 11 HttpClient 
 * pour envoyer des requêtes HTTP
 * 
 *
 */
public class Java11HttpUtils {
	
	private static final String KEYSTORE_TYPE = "PKCS12";

	private Java11HttpUtils() {
		throw new IllegalStateException("JavaNetHttpUtils -- Utility class");
	}
	
	/**
	 * Renvoie l'objet HttpClient avec le proxy par défaut
	 * 
	 * @return HttpClient
	 */
	public static HttpClient getHttpClientDefaultProxy() {		
		return HttpClient.newBuilder()
				  .proxy(ProxySelector.getDefault())
				  .build();
	}
	
	public static HttpClient getHttpClientDefaultProxy(final Integer timeout) throws NoSuchAlgorithmException {		
		return HttpClient.newBuilder()
				.version(Version.HTTP_2)
				.followRedirects(Redirect.NORMAL) // Toujours rediriger, sauf des URL HTTPS vers des URL HTTP
				.connectTimeout(Duration.ofSeconds(timeout))
	            .proxy(ProxySelector.getDefault())
	            .sslContext(SSLContext.getDefault())	            
	            .sslParameters(new SSLParameters())
	            .executor(Executors.newFixedThreadPool(2))	            
	            .priority(1) //HTTP/2 priority	            
	            .build();
	}

	/**
	 * Renvoie un HttpClient avec authentification du proxy 
	 * 
	 * @param proxyHost nom du serveur du proxy
	 * @param proxyPort numéro de port du proxy
	 * @param proxyUser nom d'utilisateur du proxy
	 * @param proxyPassword mot de passe du proxy
	 * @param timeout temps de réponse du proxy
	 * @return HttpClient
	 */
	public static HttpClient getHttpClientProxy(final String proxyHost, final int proxyPort, final String proxyUser,
			final String proxyPassword, final Integer timeout) {

		return HttpClient.newBuilder()
				.version(Version.HTTP_2)
				.followRedirects(Redirect.NORMAL)
				.connectTimeout(Duration.ofSeconds(timeout))
				.proxy(ProxySelector.of(new InetSocketAddress(proxyHost, proxyPort)))
				.authenticator(new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(proxyUser, proxyPassword.toCharArray());
					}

				})
				.build();
	}
	
	public static HttpClient getHttpClientProxy(final String proxyHost, final int proxyPort, final Integer timeout) {

		return HttpClient.newBuilder()
				.version(HttpClient.Version.HTTP_2)
				.followRedirects(HttpClient.Redirect.NORMAL)
				.connectTimeout(Duration.ofSeconds(timeout))
				.proxy(ProxySelector.of(new InetSocketAddress(proxyHost, proxyPort)))
				.authenticator(Authenticator.getDefault())
				.build();
	}
	
	/**
	 * Renvoie un HttpClient avec gestion du proxy et le certificat de sécurité
	 * 
	 * @param proxyHost
	 * @param proxyPort
	 * @param trustStorePath
	 * @param trustStorePassword
	 * @param keyStorePath
	 * @param keyStorePassword
	 * @return
	 * @throws TAOException
	 * @throws FileNotFoundException 
	 */
	public static HttpClient manageSSLProxy(final String proxyHost, final int proxyPort, final String trustStorePath, final String trustStorePassword,
            final String keyStorePath, final String keyStorePassword) throws FileNotFoundException {
		            
            var sslFactory = SSLFactory.builder()
            		.withSwappableIdentityMaterial()
	                .withIdentityMaterial(new FileInputStream(keyStorePath), 
	                		keyStorePassword.toCharArray(), KEYSTORE_TYPE)
	                .withSwappableTrustMaterial()
	                .withTrustMaterial(new FileInputStream(trustStorePath) , 
	                		trustStorePassword.toCharArray())
	                .build();
	
            
            return HttpClient.newBuilder()
                    .sslParameters(sslFactory.getSslParameters())
                    .sslContext(sslFactory.getSslContext())
                    .proxy(ProxySelector.of(new InetSocketAddress(proxyHost, proxyPort)))
                    .build();
   
	}

}
