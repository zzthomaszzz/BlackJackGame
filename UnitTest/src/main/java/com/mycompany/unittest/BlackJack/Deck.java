package com.mycompany.unittest.BlackJack;
import java.util.ArrayList;
import java.util.Collections;

public class Deck 
{
    private final ArrayList<Card> deck = new ArrayList<>();
    public Deck(int amount)
    {
        for(int i = 0; i < amount; i++)
        {
            for(Card.rank rank : Card.rank.values())
            {
                for(Card.suit suit: Card.suit.values())
                {
                    deck.add(new Card(rank, suit));
                }
            }
        }
    }
    
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
    
    public Card deal()
    {
        Card drawnCard = this.deck.getFirst();
        this.deck.remove(this.deck.getFirst());
        return drawnCard;
    }
    
    //This function for testing purposes only
    public void showCards()
    {
        for (Card card: deck)
        {
            card.show();
        }
    }
    
}
