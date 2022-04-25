package fr.tao.remoteapi.bean.command;

import java.io.Serializable;

import fr.tao.remoteapi.bean.command.fields.Commande;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean pour la reponse d'une recherche de commandes
 * 
 * @author taoufi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandsSearchResponse implements Serializable {

	private static final long serialVersionUID = -5235196612095141188L;
	
	private Commande[] commandes;
}
