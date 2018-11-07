package com.tictactoe.tom.tictactoe;

import android.os.Bundle;

public class Game {
    final private int BOARD_SIZE = 3;
    private TileState[][] board;

    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver;

    public Game() {     // constructor
        board = new TileState[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = TileState.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }


    public TileState choose(int row, int column) {
        if (gameOver) {
            return TileState.INVALID;
        }
        if (board[row][column] == TileState.BLANK) {
            if (playerOneTurn == true) {
                playerOneTurn = false;
                board[row][column] = TileState.CROSS;
                movesPlayed ++;
                return TileState.CROSS;
            }
            else {
                playerOneTurn = true;
                board[row][column] = TileState.CIRCLE;
                movesPlayed ++;
                return TileState.CIRCLE;
            }
        }
        else {
            return TileState.INVALID;
        }
    }

    public void play(int row, int column, TileState state) {
        if (state != TileState.BLANK) {
            movesPlayed++;
            if (playerOneTurn) {
                playerOneTurn = false;
            } else {
                playerOneTurn = true;
            }
        }
        board[row][column] = state;
    }

    public GameState won() {
        GameState result = GameState.IN_PROGRESS;
        TileState check; // keep track which player did last action, check if this player won.
        if(playerOneTurn == true) { // player 2 just played
            check = TileState.CIRCLE;
        }
        else {  // player 1 just played
            check = TileState.CROSS;
        }
        if (checkRows(check) || checkColumns(check) || checkDiagonal(check)){
            gameOver = true;
            if(playerOneTurn == true) { // player 2 just played
                result = GameState.PLAYER_TWO;
            }
            else {  // player 1 just played
                result = GameState.PLAYER_ONE;
            }
        }
        else if(movesPlayed >= 9){
            result = GameState.DRAW;
        }
        return result;


    }

    private boolean checkRows(TileState check) {
        for(int i =0; i < BOARD_SIZE; i++) {
            boolean test = true;
            for(int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] != check) {
                    test = false;
                }
            }
            if (test) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(TileState check) {
        for(int i =0; i < BOARD_SIZE; i++) {
            boolean test = true;
            for(int j = 0; j < BOARD_SIZE; j++) {
                if (board[j][i] != check) {
                    test = false;
                }
            }
            if (test) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal(TileState check) {
        boolean test = true;
        for(int i=0; i < BOARD_SIZE; i++) {
            if (board[i][i] != check) {
                test = false;
            }
        }
        if(test){
            return true;
        }
        if((board[2][0] == check) && (board[0][2] == check) && (board[1][1] == check)) {
            return true;
        }
        return false;
    }

}

