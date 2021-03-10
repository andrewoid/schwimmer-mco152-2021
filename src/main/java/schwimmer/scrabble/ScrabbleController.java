package schwimmer.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.util.List;

public class ScrabbleController {

    @FXML
    List<Label> answerLabels;
    @FXML
    List<Label> letterLabels;

    private LetterBag letterBag = new LetterBag();

    private ScrabbleDictionary dictionary;

    public ScrabbleController() {
        try {
            dictionary = new ScrabbleDictionary();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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

    }

    public void onSubmit(ActionEvent event) {

    }

    public void onLetterClicked(MouseEvent event) {

    }

}
