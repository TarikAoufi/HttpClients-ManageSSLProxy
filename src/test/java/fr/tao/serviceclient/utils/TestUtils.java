package fr.tao.serviceclient.utils;

import java.io.File;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.tao.remoteapi.bean.command.CommandConsultRequest;
import fr.tao.remoteapi.bean.command.CommandsSearchRequest;
import fr.tao.remoteapi.bean.parc.ConnectionInfosConsultRequest;
import lombok.Data;

@Component
@Data
@PropertySource("classpath:remote_api.properties")
public abstract class TestUtils {
	
	@Value("${api.url}")
	protected String apiUrl;

	@Value("${api.login}")
	protected String apiLogin;

	@Value("${api.password}")
	protected String apiPassword;
	
	@Value("${api.timeout}")
	protected Integer timeout;
	
	/** URLs */
    public final String URI_SEARCH_COMMANDS = "/rechercherCommandes";
    public final String URI_CONSULT_COMMAND = "/consulterCommande";
    public final String URI_CONSULT_CONNECTION_INFOS = "/consulterInfosRaccordement";
	
    /** Data */
	public static final String JSON_FILE_SEARCH_RESPONSE = "rechercherCommandes.json";
	public static final String JSON_FILE_CONSULT_RESPONSE = "consulterCommande.json";
	public static final String JSON_FILE_CONNECTION_INFOS_RESPONSE = "infosRaccordement.json";
	
	/** Requests */
	protected final CommandsSearchRequest commandsSearchRequest = new CommandsSearchRequest(105260, "0844102815");
	protected final CommandConsultRequest commandConsultRequest = new CommandConsultRequest(105262);
	protected final ConnectionInfosConsultRequest connectionInfosConsultRequest = new ConnectionInfosConsultRequest("0844102815");
	
	/**
	 * Renvoie le fichier du dossier resource 
	 * 
	 * @param fileName
	 * @return
	 * @throws URISyntaxException
	 */
	protected File getResource(String fileName) throws URISyntaxException {
		var resource = getClass().getClassLoader().getResource(fileName);

		if (resource == null)
			throw new IllegalArgumentException("Fichier non trouvé! " + fileName);

		return new File(resource.toURI());
	}
	
	/**
	 * Renvoie un objet à partir du fichier json passé en paramètre.  
	 * 
	 * @param <T> type de l'objet à retourner
	 * @param fileName fichier json
	 * @param responseClass type de l'objet 
	 * @return objet de type responseClass
	 * @throws Exception
	 */
	protected <T> T toObject(String fileName, Class<T> responseClass) throws Exception {
		var mapper = new ObjectMapper();
		return  mapper.readValue(getResource(fileName), responseClass);
	}

}
