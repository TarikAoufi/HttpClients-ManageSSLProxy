package fr.tao.remoteapi.bean.command.fields;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import fr.tao.remoteapi.enumeration.NivCollecteEnum;
import fr.tao.remoteapi.enumeration.TypeCollecteEnum;
import fr.tao.remoteapi.enumeration.TypeEtudeEnum;
import fr.tao.remoteapi.enumeration.TypeFONEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean pour la réponse de l'affichage d'une commande
 * 
 * @author taoufi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfosEtude implements Serializable {

	private static final long serialVersionUID = 2970236624846932774L;

	@NotBlank
    private AdresseEtude adresseTerminaisonUn;

    private AdresseEtude adresseTerminaisonDeux;

    private String commentaireDiversite;

    private String commentaireEligibilite;

    private String commentaireSecuPdc;

    // Débit souhaité en Mo
    private Integer debitSouhaite;

    private DevisEtude devisEtude;

    private Boolean diversite;

    // Valeur informative reservée au portail WSF
    private Boolean eligible;

    // Engagement souhaité en Mois
    @NotBlank
    private Integer engagementSouhaite;

    private NivCollecteEnum nivCollecte;

    private Integer quantite;

    private Boolean securisationPdc;

    private TypeCollecteEnum typeCollecte;

    @NotBlank
    private TypeEtudeEnum typeEtude;

    private TypeFONEnum typeFon;
}
