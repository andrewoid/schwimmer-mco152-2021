package schwimmer.scrabble;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ScrabbleControllerTest {

    private LetterBag letterBag;
    private ScrabbleDictionary dictionary;
    private ScrabbleController controller;
    private List<Label> answerLabels;
    private List<Label> letterLabels;

    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(()->{});
    }

    @Test
    public void initialize() {
        // given
        givenScrabbleController();
        doReturn("T",
                "G",
                "L")
                .when(letterBag).nextLetter();

        // when
        controller.initialize();

        // then
        verify(controller.letterLabels.get(0)).setText("T");
        verify(controller.letterLabels.get(1)).setText("G");
        verify(controller.letterLabels.get(2)).setText("L");
        verify(letterBag, times(3)).nextLetter();
    }

    @Test
    public void onClear_noAnswer() {
        // given
        givenScrabbleController();

        // when
        controller.onClear(mock(ActionEvent.class));

        // then
        for (Label label : answerLabels) {
            verify(label).getText();
        }

        for (Label label : letterLabels) {
            verifyNoInteractions(label);
            //verify(label, never()).setText(anyString());
        }
    }

    @Test
    public void onClear_fullAnswer() {
        // given
        givenScrabbleController();
        doReturn("G").when(answerLabels.get(0)).getText();
        doReturn("H").when(answerLabels.get(1)).getText();
        doReturn("E").when(answerLabels.get(2)).getText();
        doReturn("").when(letterLabels.get(0)).getText();
        doReturn("").when(letterLabels.get(1)).getText();
        doReturn("").when(letterLabels.get(2)).getText();

        // when
        controller.onClear(mock(ActionEvent.class));

        // then
        verify(answerLabels.get(0)).getText();
        verify(answerLabels.get(0)).setText("");
        verify(answerLabels.get(1)).getText();
        verify(answerLabels.get(1)).setText("");
        verify(answerLabels.get(2)).getText();
        verify(answerLabels.get(2)).setText("");
        verify(letterLabels.get(0)).setText("G");
        verify(letterLabels.get(1)).setText("H");
        verify(letterLabels.get(2)).setText("E");
    }

    @Test
    public void onClear_someAnswer() {
        // given
        givenScrabbleController();
        doReturn("").when(answerLabels.get(0)).getText();
        doReturn("H").when(answerLabels.get(1)).getText();
        doReturn("").when(answerLabels.get(2)).getText();

        doReturn("G").when(letterLabels.get(0)).getText();
        doReturn("").when(letterLabels.get(1)).getText();
        doReturn("E").when(letterLabels.get(2)).getText();

        // when
        controller.onClear(mock(ActionEvent.class));

        // then
        verify(answerLabels.get(1)).getText();
        verify(answerLabels.get(1)).setText("");
        verify(letterLabels.get(1)).setText("H");
        verify(letterLabels.get(0), never()).setText(anyString());
        verify(letterLabels.get(2), never()).setText(anyString());
    }

    private void givenScrabbleController() {
        letterBag = mock(LetterBag.class);
        dictionary = mock(ScrabbleDictionary.class);
        controller = new ScrabbleController(dictionary, letterBag);
        letterLabels = Arrays.asList(
                mock(Label.class),
                mock(Label.class),
                mock(Label.class)
        );
        controller.letterLabels = letterLabels;
        answerLabels = Arrays.asList(
                mock(Label.class),
                mock(Label.class),
                mock(Label.class)
        );
        controller.answerLabels = answerLabels;
    }
}