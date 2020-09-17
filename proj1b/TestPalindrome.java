import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        boolean actual1 = palindrome.isPalindrome("");
        boolean actual2 = palindrome.isPalindrome("a");
        boolean actual3 = palindrome.isPalindrome("abcba");
        boolean actual4 = palindrome.isPalindrome("abcbc");
        boolean actual5 = palindrome.isPalindrome(null);
        assertTrue("Any word of length 0 is a palindrome", actual1);
        assertTrue("Any word of length 1 is a palindrome", actual2);
        assertTrue("It is a palindrome", actual3);
        assertFalse("It is not a palindrome", actual4);
        assertEquals(false, actual5);
    }

    @Test
    public void testisPalindromeCc() {
        CharacterComparator cc = new OffByOne();
        boolean actual1 = palindrome.isPalindrome("", cc);
        boolean actual2 = palindrome.isPalindrome("a", cc);
        boolean actual3 = palindrome.isPalindrome("flake", cc);
        boolean actual4 = palindrome.isPalindrome("abcbc", cc);
        boolean actual5 = palindrome.isPalindrome(null, cc);
        assertTrue("Any word of length 0 is a palindrome", actual1);
        assertTrue("Any word of length 1 is a palindrome", actual2);
        assertTrue("It is a palindrome", actual3);
        assertFalse("It is not a palindrome", actual4);
        assertEquals(false, actual5);
    }
}