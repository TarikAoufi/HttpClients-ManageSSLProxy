package fr.tao.remoteapi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.tao.remoteapi.bean.command.CommandConsultRequest;
import fr.tao.remoteapi.bean.command.CommandConsultResponse;
import fr.tao.remoteapi.bean.command.CommandsSearchRequest;
import fr.tao.remoteapi.bean.command.CommandsSearchResponse;
import fr.tao.remoteapi.bean.command.fields.Commande;
import fr.tao.remoteapi.bean.parc.ConnectionInfosConsultRequest;
import fr.tao.remoteapi.bean.parc.ConnectionInfosConsultResponse;
import fr.tao.remoteapi.bean.parc.InfoRaccordement;
import fr.tao.remoteapi.clientapache.RestApacheClient;
import fr.tao.remoteapi.clientjava11.RestJava11Client;
import fr.tao.remoteapi.clientweb.RestWebClient;
import fr.tao.remoteapi.configuration.AppConfig;

public class Demo {
	
	public static void main(String[] args) throws Exception {
        var applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        applicationContext.start();

        RestApacheClient apacheClient = (RestApacheClient) applicationContext.getBean("restApacheClient");
        RestJava11Client java11Client = (RestJava11Client) applicationContext.getBean("restJava11Client");
        RestWebClient webClient = (RestWebClient) applicationContext.getBean("restWebClient");

        // Requêtes à envoyer via HttpClient
        var request1 = new CommandsSearchRequest(105259, "0844102814");       
        var request2 = new CommandConsultRequest(105262);       
        var request3 = new ConnectionInfosConsultRequest("0844102815");
        
        System.out.println("##################### Appel des services via Apache HttpClient #####################");
        CommandsSearchResponse resp1ApacheClient = apacheClient.searchCommands(request1);
        if (resp1ApacheClient != null) {
            for (Commande item : resp1ApacheClient.getCommandes()) {
                System.out.println(item.getIdCommande() + " " + item.getMsisdn() + " " + item.getEtat());
            }
        }

        CommandConsultResponse resp2ApacheClient = apacheClient.consultCommand(request2);
        if (resp2ApacheClient != null) {
            System.out.println(resp2ApacheClient.getIdCommande() + " " + resp2ApacheClient.getMsisdn() + " " + resp2ApacheClient.getEtat());
        }
        
        ConnectionInfosConsultResponse resp3ApacheClient = apacheClient.consultConnectionInfos(request3);        
        if(resp3ApacheClient != null) {
        	for (InfoRaccordement item : resp3ApacheClient.getInfosRaccordement()) {
        		System.out.println("Cle : " + item.getCle() + "\t Valeur : " + item.getValeur());				
			}
        }

		System.out.println("**************** Appel des services via Java 11 HttpClient ****************");
		CommandsSearchResponse resp1Java11Client = java11Client.searchCommands(request1);
		if (resp1Java11Client != null) {
			for (Commande item : resp1Java11Client.getCommandes()) {
				System.out.println(item.getIdCommande() + " " + item.getMsisdn() + " " + item.getEtat());
			}
		}
		
        CommandConsultResponse resp2Java11Client = java11Client.consultCommand(request2);
        if (resp2Java11Client != null) {
            System.out.println(resp2Java11Client.getIdCommande() + " " + resp2Java11Client.getMsisdn() + " " + resp2Java11Client.getEtat());
        }     
        
        ConnectionInfosConsultResponse resp3Java11Client = java11Client.consultConnectionInfos(request3);       
        if(resp3Java11Client != null) {
        	for (InfoRaccordement item : resp3Java11Client.getInfosRaccordement()) {
        		System.out.println("Cle : " + item.getCle() + "\t Valeur : " + item.getValeur());				
			}
        }
        
        System.out.println("°°°°°°°°°°°°°°°°°° Appel des services via Spring WebClient ++++++++++++++++++++++");
		CommandsSearchResponse resp1WebClient = webClient.searchCommands(request1);
		if (resp1WebClient != null) {
			for (Commande item : resp1WebClient.getCommandes()) {
				System.out.println(item.getIdCommande() + " " + item.getMsisdn() + " " + item.getEtat());
			}
		}
		
        CommandConsultResponse resp2WebClient = webClient.consultCommand(request2);
        if (resp2WebClient != null) {
            System.out.println(resp2WebClient.getIdCommande() + " " + resp2WebClient.getMsisdn() + " " + resp2WebClient.getEtat());
        }   
        
        ConnectionInfosConsultResponse resp3WebClient = webClient.consultConnectionInfos(request3);       
        if(resp3WebClient != null) {
        	for (InfoRaccordement item : resp3WebClient.getInfosRaccordement()) {
        		System.out.println("Cle : " + item.getCle() + "\t Valeur : " + item.getValeur());				
			}
        }
	        
	        
        applicationContext.close();
    }
	
	

}
