package fr.tao.remoteapi.bean.command;

import java.io.Serializable;

import fr.tao.remoteapi.enumeration.ContexteRechercheEnum;
import fr.tao.remoteapi.enumeration.EtatCommandeEnum;
import fr.tao.remoteapi.enumeration.OperateurLivEnum;
import fr.tao.remoteapi.enumeration.TypeCommandeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean pour la requête d'une recherche de commandes
 * 
 * @author taoufi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandsSearchRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idCommande;

    private String msisdn;

    private String ndi;

    private Boolean commandePrincipale;
    
    private String contactCdp;
    
    private ContexteRechercheEnum contexte;
    
    private String dateSouscriptionDeb;
    
    private String dateSouscriptionFin;
    
    private EtatCommandeEnum etat;

    // ICC ID de l'équipement
    private String iccId;

    // IMEI de l'équipement
    private String imei;

    private String offreCommerciale;
    
    private OperateurLivEnum operateur;

    private String raisonSocialeSite;

    private String refInterneLien;

    private String refInterneProjet;

    private TypeCommandeEnum type;

	public CommandsSearchRequest(Integer idCommande, String msisdn) {
		this.idCommande = idCommande;
		this.msisdn = msisdn;
	}
    
}
