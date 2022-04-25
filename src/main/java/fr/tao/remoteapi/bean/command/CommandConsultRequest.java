package fr.tao.remoteapi.bean.command;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean pour la requête de consultation d'une commande
 * 
 * @author taoufi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandConsultRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idCommande;
	
}
