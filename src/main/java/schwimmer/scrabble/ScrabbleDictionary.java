package schwimmer.scrabble;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScrabbleDictionary {

    private final Map<String, String> wordsToDefinitions = new HashMap<>();

    public ScrabbleDictionary() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("src/main/resources/dictionary.txt"));
        while (scanner.hasNext()) {
            wordsToDefinitions.put(
                    scanner.next(), // key
                    scanner.nextLine().trim() // value
            );
        }
    }

    public boolean contains(String word) {
        return wordsToDefinitions.containsKey(word.toUpperCase());
    }

    public String getDefinition(String word) {
        String definition = wordsToDefinitions.get(word.toUpperCase());
        return definition == null ? "" : definition;
    }

    public int size() {
        return wordsToDefinitions.size();
    }

}
