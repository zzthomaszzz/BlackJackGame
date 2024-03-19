package blackjack;

public final class Player {
    private final Hand hand = new Hand();  
    
    public Hand getHand(){
        return this.hand;
    }
    
    public void draw(Card card){
        this.hand.add(card);
    }
    
}
