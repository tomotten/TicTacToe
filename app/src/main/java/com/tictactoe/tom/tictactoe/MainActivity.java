package com.tictactoe.tom.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Game game;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
    }

    public void tileClicked(View view) {
        Button button = (Button) view;
        int id = view.getId();
        int row = 0;
        int column = 0;
        switch(id) {
            case R.id.button1:
                row = 0;
                column = 0;
                break;
            case R.id.button2:
                row = 0;
                column = 1;
                break;
            case R.id.button3:
                row = 0;
                column = 2;
                break;
            case R.id.button4:
                row = 1;
                column = 0;
                break;
            case R.id.button5:
                row = 1;
                column = 1;
                break;
            case R.id.button6:
                row = 1;
                column = 2;
                break;
            case R.id.button7:
                row = 2;
                column = 0;
                break;
            case R.id.button8:
                row = 2;
                column = 1;
                break;
            case R.id.button9:
                row = 2;
                column = 2;
                break;
        }

        TileState state = game.choose(row, column);
        switch(state) {
            case CROSS:
                button.setText("X");
                break;
            case CIRCLE:
                button.setText("O");
                break;
            case INVALID:
                System.out.println("Invalid choise!");
                break;
        }

        if (game.goal() != GameState.IN_PROGRESS) {
            TextView result = (TextView) findViewById(R.id.resultText);
            if(game.goal() == GameState.DRAW) {
                result.setText("The game has ended in a draw!");
                return;
            }
            if(game.goal() == GameState.PLAYER_ONE) {
                result.setText("Player 1 has won the game!");
            }
            if(game.goal() == GameState.PLAYER_TWO) {
                result.setText("Player 2 has won the game!");
            }
        }
    }

    public void resetClicked(View view) {
        game = new Game();
        TextView result = (TextView) findViewById(R.id.resultText);
        result.setText(""); // clear winner text

        // Empty game field
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setText("");
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText("");
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setText("");
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setText("");
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setText("");
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setText("");
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setText("");
        Button button8 = (Button) findViewById(R.id.button8);
        button8.setText("");
        Button button9 = (Button) findViewById(R.id.button9);
        button9.setText("");
    }


}
