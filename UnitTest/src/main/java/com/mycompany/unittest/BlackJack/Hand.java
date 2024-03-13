package com.mycompany.unittest.BlackJack;

import java.util.ArrayList;

public class Hand 
{
    private int hardTotal = 0;
    private int softTotal = 0;
    private final int[]total = new int[]{hardTotal, softTotal};
    private final ArrayList<Card> hand = new ArrayList<>();
    private int finalPoint;
    private boolean splittable = false;

    public void add(Card card) 
    {
        hand.add(card);
    }
    
    public void show()
    {
        for(Card _card : this.hand)
        {            
            _card.show();

        }
    }
    
    public void setFinalPoint(int point)
    {
        this.finalPoint = point;
    }
    
    public int getFinalPoint()
    {
        return this.finalPoint;
    }
    
    public boolean isSplitable()
    {   
        this.splittable = hand.size() == 2 && hand.getFirst().getPoint() == hand.getLast().getPoint();
        return this.splittable;
    }

    private void calculatePoint() 
    {
        this.hardTotal = 0;
        this.softTotal = 0;
        for (Card card : hand) 
        {
            int point = card.getPoint();
            if (point == 1) 
            {
                this.softTotal += 11;
            }
            else
            {
                this.softTotal += point;
            }

            this.hardTotal += point;
            
        }
        if(this.softTotal > 21)
        {
            this.softTotal -= 10;
        }
        this.total[0] = this.hardTotal;
        this.total[1] = this.softTotal;
    }
    
    public int getHardTotal()
    {
        return this.hardTotal;
    }
    

    public int[] getTotal() 
    {   
        this.calculatePoint();
        return this.total;
    }
}
