package com.zuhairghias.tictactoe;

import android.widget.ImageView;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by HP on 5/10/2017.
 */

public class Square extends AppCompatActivity{
    private ImageView image;
    private int state;

    public Square(ImageView image) {
        this.image = image;
        reset();
    }
    public void setState(int i){
        this.state = i;
        if(i == 1){
            this.image.setImageResource(R.drawable.redcross);
        }else if(i == 2){
            this.image.setImageResource(R.drawable.redcircle);
        }
        this.image.setAlpha(1f);
    }
    public int getState(){
        return state;
    }
    public void reset(){
        this.state = 0;
        this.image.setAlpha(0f);
    }
}
