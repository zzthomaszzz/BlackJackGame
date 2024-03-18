package com.mycompany.unittest.BlackJack;

public final class Player {
    private final String name;
    private final Hand hand = new Hand();
    
    public Player(String name){
        this.name = name;
    }
    
    public Hand getHand(){
        return this.hand;
    }
    
    public void draw(Card card){
        this.hand.add(card);
    }
    
}
