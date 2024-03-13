package com.mycompany.unittest.BlackJack;

public class Card 
{
    private boolean isFaceUp = true;
    private final rank rank;
    private final suit suit;
    private int point;
    
    public Card(rank value, suit suit)
    {
        this.rank = value;
        this.suit = suit;
        setPoint(this.rank.ordinal() + 1);
    }
    
    private void setPoint(int point)
    {
        if(point > 10)
        {
            this.point = 10;
        }
        else
        {
            this.point = point;
        }
    }
    
    public static enum suit 
    {
        Spades,
        Hearts,
        Clubs,
        Diamonds,
    }

public static enum rank
    {
        Ace,
        Two,
        Three,
        Four,
        Five,
        Six,
        Seven,
        Eight,
        Nine,
        Ten,
        Jack,
        Queen,
        King,
    }
    
    public void show()
    {
        if(this.isFaceUp)
        {
            System.out.print(" - " +this.rank + " of " + this.suit + " - ");
        }
        else
        {
            System.out.print(" - Hidden. - ");
        }
    }
    
    public void setFaceUp(boolean isFaceUp)
    {
        this.isFaceUp = isFaceUp;
    }
    
    public int getPoint()
    {
        return this.point;
    }
}
