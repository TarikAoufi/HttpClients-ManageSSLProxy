package fr.tao.remoteapi.enumeration;

/**
 * Enumérateur représentant les opérateurs de livraisons
 * 
 * @author taoufi
 *
 */
public enum OperateurLivEnum {
	
	FRANCETEL("FRANCE TELECOM"),
	
	BRITISHTEL("BRITISH TELECOM"),

    ORANGE("ORANGE"),

    AXIONE("AXIONE");

    private String label;

    private OperateurLivEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
