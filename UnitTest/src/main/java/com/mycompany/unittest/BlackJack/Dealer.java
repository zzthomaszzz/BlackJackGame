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
    
    public void turnHiddenCard(){
        for(Card card : this.hand.getHand()){
            card.turnFaceUp();
        }
    }
    
    public Hand getHand(){
        return this.hand;
    }
}
