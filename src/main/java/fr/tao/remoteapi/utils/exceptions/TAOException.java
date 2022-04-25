package fr.tao.remoteapi.utils.exceptions;

import org.xml.sax.ErrorHandler;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class TAOException extends Exception {
	
    private static final String TAO_EXCEPTION_MSG = "TAOException: Création d'une TAOException, Le paramètre '%s' ne peut être null";

    private static final String LABEL_NAME = "label";

    private static final String WHAT_I_DO = "whatIdo";

    private static final String WHO_I_AM = "whoIam";

    private static final long serialVersionUID = 1L;

    /**
     * Quel composant remonte l'exception
     */
    private final String componentName;

    /**
     * Nom de l'action que faisait le composant avant de remonter l'exception
     */
    private final String actionName;

    /**
     * Message d'erreur
     */
    private final String label;
    
    /**
     * @param whoIam quel composant lance l'exception
     * @param whatIdo quesque je faisais avant de lancer l'exception
     * @param label un libellé d'erreur associé
     *
     */
    public TAOException(String whoIam, String whatIdo, String label) {

        super(label);

        if (whoIam == null) {
            throw new IllegalArgumentException(String.format(TAO_EXCEPTION_MSG, WHO_I_AM));
        }
        if (whatIdo == null) {
            throw new IllegalArgumentException(String.format(TAO_EXCEPTION_MSG, WHAT_I_DO));
        }
        if (label == null) {
            throw new IllegalArgumentException(String.format(TAO_EXCEPTION_MSG, LABEL_NAME));
        }

        this.componentName = whoIam;
        this.actionName = whatIdo;
        this.label = label;
    }
    
    /**
     * @param label un libellé d'erreur associé
     *
     */
    public TAOException(String label) {

        super(label);

        if (label == null) {
            throw new IllegalArgumentException(String.format(TAO_EXCEPTION_MSG, LABEL_NAME));
        }

        this.componentName = this.getStackTrace()[0].getClassName();
        this.actionName = this.getStackTrace()[0].getMethodName();
        this.label = label;
    }
    
    /**
     * @param whoIam quel composant lance l'exception
     * @param whatIdo quesque je faisais avant de lancer l'exception
     *
     * @param label le label
     * @param errorHandler un errorHandler afin de collecter plusieurs erreurs
     *
     */
    public TAOException(String whoIam, String whatIdo, String label,
            ErrorHandler errorHandler) {

        super(label);

        if (whoIam == null) {
            throw new IllegalArgumentException(String.format(TAO_EXCEPTION_MSG, WHO_I_AM));
        }
        if (whatIdo == null) {
            throw new IllegalArgumentException(String.format(TAO_EXCEPTION_MSG, WHAT_I_DO));
        }
        if (errorHandler == null) {
            throw new IllegalArgumentException(String.format(TAO_EXCEPTION_MSG, "errorHandler"));
        }

        this.componentName = whoIam;
        this.actionName = whatIdo;
        this.label = "";

    }
    
    /**
     * @param whoIam quel composant lance l'exception
     * @param whatIdo quesque je faisais avant de lancer l'exception
     * @param why l'exception cause
     *
     */
    public TAOException(String whoIam, String whatIdo, Throwable why) {
        super(why);

        if (whoIam == null) {
            throw new IllegalArgumentException(String.format(TAO_EXCEPTION_MSG, WHO_I_AM));
        }
        if (whatIdo == null) {
            throw new IllegalArgumentException(String.format(TAO_EXCEPTION_MSG, WHAT_I_DO));
        }
        if (why == null) {
            throw new IllegalArgumentException(String.format(TAO_EXCEPTION_MSG, "why"));
        }

        this.componentName = whoIam;
        this.actionName = whatIdo;
        this.label = "";
    }
    
    /**
     * @param why l'exception cause
     *
     */
    public TAOException(Throwable why) {
        super(why);

        if (why == null) {
            throw new IllegalArgumentException(String.format(TAO_EXCEPTION_MSG, "why"));
        }

        this.componentName = this.getStackTrace()[0].getClassName();
        this.actionName = this.getStackTrace()[0].getMethodName();
        this.label = "";
    }

    /**
     * @param label un libellé d'erreur associé
     * @param why l'exception cause
     */
    public TAOException(String label, Throwable why) {
        super(label, why);

        if (why == null) {
            throw new IllegalArgumentException(String.format(TAO_EXCEPTION_MSG, "why"));
        }
        if (label == null) {
            throw new IllegalArgumentException(String.format(TAO_EXCEPTION_MSG, LABEL_NAME));
        }

        this.componentName = this.getStackTrace()[0].getClassName();
        this.actionName = this.getStackTrace()[0].getMethodName();
        this.label = label;
    }


}
