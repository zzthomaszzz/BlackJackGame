package com.mycompany.unittest.BlackJack;
import java.util.ArrayList;

public final class Player 
{
    private int money;
    private final String name;
    private final ArrayList<Hand> hand  = new ArrayList<>();
    private int handNum;
    private boolean playerWin = false;
    
    public void setPlayerWin(boolean status)
    {
        this.playerWin = status;
    }
    
    public boolean getPlayerWin()
    {
        return this.playerWin;
    }
    
    public Player(String name, int money)
    {
        this.name = name;
        this.money = money;
        this.hand.add(new Hand());
        this.setCurrentHand(1);
    }
    
    public void setCurrentHand(int handNumber)
    {
        this.handNum = handNumber;
    }
    
    public void draw(Card card)
    {
        this.hand.get(this.handNum - 1).add(card);
    }
    
    public Hand getCurrentHand()
    {
        return hand.get(this.handNum - 1);
    }
    
    public void showHand()
    {
        for(Hand _hand : hand)
        {
            int handCount = 1;
            System.out.print("Player's Hand " + handCount + ": ");
            _hand.show();
            
            int[]result = _hand.getTotal();
            if(result[0] != 21 && result[1] != 21)
            {
                System.out.print("Points: " + result[0]);
                if(result[1] != 0 && result[1] > result[0] && result[1] < 21)
                {
                    System.out.print(" - Soft " + result[1] + ". ");
                }
            }
            else
            {
                System.out.print(" - Black Jack: 21! ");
                this.setPlayerWin(true);
            }
            System.out.print("\n");
            handCount ++;  
        }
    }
    
}
