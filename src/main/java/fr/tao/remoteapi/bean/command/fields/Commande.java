package fr.tao.remoteapi.bean.command.fields;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean pour la commande 
 * 
 * @author taoufi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande implements Serializable {

	private static final long serialVersionUID = -8416907965515602012L;

	private Integer idCommande;

    private String msisdn;

    private String ndi;

    private String refInterneLien;

    private String refInterneProjet;

    private String raisonSocialeSite;

    private String libelleCourt;

    private String dateRdv;

    private String dateLivraison;

    private String commentaire;

    private String etat;

    private String type;

}
