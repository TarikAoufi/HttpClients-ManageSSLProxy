package fr.tao.remoteapi.clientapache;

import org.springframework.stereotype.Service;

import fr.tao.remoteapi.bean.command.CommandConsultRequest;
import fr.tao.remoteapi.bean.command.CommandConsultResponse;
import fr.tao.remoteapi.bean.command.CommandsSearchRequest;
import fr.tao.remoteapi.bean.command.CommandsSearchResponse;
import fr.tao.remoteapi.bean.parc.ConnectionInfosConsultRequest;
import fr.tao.remoteapi.bean.parc.ConnectionInfosConsultResponse;

@Service
public class RestApacheClientImpl extends AbstactRestApacheClient implements RestApacheClient {
	
    public static final String URI_SEARCH_COMMANDS = "/rechercherCommandes";
    public static final String URI_CONSULT_COMMAND = "/consulterCommande";
    public static final String URI_CONSULT_CONNECTION_INFOS = "/consulterInfosRaccordement";

	@Override
	public CommandsSearchResponse searchCommands(CommandsSearchRequest request) throws Exception {
		final String urlWS = apiUrl + URI_SEARCH_COMMANDS;
        return callPostRemoteService(urlWS, apiLogin, apiPassword, timeout, request, CommandsSearchResponse.class);
	}

	@Override
	public CommandConsultResponse consultCommand(CommandConsultRequest request) throws Exception {
		final String urlWS = apiUrl + URI_CONSULT_COMMAND;
        return callPostRemoteService(urlWS, apiLogin, apiPassword, timeout, request, CommandConsultResponse.class);
	}

	@Override
	public ConnectionInfosConsultResponse consultConnectionInfos(ConnectionInfosConsultRequest request)
			throws Exception {
		final String urlWS = apiUrl + URI_CONSULT_CONNECTION_INFOS;
        return callPostRemoteService(urlWS, apiLogin, apiPassword, timeout, request, ConnectionInfosConsultResponse.class);
	}

}
