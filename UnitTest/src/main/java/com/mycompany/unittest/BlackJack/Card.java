package com.mycompany.unittest.BlackJack;

public class Card 
{
    
    private final rank rank;
    private final suit suit;
    
    public Card(rank value, suit suit)
    {
        this.rank = value;
        this.suit = suit;
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
    Ace,
    }
    
    public void showCard()
    {
        System.out.println(this.rank + " of " + this.suit);
    }
}
