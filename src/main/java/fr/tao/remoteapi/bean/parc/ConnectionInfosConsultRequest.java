package fr.tao.remoteapi.bean.parc;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean pour la requête de consultation des infos de raccordement
 * 
 * @author taoufi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionInfosConsultRequest {

    @NotBlank
    private String msisdn;

}
