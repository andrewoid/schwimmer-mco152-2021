package schwimmer.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.util.List;

public class ScrabbleController {

    @FXML
    private List<Label> answerLabels;
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

    public void onClear(ActionEvent event) {
        System.out.println("onClear()");
    }

    public void onSubmit(ActionEvent event) {

    }

    public void onLetterClicked(MouseEvent event) {

    }

}
