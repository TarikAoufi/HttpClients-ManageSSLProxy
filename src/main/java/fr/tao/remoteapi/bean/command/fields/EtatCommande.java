package fr.tao.remoteapi.bean.command.fields;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean pour l'état d'une commande 
 * 
 * @author taoufi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtatCommande implements Serializable  {

	private static final long serialVersionUID = -8273378732465481116L;

	private String commentaire;

    @NotBlank
    private String date;

    @NotBlank
    private String etat;

    private String etatSec;

    private String idSuivi;
}
