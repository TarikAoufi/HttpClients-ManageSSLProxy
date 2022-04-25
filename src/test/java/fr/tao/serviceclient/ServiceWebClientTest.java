package fr.tao.serviceclient;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tao.remoteapi.bean.command.CommandConsultResponse;
import fr.tao.remoteapi.bean.command.CommandsSearchResponse;
import fr.tao.remoteapi.bean.parc.ConnectionInfosConsultResponse;
import fr.tao.remoteapi.clientweb.RestWebClientImpl;
import fr.tao.serviceclient.utils.TestUtils;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { RestWebClientImpl.class })
@TestPropertySource("classpath:remote_api.properties")
class ServiceWebClientTest extends TestUtils {

	private final RestWebClientImpl webClient = new RestWebClientImpl();
	
	@Test
	void searchCommands() throws Exception {
		
		final String urlWS = apiUrl + URI_SEARCH_COMMANDS;	
		
		var responseExpected = webClient.callPostRemoteService(commandsSearchRequest,
				urlWS, apiLogin, apiPassword, CommandsSearchResponse.class);
		
		var commandsSearchResponse = toObject(JSON_FILE_SEARCH_RESPONSE, CommandsSearchResponse.class);

		assertEquals(responseExpected, commandsSearchResponse);
	}
	
	@Test
	void consultCommand() throws Exception {
		
		final String urlWS = apiUrl + URI_CONSULT_COMMAND;

		var responseExpected = webClient.callPostRemoteService(commandConsultRequest,
				urlWS, apiLogin, apiPassword, CommandConsultResponse.class);

		var commandConsultResponse = toObject(JSON_FILE_CONSULT_RESPONSE, CommandConsultResponse.class);

		assertEquals(responseExpected, commandConsultResponse);
	}

	@Test
	void consultConnectionInfos() throws Exception {
		
		final String urlWS = apiUrl + URI_CONSULT_CONNECTION_INFOS;

		var responseExpected = webClient.callPostRemoteService(connectionInfosConsultRequest,
				urlWS, apiLogin, apiPassword, ConnectionInfosConsultResponse.class);
		
		var connectionInfosConsultResponse = toObject(JSON_FILE_CONNECTION_INFOS_RESPONSE, ConnectionInfosConsultResponse.class);

		assertEquals(responseExpected, connectionInfosConsultResponse);
	}

}
