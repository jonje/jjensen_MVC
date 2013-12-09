package view;

import model.DataObject;
import model.Game;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 11/15/13
 * Time: 9:12 AM
 */
public class SetupPanel extends JPanel implements PropertyChangeListener {
    private Game game;

    private ServerSocket serverSocket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket clientSocket;

    private DataObject packet;
    private boolean listening;
    private JLabel infoLabel1;
    private SwingWorker worker = new SwingWorker() {
        @Override
        protected Object doInBackground() throws Exception {
            listening = true;
            try {
                serverSocket = new ServerSocket(5050);
                System.out.println("Waiting for client");
            } catch (IOException e) {
                e.printStackTrace();
            }
            clientSocket = serverSocket.accept();
            output = new ObjectOutputStream(clientSocket.getOutputStream());
            input = new ObjectInputStream((clientSocket.getInputStream()));


            while(listening) {
                try {
                    packet = (DataObject) input.readObject();
                    packet = processInput(packet);
                    output.writeObject(packet);
                    System.out.println("Packet sent");

                } catch (IOException io) {
                    io.printStackTrace();
                }
            }


            return null;
        }
    };
    private JFormattedTextField numberTextField;

    public SetupPanel() {
        game = new Game();
        infoLabel1 = new JLabel("Enter Number:");
        numberTextField = new JFormattedTextField();
        numberTextField.setColumns(3);
        numberTextField.setValue(new Integer(game.getNumber()));
        numberTextField.addPropertyChangeListener("value", this);

        this.add(infoLabel1);
        this.add(numberTextField);
        worker.execute();
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        game.setNumber(((Number) numberTextField.getValue()).intValue());

    }

    private DataObject processInput(DataObject packet) {
        packet.setNumber(game.guess(packet.getNumber()));
        packet.setNumberOfGuesses(game.getNumberGuesses());
        return packet;
    }
}
