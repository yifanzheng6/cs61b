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
    public void emptyTest() {
        ArrayDeque<String> A = new ArrayDeque<String>();
        assertTrue(A.isEmpty());
    }

    /** addFirst and removeFirst test. */
    @Test
    public void firstTest() {
        ArrayDeque<String> A = new ArrayDeque<String>();
        A.addFirst("middle");
        A.removeFirst();
        assertTrue(A.isEmpty());
    }

    /** addLast and removeLast test. */
    @Test
    public void lastTest() {
        ArrayDeque<String> A = new ArrayDeque<String>();
        A.addLast("a");
        A.removeFirst();
        assertTrue(A.isEmpty());
        A.addLast("b");
        A.removeLast();
        assertTrue(A.isEmpty());
    }

    /**
     * error message from gradeScope.
     * arraycopy: last destination index 126 out of bounds for object array[60]
     * Inserting a bunch of stuff to the front,
     * removing it from the front,
     * and then insertFronting it back again.
     */
    @Test
    public void fillUpTest(){
        ArrayDeque<String> A = new ArrayDeque<String>();
        A.addFirst("a7");
        A.addFirst("a6");
        A.addFirst("a5");
        A.addFirst("a4");
        A.addFirst("a3");
        A.addFirst("a2");
        A.addFirst("a1");
        A.addFirst("a0");
        A.addFirst("a05");
        A.addFirst("a04");
        A.addFirst("a03");
        A.addFirst("a02");
        A.addFirst("a01");
        A.addFirst("a00");
        A.removeFirst();
        A.addFirst("aNew");
        assertEquals(A.get(0), "aNew");
    }

    /**
     * error message from gradeScope.
     * last destination index 1022 out of bounds for object array[508]
     * Creating multiple ArrayDeque objects at the same time.
     */

    /**
     * error message from gradeScope
     * Total memory usage after inserting N items and then
     * deleting all but one item, where N is a power of 2.
     */
    @Test
    public void memoryTest() {
        ArrayDeque<Integer> A = new ArrayDeque<Integer>();
        int i = 0;
        while (i<64) {
            A.addFirst(i*10);
            i += 1;
        }
        int j = 0;
        while (j < 63) {
            A.removeFirst();
            j += 1;
        }

        assertTrue(A.size() == 1);
    }


}
