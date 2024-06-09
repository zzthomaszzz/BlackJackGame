package blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck 
{
    private ArrayList<Card> deck = new ArrayList<>();
    private ArrayList<Card> copiedDeck = new ArrayList<>();
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
        copiedDeck = deck;
    }
    
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
    
    public Card draw()
    {
        if(deck.isEmpty()){
            deck = copiedDeck;
        }
            Card drawnCard = this.deck.get(0);
            this.deck.remove(0);
            return drawnCard;

    }

}
