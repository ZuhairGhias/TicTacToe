package com.zuhairghias.tictactoe;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by HP on 5/10/2017.
 */

public class TTTGame extends AppCompatActivity{

    int turn;
    private Square[] squares = new Square[9];
    MediaPlayer m;

    public TTTGame(ImageView[] views, MediaPlayer m) {

        for (int i = 0; i < 9; i++){
            this.squares[i] = new Square(views[i]);
        }
        reset();
        this.m = m;
    }
    public void play(int i){
        if(squares[i-1].getState() == 0 && GameOver() == 0) {
            squares[i - 1].setState(turn % 2 + 1);
            turn ++;
            m.start();
        }
    }
    public void reset(){
        turn = 0;
        for (int i = 0; i < 9; i++){
            this.squares[i].reset();
        }
    }
    public int GameOver(){
        int status = 0;
        if ((squares[0].getState() != 0 && squares[0].getState() == squares[1].getState() && squares[1].getState() == squares[2].getState())
                || (squares[3].getState() != 0 && squares[3].getState() == squares[4].getState() && squares[4].getState() == squares[5].getState())
                || (squares[6].getState() != 0 && squares[6].getState() == squares[7].getState() && squares[7].getState() == squares[8].getState())
                || (squares[0].getState() != 0 && squares[0].getState() == squares[3].getState() && squares[3].getState() == squares[6].getState())
                || (squares[1].getState() != 0 && squares[1].getState() == squares[4].getState() && squares[4].getState() == squares[7].getState())
                || (squares[2].getState() != 0 && squares[2].getState() == squares[5].getState() && squares[5].getState() == squares[8].getState())
                || (squares[0].getState() != 0 && squares[0].getState() == squares[4].getState() && squares[4].getState() == squares[8].getState())
                || (squares[2].getState() != 0 && squares[2].getState() == squares[4].getState() && squares[4].getState() == squares[6].getState())){

            status = ((turn+1)%2)+1;
        }else if (turn > 8){
            status = 3;
        }
        return status;
    }
}

