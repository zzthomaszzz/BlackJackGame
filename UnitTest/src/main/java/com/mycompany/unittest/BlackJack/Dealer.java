package com.mycompany.unittest.BlackJack;

public class Dealer
{
    private final String name = "Dealer";
    private final Hand hand = new Hand();
    
    public void draw(Card card)
    {
        this.hand.add(card);
    }
    
    public void drawFaceDown(Card card)
    {
        Card drawnCard = card;
        drawnCard.setFaceUp(false);
        this.hand.add(drawnCard);
    }
    
    public void showHand()
    {
        System.out.print("Dealer's Hand: ");
        hand.show();
        System.out.print("\n");
    }
}
