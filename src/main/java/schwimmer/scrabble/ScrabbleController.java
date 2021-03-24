package schwimmer.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class ScrabbleController {

    @FXML
    List<Label> answerLabels;

    @FXML
    List<Label> letterLabels;

    @FXML
    Label pointsLabel;

    int points = 0;

    private final LetterBag letterBag;

    private final ScrabbleDictionary dictionary;

    // Dependency Injection
    // If a class depends on other objects, pass those objects in the constructor.
    public ScrabbleController(
            ScrabbleDictionary dictionary,
            LetterBag letterBag) {
        this.dictionary = dictionary;
        this.letterBag = letterBag;
    }

    @FXML
    public void initialize() {
        for (Label label : letterLabels) {
            label.setText(letterBag.nextLetter());
        }
    }

    /**
     * Return the letter in this answerLabel to an empty letterLabel if this Label is not empty.
     * @param event
     */
    public void onAnswerClicked(MouseEvent event) {
        Label label = (Label) event.getSource();
        String letter = label.getText();
        if (!letter.isEmpty()) {
            label.setText("");
            for (Label letterLabel : letterLabels) {
                String s = letterLabel.getText();
                if (s.isEmpty()) {
                    letterLabel.setText(letter);
                    break;
                }
            }
        }
    }

    /**
     * Returns the letters in answerLabels to letterLabels.
     *
     * @param event
     */
    public void onClear(ActionEvent event) {
        for (Label answerLabel : answerLabels) {
            String letter = answerLabel.getText();
            if (letter != null && !letter.isEmpty()) {
                answerLabel.setText("");
                for (Label letterLabel : letterLabels) {
                    if (letterLabel.getText().isEmpty()) {
                        letterLabel.setText(letter);
                        break;
                    }
                }
            }
        }
    }

    public void onSubmit(ActionEvent event) {
        StringBuilder builder = new StringBuilder();
        for (Label label : answerLabels) {
            String letter = label.getText();
            if (letter.isEmpty()) {
                break;
            }
            builder.append(letter);
        }
        String word = builder.toString();
        if (dictionary.contains(word)) {
            addPoints(word);
            pointsLabel.setText(String.valueOf(points));
            clearAnswerLabels();
            addNewLetters();
        }
    }

    private void addNewLetters() {
        for (Label label : letterLabels) {
            if (label.getText().isEmpty()) {
                label.setText(letterBag.nextLetter());
            }
        }
    }

    private void clearAnswerLabels() {
        for (Label label : answerLabels) {
            label.setText("");
        }
    }

    public void addPoints(String word) {
        switch (word.length()) {
            case 2:
                points += 1;
                break;
            case 3:
                points += 3;
                break;
            case 4:
                points += 5;
                break;
            case 5:
                points += 7;
                break;
            case 6:
                points += 11;
                break;
            case 7:
                points += 13;
                break;
        }
    }

    public void onLetterClicked(MouseEvent event) {
        Label label = (Label) event.getSource();
        String letter = label.getText();
        if (!letter.isEmpty()) {
            label.setText("");
            for (Label answerLabel : answerLabels) {
                String s = answerLabel.getText();
                if (s.isEmpty()) {
                    answerLabel.setText(letter);
                    break;
                }
            }
        }
    }

}
