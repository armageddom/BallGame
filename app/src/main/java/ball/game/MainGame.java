package ball.game;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainGame extends AppCompatActivity {

    Ball_view ball_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ball_view = new Ball_view(this);
        setContentView(ball_view);
        //ball_view = (Ball_view) findViewById(R.id.ball_view);

        Intent ownIntent = new Intent(this, Ball_move.class);
        startActivity(ownIntent);

    }



}