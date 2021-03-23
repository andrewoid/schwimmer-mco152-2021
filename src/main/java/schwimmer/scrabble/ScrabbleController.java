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

    public void onAnswerClicked(MouseEvent event) {
        Label label = (Label) event.getSource();
    }

    /**
     * Returns the letters in answerLabels to letterLabels
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
                    }
                }
            }
        }
    }

    public void onSubmit(ActionEvent event) {

    }

    public void onLetterClicked(MouseEvent event) {

    }

}
