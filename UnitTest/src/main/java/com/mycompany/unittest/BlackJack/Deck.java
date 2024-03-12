package com.mycompany.unittest.BlackJack;
import java.util.ArrayList;
import java.util.Collections;

public class Deck 
{
    private ArrayList<Card> deck = new ArrayList<>();
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
    
    public void showCards()
    {
        for (Card card: deck)
        {
            card.showCard();
        }
    }
    
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
    
}
