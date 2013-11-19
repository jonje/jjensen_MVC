package view;

import model.Game;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 11/15/13
 * Time: 9:12 AM
 */
public class SetupPanel extends JPanel implements PropertyChangeListener {
    private Game game;

    private JLabel infoLabel1;
    private JFormattedTextField numberTextField;

    public SetupPanel(Game game) {
        this.game = game;

        infoLabel1 = new JLabel("Enter Number:");
        numberTextField = new JFormattedTextField();
        numberTextField.setColumns(3);
        numberTextField.setValue(new Integer(game.getNumber()));
        numberTextField.addPropertyChangeListener("value", this);

        this.add(infoLabel1);
        this.add(numberTextField);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        game.setNumber(((Number) numberTextField.getValue()).intValue());

    }
}
