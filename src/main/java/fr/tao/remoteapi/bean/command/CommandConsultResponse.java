package fr.tao.remoteapi.bean.command;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import fr.tao.remoteapi.bean.command.fields.Adresse;
import fr.tao.remoteapi.bean.command.fields.AdresseEtude;
import fr.tao.remoteapi.bean.command.fields.Contact;
import fr.tao.remoteapi.bean.command.fields.EtatCommande;
import fr.tao.remoteapi.bean.command.fields.Immeuble;
import fr.tao.remoteapi.bean.command.fields.InfosEtude;
import fr.tao.remoteapi.bean.command.fields.Produit;
import fr.tao.remoteapi.bean.command.fields.ReseauxTiers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean pour la reponse de consultation d'une commande
 * 
 * @author taoufi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandConsultResponse implements Serializable {

	private static final long serialVersionUID = 7254963963834222308L;

	private Integer idCommande;

    private String etat;

    private EtatCommande[] etats;

    private String compteFacturation;

    private String msisdn;

    private Boolean ecrasement;

    private Boolean numVoisin;

    private String offreCommerciale;

    private Produit[] produits;

    private String nomSite;

    @Pattern(regexp = "[0-9]{9}")
    private String sirenSite;

    private String raisonSocialeSite;

    private Adresse adresseSite;

    private Contact contactSite;

    private String refInterneLien;

    private String refInterneProjet;

    private String dateValidation;

    private String dateSouscription;

    private String dateLivraison;

    private String dateMiseEnService;

    private String dateRdv;

    private String dateResiliationSouhaite;

    private String nivCollecte;

    private Contact contactCdp;

    private Contact contactEtude;

    private String technologie;

    private String type;

    private String oi;

    private String pm;

    private Integer[] listeSousCommande;

    // id de la commande d'étude à l'origine de la demande
    private Integer idCommandeEtude;

    private Integer idDemandeEligibilite;

    // Nom ou Prénom du contact de livraison
    private String nomContactLivraison;

    // Nom du site de livraison
    private String siteLivraison;

    private Adresse adresseLivraison;

    // Téléphone du contact de livraison
    private String telContactLivraison;

    private String nro;

    private Immeuble immeuble;

    private AdresseEtude adresseTerminaisonUn;

    private AdresseEtude adresseTerminaisonDeux;

    private String apn;

    private Boolean coTerminus;

    private String commentaire;

    private String emailContact;

    private String etatByzenAttendu;

    // Identifiant du dernier colis expédié
    private String idColis;

    private String informationsComplementaires;

    private InfosEtude infosEtude;

    private String libelleCourt;

    private Integer[] listeEquipement;

    private Integer[] listeLien;

    private String ndi;

    private String porteDeCollecte;

    // Porte de collecte de sécurisation
    private String porteDeCollecte2;

    private String pto;

    private Integer quantite;

    private ReseauxTiers reseauxTiers;

}
