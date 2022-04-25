package fr.tao.remoteapi.bean.command.fields;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adresse implements Serializable {

	private static final long serialVersionUID = 7607219573155090906L;

	private String batiment;

    private String codeInsee;

    private String codeRivoliVoie;

    private String complementVoie;

    private String cp;

    private String escalier;

    private String etage;

    private String hexacle;

    private String numero;

    private String rue;

    private String typeVoie;

    private String ville;

}
