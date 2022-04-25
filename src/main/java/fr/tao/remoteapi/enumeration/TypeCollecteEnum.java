package fr.tao.remoteapi.enumeration;

import lombok.Getter;

/**
 * Enum Type de collecte
 * 
 * @author taoufi
 *
 */
@Getter
public enum TypeCollecteEnum {

    INTERNET("INTERNET", "Accès internet"), 
    PDC("PDC", "Porte de collecte"), 
    PAP("PAP", "Point à point");

    private String code;

    private String libelle;

    private TypeCollecteEnum(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }
}
