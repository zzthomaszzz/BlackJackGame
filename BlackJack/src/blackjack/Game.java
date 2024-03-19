package blackjack;

import java.util.Scanner;

public class Game {
    private final Player player;
    private final Deck deck;
    private final Dealer dealer = new Dealer();
    private final Scanner scan = new Scanner(System.in);
    private int winner = 0;
    
    public Game(Deck deck){
        this.player = new Player();
        this.deck = deck;
        this.deck.shuffle();
    }
    
    //Game System
    public void startNewRound(){
        roundStart();
        showAllHand();
        if(!dealerBlackJack()){
            if(!playerBlackJack()){
                playerTurn();
            }              
            if(!playerBust()){
                dealerTurn();
                findWinner();
            }

        }
        sayWinner();
    } 
    
    private void roundStart(){
        playerDraw();
        dealerDraw();
        playerDraw();
        dealerDrawFaceDown();
    }    
    
    private void showAllHand(){
        playerShow();
        System.out.print("\n");
        dealerShow();
        System.out.print("\n");
    }
    
    private void findWinner(){
        if(player.getHand().getFinalScore() > dealer.getHand().getSoftScore()){
            if(player.getHand().getFinalScore() < 22){
                this.winner = 1;
            }
        }
    }
    
    private void sayWinner(){
        if(dealerBlackJack()){
            System.out.println("Dealer hits Black Jack");
        }
        else if(dealerBust()){
            System.out.println("Dealer busts");
        }
        else if(playerBust()){
            System.out.println("Player busts");    
        }
        else{
            System.out.println("Dealer's Score: " + dealer.getHand().getFinalScore());
            System.out.println("Player's Score: " + player.getHand().getFinalScore());
        }
        if(this.winner == 1){
            System.out.println("Player wins");
        }
        else{
            System.out.println("Dealer wins");
        }
    }
    
    //Player Control System
    
    private boolean playerBust(){
        return player.getHand().getHardScore() > 21;
    }
    
    private boolean playerBlackJack(){
        return player.getHand().getFinalScore() == 21;
    }
    
    private void playerTurn(){
        int input = 1;
        
        OUTER:
        while (input != 0) {
            System.out.println("Options: ");
            System.out.println("1.Hit");
            System.out.println("2.Stand");
            System.out.println("Your decisions: ");
            input = scan.nextInt();
            switch (input) {
                case 1 -> {
                    playerHit();
                    if(playerBust()){
                        this.winner = -1;
                        break OUTER;
                    }
                    if(playerBlackJack()){
                        this.winner = 1;
                        break OUTER;
                    }
                }
                case 2 -> {
                    playerStand();
                    break OUTER;
                }
                default -> System.out.println("Invalid input");
            }
        }
    }
    
    private void playerHit(){
        System.out.println("Player hits");
        playerDraw();
        playerShow();
        System.out.print("\n");
    }
    
    private void playerStand(){
        System.out.println("Player stands");
    }
    
    private void playerDraw(){
        player.draw(deck.deal());
    }
    
    private void playerShow(){
        System.out.println("Player's hand: ");
        player.getHand().show();
        player.getHand().calcScore();
        System.out.print("Score: " + player.getHand().getHardScore() + " ");
        if(player.getHand().hasAce() && player.getHand().getSoftScore() < 22){
            System.out.print("Soft: " + player.getHand().getSoftScore());
        }
        System.out.print("\n");
    }
    
    //Dealer System
    
    private boolean dealerBust(){
        return dealer.getHand().getSoftScore() > 21;
    }
    
    private boolean dealerBlackJack(){
        if(dealer.getHand().getSoftScore() == 21){
            dealer.turnHiddenCard();
            return true;
        }
        return false;
    }    
    
    private void dealerDraw(){
        dealer.draw(deck.deal());
    }
    
    private void dealerDrawFaceDown(){
       dealer.drawFaceDown(deck.deal());
    }
       
    private void dealerTurn(){
        dealer.turnHiddenCard();
        dealerShowWithScore();
        while(dealer.getHand().getSoftScore() < 17){
                System.out.println("Dealer draws one card");
                dealerDraw();
                dealer.getHand().calcScore();
                dealerShowWithScore();
        }
        if(dealerBust()){
            this.winner = 1;
        }
    }  
        
    private void dealerShow(){
        System.out.println("Dealer's hand: ");
        dealer.getHand().show();
        dealer.getHand().calcScore();
        System.out.print("\n");
    }
    
    private void dealerShowWithScore(){
        System.out.println("Dealer's hand: ");
        dealer.getHand().calcScore();
        dealer.getHand().show();
        System.out.print("Score: " + dealer.getHand().getSoftScore() + " \n");
    }
    
}
