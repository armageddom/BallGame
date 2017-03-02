package ball.game;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import ball.game.Ball;
import ball.game.Ball_view;


public class MainGame extends AppCompatActivity {

    Ball_view ball_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_game_act);

        ball_view = (Ball_view) findViewById(R.id.ball_view);

    }


}
