package TicTacToe;

public class Driver {
    public static void main(String[] args){
        Game game = new Game();
        System.out.println("game winner is: " + game.startGame());
    }
}
