package fr.tao.remoteapi.bean.command.fields;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean pour le produit d'une commande 
 * 
 * @author taoufi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit implements Serializable {

	private static final long serialVersionUID = -499613730069797665L;
	
	private String libelle;
}
