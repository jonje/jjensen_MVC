package view;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 12/5/13
 * Time: 8:34 AM
 */
public class SetupFrameServer extends JFrame {

    public SetupFrameServer() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new SetupPanel());
        this.setLocationRelativeTo(null);
    }

}
