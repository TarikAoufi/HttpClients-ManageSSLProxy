package fr.tao.remoteapi.enumeration;

import lombok.Getter;

/**
 * Enum niveau de lien L2, L3
 * 
 * @author taoufi
 *
 */
@Getter
public enum NivCollecteEnum {

    L2("L2", "Niveau 2"), L3("L2", "Niveau 3");

    private String code;

    private String libelle;

    private NivCollecteEnum(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }
}
