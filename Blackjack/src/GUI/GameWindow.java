package GUI;

import javax.swing.*;
import blackjack.*;

public class GameWindow {

    JFrame frame = new JFrame();
    JButton hitButton = new JButton("Hit");
    JButton standButton = new JButton("Stand");
    JButton doubleButton = new JButton("Double");

    Game game = new Game();
    Player player = new Player("Thomas", 1000);
    Dealer dealer = new Dealer();
    Deck deck = new Deck(6);

    //Testing

    GameWindow(){

        hitButton.setBounds(295, 450, 100, 25);
        hitButton.setFocusable(false);
        standButton.setBounds(405, 450, 100, 25);
        standButton.setFocusable(false);
        doubleButton.setBounds(350, 480, 100, 25);
        doubleButton.setFocusable(false);

        frame.add(hitButton);
        frame.add(standButton);
        frame.add(doubleButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
