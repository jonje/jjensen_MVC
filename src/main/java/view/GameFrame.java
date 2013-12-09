package view;

import model.Game;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 11/18/13
 * Time: 8:41 AM
 */
public class GameFrame extends JFrame {
    private Game game = new Game();

    private JTabbedPane tabbedPane;

    public GameFrame() {

        tabbedPane = new JTabbedPane();
        tabbedPane.add("Setup", new SetupPanel());
        tabbedPane.add("Play", new GamePlayPanel());

        this.setContentPane(tabbedPane);

    }

}
