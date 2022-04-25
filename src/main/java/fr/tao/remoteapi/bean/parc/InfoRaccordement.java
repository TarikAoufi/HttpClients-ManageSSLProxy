package fr.tao.remoteapi.bean.parc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean pour les infos de raccordement
 * 
 * @author taoufi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoRaccordement {

    private String cle;

    private String valeur;

}