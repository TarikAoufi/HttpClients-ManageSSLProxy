package fr.tao.remoteapi.clientapache;

import fr.tao.remoteapi.bean.command.CommandConsultRequest;
import fr.tao.remoteapi.bean.command.CommandConsultResponse;
import fr.tao.remoteapi.bean.command.CommandsSearchRequest;
import fr.tao.remoteapi.bean.command.CommandsSearchResponse;
import fr.tao.remoteapi.bean.parc.ConnectionInfosConsultRequest;
import fr.tao.remoteapi.bean.parc.ConnectionInfosConsultResponse;

public interface RestApacheClient {
	
    public CommandsSearchResponse searchCommands(CommandsSearchRequest request) throws Exception;
    
    public CommandConsultResponse consultCommand(CommandConsultRequest request) throws Exception;

    public ConnectionInfosConsultResponse consultConnectionInfos(ConnectionInfosConsultRequest consult) throws Exception;    
}
