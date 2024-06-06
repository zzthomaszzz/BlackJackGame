package blackjack;

public class Card 
{
    private boolean isFaceUp = true;
    private final rank rank;
    private final suit suit;
    private int point;
    public int width;
    public int height;
    
    public Card(rank value, suit suit)
    {
        this.rank = value;
        this.suit = suit;
        this.height = 120;
        this.width = 90;
        setPoint(this.rank.ordinal() + 1);
    }
    
    private void setPoint(int point)
    {
        this.point = Math.min(point, 10);
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

    public String toString(){
        if(this.isFaceUp){
            return this.rank + " ";
        }
        else{
            return "Hidden";
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
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
}
