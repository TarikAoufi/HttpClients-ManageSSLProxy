package fr.tao.remoteapi.utils.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContexts;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import fr.tao.remoteapi.utils.exceptions.TAOException;

/**
 * 
 * @author taoufi
 *
 */
public class ApacheHttpUtils {
	
	private static final String KEYSTORE_TYPE = "PKCS12";
	
	private ApacheHttpUtils() {
		throw new IllegalStateException("ApacheHttpUtils -- Utility class");
	}
	
    public static RestTemplate getRestTemplate(final Integer timeout, final HttpClient httpClient) {
        var clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        if (httpClient != null) {
            clientHttpRequestFactory.setHttpClient(httpClient);
        } 
        clientHttpRequestFactory.setConnectTimeout(timeout);
        clientHttpRequestFactory.setReadTimeout(timeout);
        return new RestTemplate(clientHttpRequestFactory);
    }
    
    /**
     * Authentification de base, sans les paramètres de proxy et sans le cértificat de sécurité
     * 
     * @return
     */
    public static HttpClient getHttpClient() {
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(AuthScope.ANY, 
        		new UsernamePasswordCredentials(StringUtils.EMPTY, StringUtils.EMPTY));

        return HttpClients.custom()
        		.setDefaultCredentialsProvider(credsProvider)
        		.disableCookieManagement()
        		.build();
    }
    
    /**
     * Méthode 1 :
     * Renvoie un HttpClient, qui gère les paramètres du proxy et le certificat de sécurité
     * 
     * 
     * @param proxyHost
     * @param proxyPort
     * @param trustStorePath
     * @param trustStorePassword
     * @param keyStorePath
     * @param keyStorePassword
     * @return
     * @throws TAOException
     */
    public static HttpClient manageSSLProxy(final String proxyHost, final int proxyPort, final String trustStorePath,
            final String trustStorePassword, final String keyStorePath, final String keyStorePassword) throws TAOException {

        final SSLConnectionSocketFactory sslsf = getSSLConnectionSocket(trustStorePath, trustStorePassword, keyStorePath, keyStorePassword);

        var proxy = new HttpHost(proxyHost, proxyPort);
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(new AuthScope(proxy), new UsernamePasswordCredentials(StringUtils.EMPTY, StringUtils.EMPTY));

        return HttpClients.custom()
        		.setSSLSocketFactory(sslsf)
        		.setProxy(proxy)
                .setDefaultCredentialsProvider(credsProvider)
                .disableCookieManagement()
                .build();
    }
    
    /**
     * Méthode 2 :
     * Renvoie un HttpClient, qui gère les paramètres du proxy et le certificat de sécurité
     * 
     * @param proxyHost
     * @param proxyPort
     * @param trustStorePath
     * @param trustStorePassword
     * @param keyStorePath
     * @param keyStorePassword
     * @return
     * @throws TAOException
     */
    public static HttpClient manageSSLProxy2(final String proxyHost, final int proxyPort, final String trustStorePath,
            final String trustStorePassword, final String keyStorePath, final String keyStorePassword) throws TAOException {

        final SSLConnectionSocketFactory sslsf = getSSLConnectionSocket(trustStorePath, trustStorePassword, keyStorePath, keyStorePassword);

        var proxy = new HttpHost(proxyHost, proxyPort);
        return HttpClients.custom().setRoutePlanner(
                new DefaultProxyRoutePlanner(proxy) {
                    @Override
                    public HttpHost determineProxy(HttpHost target, HttpRequest request, HttpContext context) throws HttpException {
                        return super.determineProxy(target, request, context);
                    }
                }).setSSLSocketFactory(sslsf).build();
    }
    
    public static SSLConnectionSocketFactory getSSLConnectionSocket(final String trustStorePath, final String trustStorePassword,
            final String keyStorePath, final String keyStorePassword) throws TAOException {
        try (var keyStore = new FileInputStream(keyStorePath)) {
            final var clientStore = KeyStore.getInstance(KEYSTORE_TYPE);
            clientStore.load(keyStore, keyStorePassword.toCharArray());

			final var sslContextBuilder = SSLContexts.custom()
					.loadTrustMaterial(new File(trustStorePath), trustStorePassword.toCharArray())
					.loadKeyMaterial(clientStore, keyStorePassword.toCharArray());
			
			return new SSLConnectionSocketFactory(sslContextBuilder.build());
			
		} catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException
				| KeyManagementException | UnrecoverableKeyException e) {
			throw new TAOException(e.getMessage(), e);
		}
    }

}
