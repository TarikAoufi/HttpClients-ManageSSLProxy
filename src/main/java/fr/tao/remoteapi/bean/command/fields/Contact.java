package fr.tao.remoteapi.bean.command.fields;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean pour le contact d'une commande 
 * 
 * @author taoufi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact implements Serializable {

	private static final long serialVersionUID = -7523330686754444341L;

	@NotBlank
    private String nom;

    @NotBlank
    private String prenom;

    @NotBlank
    private String mail;

    @NotBlank
    private String telFixe;

    private String telMobile;

    private String fax;
}
