package ball.game;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

/**
 * Created by jere on 2.3.2017.
 */

public class Ball_move extends AppCompatActivity implements SensorEventListener {
    Bitmap Ball;
    SensorManager Sensors;
    Ball_view ball_view;
    float startX = 400;
    float startY = 400;
    float x , y , sensorX , sensorY ;
    Paint paint;
    Path path;



    @Override
    public void onSensorChanged(SensorEvent event) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sensorX = event.values[0];
        sensorY = event.values[1];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {



    }


    public class Ball_view extends SurfaceView implements Runnable {

        SurfaceHolder ourHolder;
        Thread ourThread = null;
        boolean isRunning = true;



        public Ball_view(Context context) {

            super(context);
            ourHolder = getHolder();
            init();


        }

        public void pause() {
            isRunning = false;
            while (true) {
                try {
                    ourThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            ourThread = null;
        }

        public void resume() {
            isRunning = true;
            ourThread = new Thread(this);
            ourThread.start();

        }

        @Override
        public void run() {
            while (isRunning) {

                if (!ourHolder.getSurface().isValid())
                    continue;

                Canvas canvas = ourHolder.lockCanvas();
                canvas.drawColor(Color.CYAN);
                canvas.drawBitmap(Ball,startX+sensorY*120,startY+sensorX*120,null);
                canvas.drawRect(300, 300, 100, 100, paint);
                ourHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    String TAG;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Sensors = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(Sensors.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0){
            Sensor s = Sensors.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
            Sensors.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
            Log.e(TAG, "pääse ");
        }
        Ball = BitmapFactory.decodeResource(getResources(),R.drawable.rect);
        x = y = sensorX = sensorY = 0;
        ball_view = new Ball_view(this);
        ball_view.resume();
        setContentView(ball_view);


    }





    private void init(){
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);

    }
    @Override
    protected void onPause(){
        Sensors.unregisterListener(this);
        super.onPause();

    }



}