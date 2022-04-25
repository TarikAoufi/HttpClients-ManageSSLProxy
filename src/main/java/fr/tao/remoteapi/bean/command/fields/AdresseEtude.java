package fr.tao.remoteapi.bean.command.fields;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdresseEtude implements Serializable {

	private static final long serialVersionUID = -4386700339116221440L;

	@Size(max = 50)
    private String batiment;

    @NotBlank
    @Pattern(regexp = "[0-9]{5}")
    private String codeInsee;

    @NotBlank
    @Size(max = 4)
    private String codeRivoliVoie;

    @NotBlank
    @Pattern(regexp = "[0-9]{5}")
    private String cp;

    @Size(max = 50)
    private String escalier;

    @Size(max = 30)
    private String etage;

    private String informationsComplementaires;

    private String latitude;

    private Boolean livraisonChambre;

    private String longitude;

    private String nomHebergeur;

    @NotBlank
    private String nomSite;

    @NotBlank
    @Pattern(regexp = "^[0-9]{1,5}$")
    private String numero;

    @NotBlank
    private String raisonSocialeSite;

    @NotBlank
    @Size(max = 100)
    private String rue;

    private Boolean siteAdducte;

    private Boolean siteHeberge;

    @NotBlank
    @Size(max = 45)
    private String ville;


}
