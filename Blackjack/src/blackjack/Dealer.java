package blackjack;

import java.util.ArrayList;

public class Dealer
{
    public String name = "Dealer";
    public ArrayList<Card> hand = new ArrayList<>();
    
    public void add(Card card)
    {
        hand.add(card);
    }
    
    public void add(Card card, boolean faceUp)
    {
        card.setFaceUp(faceUp);
        hand.add(card);
    }

}