package fr.tao.remoteapi.bean.parc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean pour la reponse de consultation des infos de raccordement
 * 
 * @author taoufi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionInfosConsultResponse {

    private InfoRaccordement[] infosRaccordement;

}