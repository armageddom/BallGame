package ball.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.*;
import ball.game.Ball;

public class Ball_view extends View {


    Ball pallo = new Ball(100, 100, Color.CYAN);

    public Ball_view(Context context) {
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {


      pallo.draw(canvas);

    /* Paint filling_paint = new Paint();
        filling_paint.setStyle(Paint.Style.FILL);
        filling_paint.setColor(pallo.ball_color);

        canvas.drawCircle(pallo.ball_center_point_x,
                pallo.ball_center_point_y, 64, filling_paint);

        Paint outline_paint = new Paint();
        outline_paint.setStyle(Paint.Style.STROKE);
        // Default color for a Paint is black.

        canvas.drawCircle(pallo.ball_center_point_x,
                pallo.ball_center_point_y, 64, outline_paint);

        canvas.drawText("(" + pallo.ball_center_point_x +
                        ", " + pallo.ball_center_point_y + ")",
                20, 20, outline_paint);
        */

    }

}



