package view;

import model.DataObject;
import model.Game;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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

    private DataObject packet;
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream outputStream;
    private boolean listening;
    private SwingWorker worker = new SwingWorker() {
        @Override
        protected Object doInBackground() throws Exception {
            listening = true;
            try {
                socket = new Socket("localhost", 5050);
                input = new ObjectInputStream(socket.getInputStream());
                outputStream = new ObjectOutputStream(socket.getOutputStream());

                while(listening) {
                    packet = (DataObject) input.readObject();
                    processInput(packet);
                }

            } catch(IOException io) {
                io.printStackTrace();
            }
            return null;
        }
    };
    private String numberOfGuesses = "Number of guesses: ";

    public GamePlayPanel() {

        guessNumberLabel = new JLabel("Enter your guess:");
        output = new JLabel();
        numTrys = new JLabel(numberOfGuesses + "0");
        textField = new JFormattedTextField();
        textField.setColumns(5);
        textField.setValue(new Integer(0));
        textField.addPropertyChangeListener("value", this);


        add(output);
        add(numTrys);
        add(guessNumberLabel);
        add(textField);

       worker.execute();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        packet = new DataObject(((Number) textField.getValue()).intValue());
        try {
            outputStream.writeObject(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void processInput(DataObject packet) {
        int guessResults = packet.getNumber();
        int guessNumber = ((Number) textField.getValue()).intValue();
        String labelText = "";
        if(guessResults == 0) {
            labelText = "You Guessed Correct " + guessNumber + " was the number.\n";

        } else if(guessResults == -1) {
            labelText = "Too low\n";

        } else {
            labelText = "Too high\n";

        }

        numTrys.setText(numberOfGuesses + packet.getNumberOfGuesses());
        output.setText(labelText);

    }
}
