package GUI;

import javax.swing.*;
import blackjack.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class GameWindow implements ActionListener {

    JFrame frame = new JFrame();
    JButton hitButton = new JButton("Hit");
    JButton standButton = new JButton("Stand");
    JButton doubleButton = new JButton("Double");
    JButton dealButton = new JButton("New Game");

    JLabel playerScoreButton = new JLabel("Score: 0");
    JLabel dealerScoreButton = new JLabel("Dealer: 0");
    JLabel winnerText = new JLabel("Winner");


    Game game = new Game(new Player("Thomas", 1000), new Deck(6));
    Player player = game.getPlayer();
    Dealer dealer = game.getDealer();
    Deck deck = game.getDeck();
    int playerScore = 0;
    ArrayList<JButton> playerCard = new ArrayList<>();
    int dealerScore = 0;
    ArrayList<JButton> dealerCard = new ArrayList<>();
    boolean playerTurn = true;
    boolean dealerTurn = false;

    //Testing

    public void start(){
        dealer.add(deck.draw());
        dealer.add(deck.draw(), false);
        this.displayDealerCard();
        player.add(deck.draw());
        player.add(deck.draw());
        this.displayPlayerCard();
        SwingUtilities.updateComponentTreeUI(frame);
        this.updatePlayerScore();
    }

    private void disablePlayerAction(){
        hitButton.setVisible(false);
        standButton.setVisible(false);
        doubleButton.setVisible(false);
        dealButton.setVisible(true);
    }


    public GameWindow(){

        hitButton.setBounds(295, 450, 100, 25);
        hitButton.setFocusable(false);
        hitButton.addActionListener(this);
        
        standButton.setBounds(405, 450, 100, 25);
        standButton.setFocusable(false);
        standButton.addActionListener(this);
        
        doubleButton.setBounds(350, 480, 100, 25);
        doubleButton.setFocusable(false);
        doubleButton.addActionListener(this);

        dealButton.setBounds(350, 480, 100, 25);
        dealButton.setFocusable(false);
        dealButton.setVisible(false);
        dealButton.addActionListener(this);
        
        playerScoreButton.setBounds(375, 420, 150, 25);
        playerScoreButton.setFocusable(false);

        dealerScoreButton.setBounds(375, 220, 150, 25);
        dealerScoreButton.setFocusable(false);

        winnerText.setBounds(375, 240, 150, 25);
        winnerText.setFocusable(false);
        winnerText.setVisible(false);

        frame.add(hitButton);
        frame.add(standButton);
        frame.add(doubleButton);
        frame.add(playerScoreButton);
        frame.add(dealerScoreButton);
        frame.add(winnerText);
        frame.add(dealButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);

        this.start();
    }


    private void playerUpdate(){
        this.removePlayerCardDisplay();
        this.displayPlayerCard();
        this.updatePlayerScore();
    }

    private void dealerUpdate(){
        if (dealerTurn){
            for(Card card: dealer.getHand()){
                card.setFaceUp(true);
            }
            this.removeDealerCardDisplay();
            this.displayDealerCard();
            this.updateDealerScore();

            while(dealerScore < 17){
                dealer.add(deck.draw());
                this.removeDealerCardDisplay();
                this.displayDealerCard();
                this.updateDealerScore();
            }
            dealerTurn = false;
        }
    }

    private void updateWinner(){
        if(!playerTurn && !dealerTurn){
            if(playerScore > 21){
                winnerText.setText("Dealer wins");
            }
            if(dealerScore > 21 && playerScore < 22){
                winnerText.setText("Player wins");
            }
            if(dealerScore < 22 && playerScore < 22){
                if(dealerScore > playerScore){
                    winnerText.setText("Dealer wins");
                }
                else if (playerScore > dealerScore){
                    winnerText.setText("Player wins");
                }
                else {
                    winnerText.setText("Push");
                }
            }
            winnerText.setVisible(true);
            this.disablePlayerAction();
            dealButton.setVisible(true);
        }
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

    private void displayDealerCard(){
        int increment = 0;
        for (Card card : dealer.getHand()){
            JButton cardButton = new JButton(card.toString());
            dealerCard.add(cardButton);
            cardButton.setBounds(findOrigin(dealer.getHand().size(), card.getWidth()) + ((card.getWidth() + 5) * increment), 100, card.getWidth(), card.getHeight());
            cardButton.setFocusable(false);
            cardButton.setEnabled(false);
            frame.add(cardButton);
            increment += 1;
        }
    }
    
    private void updatePlayerScore(){
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
        playerScore = point;
        if (playerScore > 21){
            playerScoreButton.setText("Score: " + playerScore + " Busted!!!");
            hitButton.setEnabled(false);
            playerTurn = false;
            dealerTurn = false;
            this.disablePlayerAction();
            for(Card card: dealer.getHand()){
                card.setFaceUp(true);
            }
            this.removeDealerCardDisplay();
            this.displayDealerCard();
            this.updateDealerScore();
        }
        else{
            playerScoreButton.setText("Score: " + playerScore);
        }
    }

    private void updateDealerScore(){
        int point = 0;
        boolean hasAce = false;
        boolean AceOneTime = false;
        for(Card card : dealer.getHand()){
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
        dealerScore = point;
        if (dealerScore > 21){
            dealerScoreButton.setText("Score: " + dealerScore + " Busted!!!");
            hitButton.setEnabled(false);
            dealerTurn = false;
        }
        else{
            dealerScoreButton.setText("Score: " + dealerScore);
            hitButton.setEnabled(true);
        }
    }

    private void removeDealerCardDisplay(){
        for(JButton button : dealerCard){
            frame.remove(button);
        }
    }

    private void removePlayerCardDisplay(){
        for(JButton button : playerCard){
            frame.remove(button);
        }
    }
    
    private void update(){
        this.playerUpdate();
        this.dealerUpdate();
        this.updateWinner();
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
        }
        if(e.getSource() == standButton){
            playerTurn = false;
            dealerTurn = true;
        }
        if(e.getSource() == doubleButton){
            player.add(deck.draw());
            playerTurn = false;
            dealerTurn = true;
        }
        if(e.getSource() == dealButton){
            frame.dispose();
            GameWindow newGame = new GameWindow();
        }
        this.update();
        SwingUtilities.updateComponentTreeUI(frame);
    }
}


