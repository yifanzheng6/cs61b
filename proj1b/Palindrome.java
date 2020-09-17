/** check palindrome for proj1 cs61b.
 * @author Yifan
 * 9/17/2020
 **/
public class Palindrome {
    /**
     * transform a word into a deque.
     * @param word a string
     * @return a deque
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> D = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            D.addLast(word.charAt(i));
        }
        return D;
    }

    /**
     * identify if a word is palindrome.
     * @param word a string
     * @return true if it is palindrome, else false
     */
    public boolean isPalindrome(String word) {
        if (word == null) {
            return (false);
        } else {
            Deque<Character> dword = wordToDeque(word);
            return isPalindrome(dword);
        }
    }

    /**
     * helper function.
     * @param dword a deque
     * @return true if it is a palindrome
     */
    private boolean isPalindrome(Deque<Character> dword) {
        if (dword.size() == 0 || dword.size() == 1) {
            return (true);
        } else if (dword.removeFirst() == dword.removeLast()) {
            return isPalindrome(dword);
        }
        return (false);
    }

    /**
     * identify if a word is a palindrome
     * by character comparison test.
     * @param word a string
     * @param cc a CharacterComparator object
     * @return true if it is a palindrome, else false
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) {
            return (false);
        } else {
            Deque<Character> dword = wordToDeque(word);
            return isPalindrome(dword, cc);
        }
    }

    /**
     * helper function.
     * @param dword a deque
     * @param cc a CharacterComparator object
     * @return true if it is a palindrome, else false
     */
    private boolean isPalindrome(Deque<Character> dword,
                                 CharacterComparator cc) {
        if (dword.size() == 0 || dword.size() == 1) {
            return (true);
        } else if (cc.equalChars(dword.removeFirst(), dword.removeLast())) {
            return isPalindrome(dword, cc);
        }
        return (false);
    }

}
