package com.zuhairghias.tictactoe;

import android.app.Application;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TTTGame game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView bottomRight = (ImageView) findViewById(R.id.imageView1);
        ImageView bottomMiddle = (ImageView) findViewById(R.id.imageView2);
        ImageView bottomLeft = (ImageView) findViewById(R.id.imageView3);
        ImageView middleRight = (ImageView) findViewById(R.id.imageView4);
        ImageView middleMiddle = (ImageView) findViewById(R.id.imageView5);
        ImageView middleLeft = (ImageView) findViewById(R.id.imageView6);
        ImageView topRight = (ImageView) findViewById(R.id.imageView7);
        ImageView topMiddle = (ImageView) findViewById(R.id.imageView8);
        ImageView topLeft = (ImageView) findViewById(R.id.imageView9);

        ImageView[] views = {bottomRight, bottomMiddle, bottomLeft, middleRight, middleMiddle, middleLeft, topRight, topMiddle, topLeft};
        MediaPlayer m = MediaPlayer.create(this, R.raw.tick);
        game = new TTTGame(views, m);

        //int status = 0;
        //while(status == 0){
        //    status = game.GameOver();
        //}
        //Toast.makeText(this, "game status " + status, Toast.LENGTH_SHORT);
    }

    public void OnClick(View v){
        game.play(Integer.parseInt(getResources().getResourceEntryName(v.getId()).substring(9)));
        if(game.GameOver() == 1){
            Toast.makeText(MainActivity.this, "X WINS!", Toast.LENGTH_SHORT).show();
        }else if(game.GameOver() == 2){
            Toast.makeText(MainActivity.this, "O WINS!", Toast.LENGTH_SHORT).show();
        }else if(game.GameOver() == 3){
            Toast.makeText(MainActivity.this, "DRAW!", Toast.LENGTH_SHORT).show();
        }
    }
    public void OnReset(View v){
        game.reset();
    }
}
