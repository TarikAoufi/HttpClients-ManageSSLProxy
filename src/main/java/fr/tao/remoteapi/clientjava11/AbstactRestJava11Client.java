package fr.tao.remoteapi.clientjava11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.tao.remoteapi.common.PropertySourceResolver;
import fr.tao.remoteapi.utils.exceptions.TAOException;


public class AbstactRestJava11Client extends PropertySourceResolver {

	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstactRestJava11Client.class);

	protected static final String ERROR_REMOTE_SERVICE_CALL = "Erreur lors de l'appel du service distant %s : ";

	/**
	 * Revoie l'objet de réponse lors d'un appel du service distant
	 * 
	 * @param <R>
	 * @param <P>
	 * @param request
	 * @param urlWS
	 * @param apiLogin
	 * @param apiPassword
	 * @param responseClass
	 * @return
	 * @throws TAOException
	 */
	public <R, P> P callPostRemoteService(R request, String urlWS, String apiLogin, String apiPassword, Class<P> responseClass) throws TAOException {
		try {
			var httpRequest = HttpRequest.newBuilder()
					.uri(URI.create(urlWS))
					.header(HttpHeaders.CONTENT_TYPE, "application/json")
					.header(HttpHeaders.AUTHORIZATION,
							"Basic " + HttpHeaders.encodeBasicAuth(apiLogin, apiPassword, StandardCharsets.US_ASCII))
					.POST(HttpRequest.BodyPublishers.ofString(toJson(request)))
					.build();

			// HttpClient avec gestion du proxy & SSL
			// var client = Java11HttpUtils.manageSSLProxy();	
			var client = HttpClient.newHttpClient();
			
			// Appel synchrone
			var httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			
			// Appel asynchrone
		    // var httpResponse = client.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString()).join();
			
			var objectMapper = new ObjectMapper();
			
			return objectMapper.readValue(httpResponse.body(), responseClass);

		} catch (Exception e) {
			throw new TAOException(String.format(ERROR_REMOTE_SERVICE_CALL, urlWS) + e.getMessage(), e);
		}
	}

	/**
	 * Renvoie une chaîne de caractères au format json à partir d'un objet en
	 * paramètre
	 *
	 * @param request objet à convertir
	 * @return string au format json
	 * @throws SIGException
	 */
	protected static String toJson(Object obj) throws TAOException {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new TAOException(e.getMessage(), e);
		}
	}

}
