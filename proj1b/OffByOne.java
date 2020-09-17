/** OffByOne for proj1 cs61b.
 * @author Yifan
 * 9/17/2020
 **/
public class OffByOne implements CharacterComparator {

    /**
     * compare integer values of two characters
     * and identify if they are equal.
     * @param x one character
     * @param y another character
     * @return true if they are equal by integer values, else false
     */
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(y - x) == 1;
    }
}
