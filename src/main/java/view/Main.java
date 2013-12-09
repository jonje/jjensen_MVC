package view;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 11/18/13
 * Time: 8:40 AM
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SetupFrameServer frame = new SetupFrameServer();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(200, 200);

                //frame.pack();
                frame.setVisible(true);

                GamePlayFrame frame2 = new GamePlayFrame();
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(200, 200);
                frame2.setVisible(true);
            }
        });

    }


}
