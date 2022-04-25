package fr.tao.remoteapi.enumeration;

import lombok.Getter;

/**
 * Enum type de la technologie FON
 * 
 * @author taoufi
 *
 */
@Getter
public enum TypeFONEnum {

    FON("FON – Monobrin/Bidirectionnel"),

    PAIRE_FON("Paire de FON – Bibrin/Unidirectionnel");

    private String label;

    private TypeFONEnum(String label) {
        this.label = label;
    }

}
