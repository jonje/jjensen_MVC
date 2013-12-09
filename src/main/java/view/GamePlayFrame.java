package view;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 12/9/13
 * Time: 8:42 AM
 */
public class GamePlayFrame extends JFrame {

    public GamePlayFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new GamePlayPanel());
        this.setLocationRelativeTo(null);
    }

}
