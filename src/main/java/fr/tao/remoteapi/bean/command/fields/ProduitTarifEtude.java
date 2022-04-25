package fr.tao.remoteapi.bean.command.fields;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean Produit tarif Etude
 * 
 * @author taoufi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProduitTarifEtude implements Serializable {

	private static final long serialVersionUID = -4584256423599021328L;

	private String offreCommerciale; 

    private String recurrence;

    private Integer tarif;

    private String type;

    private String typeFacturation;
}
