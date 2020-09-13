/** ArrayDequeTest for proj1 cs61b.
 * @author Yifan
 * 9/13/2020
 **/

import jh61b.grader.GradedTest;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    /** create an empty deque and test isEmpty. */
    @Test
    public void EmptyTest() {
        ArrayDeque<String> A = new ArrayDeque<String>();
        assertTrue(A.isEmpty());
    }

    /** addFirst and removeFirst test. */
    @Test
    public void FirstTest() {
        ArrayDeque<String> A = new ArrayDeque<String>();
        A.addFirst("middle");
        A.removeFirst();
        assertTrue(A.isEmpty());
    }

    /** addLast and removeLast test. */
    @Test
    public void LastTest() {
        ArrayDeque<String> A = new ArrayDeque<String>();
        A.addLast("a");
        A.removeFirst();
        assertTrue(A.isEmpty());
        A.addFirst("b");
        A.removeLast();
        assertTrue(A.isEmpty());
    }

}
