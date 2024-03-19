package blackjack;
        
public class Main {
    public static void main(String[] args){
        Game game = new Game(new Deck(6));
        game.startNewRound();
    }
}
