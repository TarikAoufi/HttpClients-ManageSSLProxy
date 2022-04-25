package fr.tao.remoteapi.clientapache;



import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import fr.tao.remoteapi.common.PropertySourceResolver;
import fr.tao.remoteapi.utils.exceptions.TAOException;
import fr.tao.remoteapi.utils.http.ApacheHttpUtils;


public class AbstactRestApacheClient extends PropertySourceResolver {
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstactRestApacheClient.class);
	
	protected static final String KEYSTORE_TYPE = "PKCS12";

    protected static final String ERROR_REMOTE_SERVICE_CALL = "Erreur lors de l'appel du service distant %s : ";

    /**
     * Revoie l'objet de réponse lors d'un appel du service distant
     * 
     * @param <R> Type classe de requête
     * @param <P> Type classe de réponse
     * @param url L'url du service distant
     * @param method méthode de la requête
     * @param request requête
     * @param responseClass Classe de réponse
     * @return
     * @throws SIGException
     */
    public <R, P> P callPostRemoteService(String urlWS, String apiLogin, String apiPassword, Integer timeout, R request, Class<P> responseClass) throws TAOException {
        try {
        	// HttpClient avec gestion du proxy & SSL
        	// var httpClient = ApacheHttpUtils.manageSSLProxy()
            var httpClient = ApacheHttpUtils.getHttpClient();
            var restTemplate = ApacheHttpUtils.getRestTemplate(timeout, httpClient);

            return restTemplate.exchange(urlWS, HttpMethod.POST, getHttpEntity(request, apiLogin, apiPassword), responseClass)
                    .getBody();
        } catch (Exception e) {
            throw new TAOException(String.format(ERROR_REMOTE_SERVICE_CALL, urlWS) + e.getMessage(), e);
        }
    }

    /**
     * Renvoie l'entité de réponse d'une requête HTTP, qui encapsule dans l'entête les infos:
     * Content-Type=application/json et Authorization
     * 
     * @param <R>
     * @param request
     * @param login
     * @param password
     * @return HttpEntity
     */
    protected <R> HttpEntity<R> getHttpEntity(R request, String login, String password) {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        createBasicAuthorizationHeader(headers, login, password);
        return new HttpEntity<>(request, headers);
    }

    /**
     * Renvoie l'en-tête d'autorisation pour l'authentification de base,
     * 
     * @param headers
     * @param login
     * @param password
     * @return
     */
    protected HttpHeaders createBasicAuthorizationHeader(HttpHeaders headers, String login, String password) {
        String authHeader = "Basic " + getBase64EncodedAuth(login, password);
        headers.set(HttpHeaders.AUTHORIZATION, authHeader);
        return headers;
    }

    /**
     * Renvoie l'encodage au format Base64 des chaînes de caractères passées en paramètres
     * 
     * @param login
     * @param password
     * @return
     */
    protected String getBase64EncodedAuth(String login, String password) {
        final String auth = login + ":" + password;
        return Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.US_ASCII));
    }


}
