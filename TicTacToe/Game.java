package TicTacToe;

import java.util.*;

import  com.sun.tools.javac.util.Pair;
public class Game {
    Deque<Player> players;
    Board board;

    public Game() {
        initializeGame();
    }

    void initializeGame(){
        players = new LinkedList<>();
        PlayingPiece xPiece = new PieceX();
        Player player1 = new Player("Ayush",xPiece);

        PlayingPiece oPiece = new PieceO();
        Player player2 = new Player("Soni",oPiece);

        players.add(player1);
        players.add(player2);

        board = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;

        while(noWinner){
            Player player = players.pollFirst();
            board.printBoard();
            List<Pair<Integer,Integer>> freeCells = board.getFreeCells();

            if(freeCells.isEmpty()){
                noWinner = false;
                break;
            }
            System.out.println("Player: "+player.name + " turn, please give row,column: ");
            Scanner sc = new Scanner(System.in);
            String rc = sc.nextLine();
            int row = Integer.parseInt(rc.split(",")[0]);
            int col = Integer.parseInt(rc.split(",")[1]);

            boolean pieceAddedSuccessfully = board.addPiece(row,col,player.playingPiece);

            if(!pieceAddedSuccessfully) {
                System.out.println("Cell is already occupied.");
                players.addFirst(player);
                continue;
            }
            players.addLast(player);
            boolean isWinner = board.gotWinner(player.playingPiece);
            if(isWinner) {
                return player.name;
            }
        }
        return "tie";
    }


}
