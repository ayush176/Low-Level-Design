package TicTacToe;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    PlayingPiece board[][];

    public Board(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null){
                    System.out.print(" ");
                } else {
                    System.out.print(board[i][j].pieceType.name());
                }

                if(j==size-1) {
                    System.out.println();
                } else{
                    System.out.print(" |");
                }
            }
        }
    }

    public List<Pair<Integer,Integer>> getFreeCells(){
        List<Pair<Integer,Integer>> freeCells = new ArrayList<>();
        for(int i=0;i<size;i++) {
            for (int j = 0; j < size; j++) {
                if(board[i][j]==null){
                    freeCells.add(new Pair(i,j));
                }
            }
        }
        return freeCells;
    }

    boolean addPiece(int row,int col,PlayingPiece playingPiece){
        if(board[row][col] == null) {
            board[row][col] = playingPiece;
            return true;
        }
        return false;
    }

    boolean gotWinner(PlayingPiece playingPiece) {
        for(int i=0;i<size;i++) {
            for (int j = 0; j < size; j++) {
                if(board[i][j]==null || board[i][j] != playingPiece){
                    break;
                }
                if(j==size-1)return true;
            }
        }

        for(int j=0;j<size;j++) {
            for (int i = 0; i < size; i++) {
                if(board[i][j]==null || board[i][j] != playingPiece){
                    break;
                }
                if(i==size-1)return true;
            }
        }
        return false;
    }

}
