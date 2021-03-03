package schwimmer.scrabble;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ScrabbleDictionary {

    private ArrayList<String> words = new ArrayList<>();
    private ArrayList<String> definitions = new ArrayList<>();

    public ScrabbleDictionary() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("src/main/resources/dictionary.txt"));
        while (scanner.hasNext()) {
            words.add(scanner.next());
            definitions.add(scanner.nextLine().trim());
        }
    }

    public boolean contains(String word) {
        return words.contains(word.toUpperCase());
    }

    public String getDefinition(String word) {
        int index = words.indexOf(word.toUpperCase());
        return index == -1 ? "" : definitions.get(index);
    }

    public int size() {
        return words.size();
    }

}
