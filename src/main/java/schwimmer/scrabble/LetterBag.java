package schwimmer.scrabble;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * A class that holds the distribution of letters in our game.
 * http://www.bananagrammer.com/2009/07/letter-distributions-in-bananagrams-and.html
 */
public class LetterBag {

    private Stack<String> stack;

    public LetterBag() {
        List<String> list = Arrays.asList(
                "A", "A", "A", "A", "A", "A", "A", "A", "A",
                "B", "B",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C",
                "C", "C"
        );
        Collections.shuffle(list);
        stack = new Stack<>();
        stack.addAll(list);
    }

    /**
     *
     * @return the next random letter from our distribution
     */
    public String nextLetter() {
        return stack.pop();
    }

    /**
     *
     * @return true if there are no more letters available, otherwise false
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
