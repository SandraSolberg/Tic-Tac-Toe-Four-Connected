package inf101.v20.games;

/**
 * En exception som kan kastets når spilleren prøver å velge en rute som allerede er opptatt
 *
 */

public class RuteException extends RuntimeException {

    public RuteException(String message) {
        super(message);
    }
}
