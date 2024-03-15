package com.mycompany.unittest.BlackJack;

public class Dealer
{
    public final Hand hand = new Hand();
    
    public void draw(Card card){
        this.hand.add(card);
    }
    
    public void drawFaceDown(Card card){
        card.turnFaceDown();
        this.hand.add(card);
    }
    
    public void showStartingHand(){
        System.out.println("***Dealer's Hand: ***");
        hand.showHand();
        hand.calcScore();
        System.out.println("\n");
    }
    
    public void showHand(){
        System.out.println("***Dealer's Hand: ***");
        this.hand.showHand();
        this.hand.showScore();
        System.out.println("\n");
    }
    
    public void reveal(){
        for(Card card : this.hand.getHand()){
            card.turnFaceUp();
        }
    }
    
    public Hand getHand(){
        return this.hand;
    }
}
