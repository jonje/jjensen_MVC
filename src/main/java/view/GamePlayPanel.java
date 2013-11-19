package view;

import model.Game;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 11/18/13
 * Time: 8:39 AM
 */
public class GamePlayPanel extends JPanel implements PropertyChangeListener {

    private JLabel guessNumberLabel;
    private JLabel output;
    private JLabel numTrys;
    private JFormattedTextField textField;
    private Game game;

    private String numberOfGuesses = "Number of guesses: ";

    public GamePlayPanel(Game game) {
        this.game = game;

        guessNumberLabel = new JLabel("Enter your guess:");
        output = new JLabel();
        numTrys = new JLabel(numberOfGuesses + game.getNumberGuesses());
        textField = new JFormattedTextField();
        textField.setColumns(5);
        textField.setValue(new Integer(0));
        textField.addPropertyChangeListener("value", this);

        add(output);
        add(numTrys);
        add(guessNumberLabel);
        add(textField);


    }



    @Override
    public void propertyChange(PropertyChangeEvent evt) {


        if(((Number) textField.getValue()).intValue() != 0) {
            int guessNumber = ((Number) textField.getValue()).intValue();
            int guessResults = game.guess(guessNumber);
            String labelText = "";
            if(guessResults == 0) {
                labelText = "You Guessed Correct " + guessNumber + " was the number.\n";

            } else if(guessResults == -1) {
                labelText = "Too low\n";

            } else {
                labelText = "Too high\n";

            }

            numTrys.setText(numberOfGuesses + game.getNumberGuesses());
            output.setText(labelText);
        }
    }
}
