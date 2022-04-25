package fr.tao.remoteapi.clientweb;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import fr.tao.remoteapi.common.PropertySourceResolver;
import fr.tao.remoteapi.utils.exceptions.TAOException;

public abstract class AbstractRestWebClient extends PropertySourceResolver {
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractRestWebClient.class);
	
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
	public <R, P> P callPostRemoteService(R request, String urlWS, String apiLogin, String apiPassword,
			Class<P> responseClass) throws TAOException {
		try {			
		 // WebClient avec gestion du proxy & SSL
		 // var webClient = SpringWebClientUtils.getWebClientSSLProxy();			
			var webClient = WebClient.create();
			
			return webClient.post()
					.uri(new URI(urlWS))
					.header(HttpHeaders.AUTHORIZATION,
							"Basic " + HttpHeaders.encodeBasicAuth(apiLogin, apiPassword, StandardCharsets.US_ASCII))
					.contentType(MediaType.APPLICATION_JSON)
					.body(BodyInserters.fromValue(request))
					.retrieve()
					// Flux
					//.bodyToFlux(responseClass) // Flux : Récupérer plusieurs éléments
					//.blockLast(); // bloquer jusqu'à sa dernière valeur	
					// Mono
			        .bodyToMono(responseClass) // Contenu de la réponse Mono : 1 seul élément est lu
			        .block(); // Flux bloquer pour attendre l'arrivée des données
		} catch (Exception e) {
			throw new TAOException(String.format(ERROR_REMOTE_SERVICE_CALL, urlWS) + e.getMessage(), e);
		}
	}

}
