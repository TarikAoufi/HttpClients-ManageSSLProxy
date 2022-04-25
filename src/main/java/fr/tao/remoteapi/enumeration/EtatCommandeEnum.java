package fr.tao.remoteapi.enumeration;

/**
 * Enumérateur représentant les états d'une commande (de création de lien)
 * 
 * @author taoufi
 *
 */
public enum EtatCommandeEnum {
    
    INITIALE("INITIALE"),
    EN_COURS("EN_COURS"),
    VALIDEE("VALIDEE"),
    CLOTURE("CLOTURE"),
    ANNULEE("ANNULEE"),
    ATTENTE_RETOUR_OI("ATTENTE_RETOUR_OI"),
    ATTENTE_RETOUR_CLIENT("ATTENTE_RETOUR_CLIENT");
    
    private String label;
    
    private EtatCommandeEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
