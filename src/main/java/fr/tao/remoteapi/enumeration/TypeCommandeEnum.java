package fr.tao.remoteapi.enumeration;

import lombok.Getter;

/**
 * Enumérateur représentant les types de commandes
 * 
 * @author taoufi
 *
 */
@Getter
public enum TypeCommandeEnum {
    
    ETUDE("Etude (MPLS, FON ou WDM)"),
    CREATION_LIEN("Création lien"),
    CREATION_LIEN_L2_PAP("Création de lien L2 en point à point"),
    CREATION_LIEN_L2_PDC("Création de lien L2 via porte de collecte"),
    MATERIEL("Matériel"),
    RESILIATION_LIEN("Résiliation lien"),
    COMMANDE_ROUTEUR("Commande routeur"),
    COMMANDE_SIM("Commande SIM"),
    ACTIVATION_SIM("Activation SIM"),
    ECHANGE_SIM("Echange SIM"),
    ADD_SERVICES_LIENBUF("Ajouter des options"),
    REMOVE_SERVICES_LIENBUF("Supprimer des options"),
    CHANGE_OFFER_LIENBUF("Changement d'offre"),
    CHANGE_STATUS_LIENBUF("Changement d'état"),
    CHANGE_APN("Changment d'APN"),
    SAV("Echange standard");
    
    private String label;

    private TypeCommandeEnum(String label) {
        this.label = label;
    }
}
