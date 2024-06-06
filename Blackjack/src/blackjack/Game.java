package blackjack;

public class Game 
{
    private Player player;
    private Deck deck;
    private Dealer dealer;
    
    public Game(Player player, Deck deck)
    {
        this.player = player;
        this.deck = deck;
        this.deck.shuffle();
        this.dealer = new Dealer();
    }
    
    public Player getPlayer(){
        return player;
    }
    
    public Deck getDeck() {
        return deck;
    }
    
    public Dealer getDealer(){
        return dealer;
    }
}
