package com.mycompany.unittest.BlackJack;

public class Game {
    private final Player player;
    private final Deck deck;
    private final Dealer dealer = new Dealer();
    
    public Game(Player player, Deck deck){
        this.player = player;
        this.deck = deck;
        this.deck.shuffle();
    }
    
    public void startNewRound(){
        player.draw(deck.deal());
        dealer.draw(deck.deal());
        player.draw(deck.deal());
        dealer.drawFaceDown(deck.deal());
        player.showHand();
        player.getHand().calcFinalScore();
        dealer.showStartingHand();
        this.dealerTurn(player.getHand().getFinalScore());
        this.findWinner();
    }
    
    public void dealerTurn(int scoreToBeat){
        dealer.reveal();
        dealer.showHand();
        dealer.getHand().calcFinalScore();
        while(dealer.getHand().getFinalScore() < scoreToBeat && dealer.getHand().getHardScore() < 17){
            if(dealer.hand.getSoftScore() > scoreToBeat && dealer.hand.getSoftScore() < 21){
                dealer.showHand();
                break;
            }
            else{
                System.out.println("Dealer draws one card");
                dealer.draw(deck.deal());
                dealer.showHand();
                dealer.getHand().calcScore();
            }
        }
        dealer.getHand().calcFinalScore();
    }
    
    public void findWinner(){
        System.out.println("Dealer's Score: " + dealer.getHand().getFinalScore());
        System.out.println("Player's Score: " + player.getHand().getFinalScore());
        if(dealer.getHand().getFinalScore() >= player.getHand().getFinalScore()){
            if(dealer.getHand().getFinalScore() < 22){
                System.out.println("Dealer wins");
            }
            else{
                System.out.println("Player wins - Dealer Bust");
            }
        }
        else if(player.getHand().getFinalScore() > dealer.getHand().getFinalScore()){
            if(player.getHand().getFinalScore() < 22){
                System.out.println("Player wins");
            }
            else{
                System.out.println("Dealer wins - Player Bust");
            }
        }
        
    }
    
}
