package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchWindow implements ActionListener {

    JFrame frame = new JFrame();
    JButton startButton = new JButton("Start");
    JLabel gameTitle = new JLabel("Welcome To The Black Jack Game");
    
    public LaunchWindow(){

        startButton.setBounds(300, 280, 200, 40);
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        gameTitle.setBounds(200, 80, 500, 40);
        gameTitle.setFont(new Font(null, Font.PLAIN, 25));

        frame.add(startButton);
        frame.add(gameTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            frame.dispose();
            GameWindow gameWindow = new GameWindow();
        }
    }
}
