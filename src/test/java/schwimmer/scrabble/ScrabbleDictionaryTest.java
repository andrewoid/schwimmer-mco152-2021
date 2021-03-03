package schwimmer.scrabble;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class ScrabbleDictionaryTest {

    @Test
    public void contains_true() throws FileNotFoundException {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        // when

        // then
        assertTrue(dictionary.contains("pineapple"));
    }
    @Test
    public void contains_false() throws FileNotFoundException {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        // when

        // then
        assertFalse(dictionary.contains("asdfasdfasff=d"));
    }

    @Test
    public void size() throws FileNotFoundException {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        // when

        // then
        assertEquals(167964, dictionary.size());
    }

    @Test
    public void getDefinition() throws FileNotFoundException {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        // when

        // then
        assertEquals("<pinecone=n> [n]", dictionary.getDefinition("pinecones"));
    }

}