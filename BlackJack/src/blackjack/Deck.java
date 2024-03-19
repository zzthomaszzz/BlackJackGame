package blackjack;
import java.util.ArrayList;
import java.util.Collections;

public class Deck 
{
    private final ArrayList<Card> deck = new ArrayList<>();
    public Deck(int amount)
    {
        for(int i = 0; i < amount; i++)
        {
            for(Card.Rank rank : Card.Rank.values())
            {
                for(Card.Suit suit: Card.Suit.values())
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
        Card drawnCard = this.deck.get(0);
        this.deck.remove(this.deck.get(0));
        return drawnCard;
    }
    
}
