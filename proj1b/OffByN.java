/** OffByN interface for proj1 cs61b.
 * @author Yifan
 * 9/17/2020
 **/
public class OffByN implements CharacterComparator {
    /** distance between two characters. */
    private int nn;

    /**
     * @param n distance between two characters.
     */
    public OffByN(int n) {
        nn = n;
    }
    /**
     * compare integer values of two characters
     * and identify if they are equal.
     * @param x one character
     * @param y another character
     * @return true if they are equal by integer values, else false
     */
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(y - x) == nn;
    }
}
