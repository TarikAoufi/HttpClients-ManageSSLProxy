package fr.tao.remoteapi.bean.command.fields;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean pour les réseaux tiers
 * 
 * @author taoufi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReseauxTiers implements Serializable {

	private static final long serialVersionUID = 4298965824702698636L;

	@NotBlank
    private String informations;

    @NotBlank
    private String tarif;
}
