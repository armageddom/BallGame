package ball.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.*;

public class Ball_view extends SurfaceView {

    SurfaceHolder ourHolder;
    Bitmap Ball;


    public Ball_view(Context context) {
        super(context);

    }

    public Ball_view(Context context, AttributeSet attributes )
    {

        super( context, attributes ) ;

    }



    @Override
    public void onDraw(Canvas canvas) {

      super.onDraw(canvas);
      //Ball = BitmapFactory.decodeResource(getResources(),R.drawable.ball);

    }

}

