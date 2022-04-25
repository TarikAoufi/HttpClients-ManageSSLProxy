package fr.tao.remoteapi.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:remote_api.properties")
public abstract class PropertySourceResolver {
	
	@Value("${api.url}")
	protected String apiUrl;

	@Value("${api.login}")
	protected String apiLogin;

	@Value("${api.password}")
	protected String apiPassword;

	@Value("${api.timeout}")
	protected Integer timeout;

	// Chemin du fichier truststore
	@Value("${api.trustStore}")
	protected String trustStorePath;

	// Mot de passe du truststore
	@Value("${api.trustStorePassword}")
	protected String trustStorePassword;

	// Chemin du fichier keystore
	@Value("${api.keyStore}")
	protected String keyStorePath;

	// Mot de passe du keystore
	@Value("${api.keyStorePassword}")
	protected String keyStorePassword;

	// Params proxy
	@Value("${proxy.host}")
	protected String proxyHost;

	@Value("${proxy.port}")
	protected int proxyPort;

	@Value("${proxy.user}")
	protected String proxyUser;

	@Value("${proxy.password}")
	protected String proxyPassword;

}
