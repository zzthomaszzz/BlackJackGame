package blackjack;

import java.util.ArrayList;

public class Player
{
    public int money;
    public String name;
    public ArrayList<Card> hand  = new ArrayList<>();
    
    public Player(String name, int money)
    {
        this.name = name;
        this.money = money;
    }

    public void add(Card card)
    {
        this.hand.add(card);
    }

}
