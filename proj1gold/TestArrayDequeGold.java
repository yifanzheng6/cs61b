import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void randomTest() {
        StudentArrayDeque<Integer> sD = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> D = new ArrayDequeSolution<Integer>();
        String message = new String();
        while (true) {
            int i = StdRandom.uniform(4);
            if (i == 0) {
                sD.addFirst(0);
                D.addFirst(0);
                message = message.concat("addFirst(0)\n");
                assertEquals(message, sD.get(0), D.get(0));
            } else if (i == 1) {
                sD.addLast(1);
                D.addLast(1);
                int sizeSD = sD.size();
                int sizeD = D.size();
                message = message.concat("addLast(1)\n");
                assertEquals(message, sD.get(sizeSD - 1), sD.get(sizeD - 1));
            } else if (i == 2 && D.size() > 0) {
                message = message.concat("removeFirst()\n");
                assertEquals(message, sD.removeFirst(), D.removeFirst());
            } else if (i == 3 && D.size() > 0) {
                message = message.concat("removeLast()\n");
                assertEquals(message, sD.removeLast(), D.removeLast());
            }
        }
    }
}
