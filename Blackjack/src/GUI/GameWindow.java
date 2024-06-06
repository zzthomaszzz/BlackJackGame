package GUI;

import javax.swing.*;
import blackjack.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameWindow implements ActionListener {

    JFrame frame = new JFrame();
    JButton hitButton = new JButton("Hit");
    JButton standButton = new JButton("Stand");
    JButton doubleButton = new JButton("Double");
    JLabel playerScoreButton = new JLabel("Score: 0");

    Game game = new Game(new Player("Thomas", 1000), new Deck(6));
    Player player = game.getPlayer();
    Dealer dealer = game.getDealer();
    Deck deck = game.getDeck();
    ArrayList<JButton> playerCard = new ArrayList<>();

    //Testing

    GameWindow(){

        hitButton.setBounds(295, 450, 100, 25);
        hitButton.setFocusable(false);
        hitButton.addActionListener(this);
        
        standButton.setBounds(405, 450, 100, 25);
        standButton.setFocusable(false);
        standButton.addActionListener(this);
        
        doubleButton.setBounds(350, 480, 100, 25);
        doubleButton.setFocusable(false);
        
        playerScoreButton.setBounds(375, 420, 100, 25);
        playerScoreButton.setFocusable(false);

        frame.add(hitButton);
        frame.add(standButton);
        frame.add(doubleButton);
        frame.add(playerScoreButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public Game getGame(){
        return game;
    }
    
    private void displayPlayerCard(){
        int increment = 0;
        for (Card card : player.getHand()){
            JButton cardButton = new JButton(card.toString());
            playerCard.add(cardButton);
            cardButton.setBounds(findOrigin(player.getHand().size(), card.getWidth()) + ((card.getWidth() + 5) * increment), 290, card.getWidth(), card.getHeight());
            cardButton.setFocusable(false);
            cardButton.setEnabled(false);
            frame.add(cardButton);
            increment += 1;
        }
    }
    
    private void updateScore(){
        int point = 0;
        boolean hasAce = false;
        boolean AceOneTime = false;
        for(Card card : player.getHand()){
            if(card.getPoint() == 1 && !hasAce){
                if (card.getPoint() + point + 10 < 22){
                    point += 11;
                    hasAce = true;
                }
                else{
                    point += card.getPoint();
                }
            }
            else{
                point += card.getPoint();    
            }
            if(point > 21 && hasAce && !AceOneTime){
                point -= 10;
                AceOneTime = true;
            }
        }
        playerScoreButton.setText("Score: " + point);
    }
    
    private void removePlayerCardDisplay(){
        for(JButton button : playerCard){
            frame.remove(button);
        }
    }
    
    private void clearPlayerCard(){
        player.getHand().clear();
    }
    
    private int findOrigin(int amount, int width){
        int frameWidth = 800;
        int origin = 0;
        if(amount != 0){
            if(amount % 2 == 0){
                origin = (frameWidth / 2) -  ((width * (amount / 2) + 5 * (amount / 2)));
            }
            else{
                origin = (frameWidth / 2) - (width * ((amount - 1) / 2) + (width / 2) + 5 * ((amount - 1) / 2)); 
            }
        }
        return origin;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == hitButton){
            player.add(deck.draw());
            this.removePlayerCardDisplay();
            this.displayPlayerCard();
            this.updateScore();
        }
        if(e.getSource() == standButton){
            this.removePlayerCardDisplay();
            this.clearPlayerCard();
            this.updateScore();
        }
        SwingUtilities.updateComponentTreeUI(frame);
    }
}


