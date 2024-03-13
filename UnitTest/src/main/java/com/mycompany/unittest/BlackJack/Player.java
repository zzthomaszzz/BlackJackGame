package com.mycompany.unittest.BlackJack;
import java.util.ArrayList;

public class Player 
{
    private int money;
    private final String name;
    private final ArrayList<Hand> hand  = new ArrayList<>();
    private int currentHand;
    
    public Player(String name, int money)
    {
        this.name = name;
        this.money = money;
        this.hand.add(new Hand());
        this.setCurrentHand(1);
    }
    
    public int getCurrentHand()
    {
        return this.currentHand;
    }
    
    public void setCurrentHand(int handNumber)
    {
        this.currentHand = handNumber;
    }
    
    public void draw(Card card)
    {
        this.hand.getFirst().add(card);
    }
    
    public Hand getHand(int index)
    {
        return hand.get(index);
    }
    
    public void showHand()
    {
        for(Hand _hand : hand)
        {
            int handCount = 1;
            System.out.print("Player's Hand " + handCount + ": ");
            _hand.show();
            System.out.print("\n");
            handCount ++;
        }
    }
    
}
