package fr.tao.remoteapi.clientweb;

import fr.tao.remoteapi.bean.command.CommandConsultRequest;
import fr.tao.remoteapi.bean.command.CommandConsultResponse;
import fr.tao.remoteapi.bean.command.CommandsSearchRequest;
import fr.tao.remoteapi.bean.command.CommandsSearchResponse;
import fr.tao.remoteapi.bean.parc.ConnectionInfosConsultRequest;
import fr.tao.remoteapi.bean.parc.ConnectionInfosConsultResponse;

public class RestWebClientImpl extends AbstractRestWebClient implements RestWebClient {
	
	public static final String URI_SEARCH_COMMANDS = "/rechercherCommandes";
	public static final String URI_CONSULT_COMMAND = "/consulterCommande";
	public static final String URI_CONSULT_CONNECTION_INFOS = "/consulterInfosRaccordement";

	@Override
	public CommandsSearchResponse searchCommands(CommandsSearchRequest request) throws Exception {
		final String urlWS = apiUrl + URI_SEARCH_COMMANDS;
		return callPostRemoteService(request, urlWS, apiLogin, apiPassword, CommandsSearchResponse.class);
	}

	@Override
	public CommandConsultResponse consultCommand(CommandConsultRequest request) throws Exception {
		final String urlWS = apiUrl + URI_CONSULT_COMMAND;
		return callPostRemoteService(request, urlWS, apiLogin, apiPassword, CommandConsultResponse.class);
	}

	@Override
	public ConnectionInfosConsultResponse consultConnectionInfos(ConnectionInfosConsultRequest request)
			throws Exception {
		final String urlWS = apiUrl + URI_CONSULT_CONNECTION_INFOS;
		return callPostRemoteService(request, urlWS, apiLogin, apiPassword, ConnectionInfosConsultResponse.class);
	}

}
