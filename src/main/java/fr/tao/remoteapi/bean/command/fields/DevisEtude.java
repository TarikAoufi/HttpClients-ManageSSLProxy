package fr.tao.remoteapi.bean.command.fields;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean Devis Etude
 * 
 * @author taoufi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DevisEtude implements Serializable {

	private static final long serialVersionUID = 7258550352546657095L;

	private String dateFinValidite;

    // Délai de livraison en JO
    private Integer delaiLivraison;

    private String informationsComplementaires;

    private ProduitTarifEtude[] tarifs;
}
