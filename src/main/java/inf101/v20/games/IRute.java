package inf101.v20.games;

import java.awt.*;
import java.util.Collection;

/**
 * En klasse som er veldig lik Position som vi har jobbet med i forrige semester oppgave
 * Holde styr på hver enkel rute
 *
 * @author Sandra Solberg {sit006@uib.no}
 *
 *
 */

public interface IRute {

    /**
     * Sjekker om ruten er tom
     *
     * @True om den er tom
     *
     */
    public boolean isEmpty();


    /**
     * Sjekker om ruten er tom (inneholder Rute.OPEN)
     */
    public void setEmpty();



    /**
     *
     * @return Verdien til ruten som et tall
     */
    int getValue();

    /**
     * Color kanskje
     */

    /**
     * The color that represents the the cell state
     * @return The color that represents the the cell state
     */
    Color toColor();










}
