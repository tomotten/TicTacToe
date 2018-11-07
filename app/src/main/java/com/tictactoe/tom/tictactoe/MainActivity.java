package com.tictactoe.tom.tictactoe;

import android.service.quicksettings.Tile;
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Button button1 = (Button) findViewById(R.id.button1);
        CharSequence txt1 = button1.getText();
        outState.putInt("button1", getState(txt1));

        Button button2 = (Button) findViewById(R.id.button2);
        CharSequence txt2 = button2.getText();
        outState.putInt("button2", getState(txt2));

        Button button3 = (Button) findViewById(R.id.button3);
        CharSequence txt3 = button3.getText();
        outState.putInt("button3", getState(txt3));

        Button button4 = (Button) findViewById(R.id.button4);
        CharSequence txt4 = button4.getText();
        outState.putInt("button4", getState(txt4));

        Button button5 = (Button) findViewById(R.id.button5);
        CharSequence txt5 = button5.getText();
        outState.putInt("button5", getState(txt5));

        Button button6 = (Button) findViewById(R.id.button6);
        CharSequence txt6 = button6.getText();
        outState.putInt("button6", getState(txt6));

        Button button7 = (Button) findViewById(R.id.button7);
        CharSequence txt7 = button7.getText();
        outState.putInt("button7", getState(txt7));

        Button button8 = (Button) findViewById(R.id.button8);
        CharSequence txt8 = button8.getText();
        outState.putInt("button8", getState(txt8));

        Button button9 = (Button) findViewById(R.id.button9);
        CharSequence txt9 = button9.getText();
        outState.putInt("button9", getState(txt9));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // keep value for button 1
        int value1 = savedInstanceState.getInt("button1");
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setText(getChars(value1));
        Bundle location1 = getLocation(R.id.button1);
        int row1 = location1.getInt("row");
        int column1 = location1.getInt("column");
        TileState state1 = getTileState(value1);
        game.play(row1, column1, state1);

        // keep value for button 2
        int value2 = savedInstanceState.getInt("button2");
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText(getChars(value2));
        Bundle location2 = getLocation(R.id.button2);
        int row2 = location2.getInt("row");
        int column2 = location2.getInt("column");
        TileState state2 = getTileState(value2);
        game.play(row2, column2, state2);

        // keep value for button 3
        int value3 = savedInstanceState.getInt("button3");
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setText(getChars(value3));
        Bundle location3 = getLocation(R.id.button3);
        int row3 = location3.getInt("row");
        int column3 = location3.getInt("column");
        TileState state3 = getTileState(value3);
        game.play(row3, column3, state3);

        // keep value for button 4
        int value4 = savedInstanceState.getInt("button4");
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setText(getChars(value4));
        Bundle location4 = getLocation(R.id.button4);
        int row4 = location4.getInt("row");
        int column4 = location4.getInt("column");
        TileState state4 = getTileState(value4);
        game.play(row4, column4, state4);

        // keep value for button 5
        int value5 = savedInstanceState.getInt("button5");
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setText(getChars(value5));
        Bundle location5 = getLocation(R.id.button5);
        int row5 = location5.getInt("row");
        int column5 = location5.getInt("column");
        TileState state5 = getTileState(value5);
        game.play(row5, column5, state5);

        // keep value for button 6
        int value6 = savedInstanceState.getInt("button6");
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setText(getChars(value6));
        Bundle location6 = getLocation(R.id.button6);
        int row6 = location6.getInt("row");
        int column6 = location6.getInt("column");
        TileState state6 = getTileState(value6);
        game.play(row6, column6, state6);

        // keep value for button 7
        int value7 = savedInstanceState.getInt("button7");
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setText(getChars(value7));
        Bundle location7 = getLocation(R.id.button7);
        int row7 = location7.getInt("row");
        int column7 = location7.getInt("column");
        TileState state7 = getTileState(value7);
        game.play(row7, column7, state7);

        // keep value for button 8
        int value8 = savedInstanceState.getInt("button8");
        Button button8 = (Button) findViewById(R.id.button8);
        button8.setText(getChars(value8));
        Bundle location8 = getLocation(R.id.button8);
        int row8 = location8.getInt("row");
        int column8 = location8.getInt("column");
        TileState state8 = getTileState(value8);
        game.play(row8, column8, state8);

        // keep value for button 9
        int value9 = savedInstanceState.getInt("button9");
        Button button9 = (Button) findViewById(R.id.button9);
        button9.setText(getChars(value9));
        Bundle location9 = getLocation(R.id.button9);
        int row9 = location9.getInt("row");
        int column9 = location9.getInt("column");
        TileState state9 = getTileState(value9);
        game.play(row9, column9, state9);
    }


    public void tileClicked(View view) {
        Button button = (Button) view;
        int id = view.getId();
        int row = 0;
        int column = 0;
        Bundle location = getLocation(id);
        row = location.getInt("row");
        column = location.getInt("column");
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
        if (game.won() != GameState.IN_PROGRESS) {
            TextView result = (TextView) findViewById(R.id.resultText);
            if(game.won() == GameState.DRAW) {
                result.setText("The game has ended in a draw!");
                return;
            }
            if(game.won() == GameState.PLAYER_ONE) {
                result.setText("Player 1 has won the game!");
            }
            if(game.won() == GameState.PLAYER_TWO) {
                result.setText("Player 2 has won the game!");
            }
        }
    }

    private Bundle getLocation(int id) {
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
        Bundle location = new Bundle();
        location.putInt("row", row);
        location.putInt("column", column);
        return location;
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

    private int getState(CharSequence txt) {
        if (txt == "X") {
            return 1;
        }
        if (txt == "O") {
            return 2;
        }
        return 0;
    }

    private CharSequence getChars(int i) {
        CharSequence res = "";
        switch (i) {
            case 0:
                res = "";
                break;
            case 1:
                res = "X";
                break;
            case 2:
                res = "O";
                break;
        }
        return res;
    }

    private TileState getTileState(int i) {
        TileState res = TileState.BLANK;
        switch (i) {
            case 0:
                res = TileState.BLANK;
                break;
            case 1:
                res = TileState.CROSS;
                break;
            case 2:
                res = TileState.CIRCLE;
                break;
        }
        return res;
    }




}
