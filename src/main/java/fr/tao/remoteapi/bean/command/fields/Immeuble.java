package fr.tao.remoteapi.bean.command.fields;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean pour l'immeuble de l'adresse indiqué dans la commande 
 * 
 * @author taoufi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Immeuble implements Serializable {

	private static final long serialVersionUID = 6915760856918303834L;

	private String imb;

    @NotBlank
    private String coordonneeX;

    @NotBlank
    private String coordonneeY;

    private String libelle;
}
