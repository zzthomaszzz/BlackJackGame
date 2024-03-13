package com.mycompany.unittest.BlackJack;

import java.util.ArrayList;

public class Hand 
{
//    private int hardTotal = 0;
//    private int softTotal = 0;
//    private final int[]total = new int[]{hardTotal, softTotal};
    private final ArrayList<Card> hand = new ArrayList<>();
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
    
    public boolean isSplitable()
    {   
        this.splittable = hand.size() == 2 && hand.getFirst().getPoint() == hand.getLast().getPoint();
        return this.splittable;
    }

    //three functions below may not be used.
//    private void calculatePoint() 
//    {
//        for (Card card : hand) 
//        {
//            if (card.getPoint() == 1) 
//            {
//                this.calculateSoftTotal();
//            }
//            hardTotal += card.getPoint();
//            this.total[0] = this.hardTotal;
//            this.total[1] = this.softTotal;
//        }
//    }
//
//    private void calculateSoftTotal() 
//    {
//        if (this.hardTotal + 10 < 21) 
//        {
//            this.softTotal = this.hardTotal + 10;
//        }
//    }
//    
//
//    public int[] getTotal() 
//    {
//        return this.total;
//    }
}
