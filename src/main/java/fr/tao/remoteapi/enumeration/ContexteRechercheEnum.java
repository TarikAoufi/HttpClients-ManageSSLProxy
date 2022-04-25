package fr.tao.remoteapi.enumeration;

/**
 * Enumérateur représentant le contexte de recherche de commandes
 * 
 * @author taoufi
 *
 */
public enum ContexteRechercheEnum {
    
    FIXE("FIXE"),

    BYZEN("BYZEN");

    private String label;

    private ContexteRechercheEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
