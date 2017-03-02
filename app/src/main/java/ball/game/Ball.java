package ball.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;


public class Ball
{
    int ball_center_point_x  =  0 ;
    int ball_center_point_y  =  0 ;

    int ball_color  =  Color.RED ;

    int ball_diameter  =  128 ;

    boolean  this_ball_is_activated  =  false ;

    public Ball( int given_center_point_x,
                 int given_center_point_y,
                 int given_color )
    {
        ball_center_point_x  =  given_center_point_x ;
        ball_center_point_y  =  given_center_point_y ;
        ball_color           =  given_color ;
    }

    public void activate_ball()
    {
        this_ball_is_activated  =  true ;
    }

    public void deactivate_ball()
    {
        this_ball_is_activated  =  false ;
    }


    public int get_ball_center_point_x()
    {
        return ball_center_point_x ;
    }

    public int get_ball_center_point_y()
    {
        return ball_center_point_y ;
    }

    public int get_ball_diameter()
    {
        return ball_diameter ;
    }

    public void move_right()
    {
        ball_center_point_x  +=  3 ;
    }

    public void move_left()
    {
        ball_center_point_x  -=  3 ;
    }

    public void move_up()
    {
        ball_center_point_y  -=  3 ;
    }

    public void move_down()
    {
        ball_center_point_y  +=  3 ;
    }


    public void  move_this_ball( int movement_in_direction_x,
                                 int movement_in_direction_y )
    {
        ball_center_point_x  =  ball_center_point_x  +  movement_in_direction_x ;
        ball_center_point_y  =  ball_center_point_y  +  movement_in_direction_y ;
    }

    public void move_to_position( int new_center_point_x,
                                  int new_center_point_y )
    {
        ball_center_point_x  =  new_center_point_x ;
        ball_center_point_y  =  new_center_point_y ;
    }



    public void shrink()
    {
        //  The if-construct ensures that the ball does not become
        //  too small.

        if ( ball_diameter  > 10 )
        {
            ball_diameter  -=  6 ;
        }
    }


    public void enlarge()
    {
        ball_diameter  +=  6 ;
    }


    public void set_diameter( int new_diameter )
    {
        if ( new_diameter  >  5 )
        {
            ball_diameter  =  new_diameter ;
        }
    }

    public void set_color( int new_color )
    {
        ball_color  =  new_color ;
    }

    public boolean contains_point( Point given_point )
    {
        int  ball_radius  =  ball_diameter / 2 ;

        //  Here we use the Pythagorean theorem to calculate the distance
        //  from the given point to the center point of the ball.
        //  See the note at the end of this file.

        int  distance_from_given_point_to_ball_center  =

                (int) Math.sqrt(

                        Math.pow( ball_center_point_x  -  given_point.x, 2 )  +
                                Math.pow( ball_center_point_y  -  given_point.y, 2 )  ) ;

        return ( distance_from_given_point_to_ball_center  <=  ball_radius ) ;
    }

    public void draw( Canvas canvas )
    {
        Paint filling_paint = new Paint() ;
        filling_paint.setStyle( Paint.Style.FILL ) ;
        filling_paint.setColor( ball_color ) ;
        Paint outline_paint = new Paint() ;
        outline_paint.setStyle( Paint.Style.STROKE ) ;
        // Default color for a Paint is black.


        canvas.drawCircle( ball_center_point_x, ball_center_point_y,
                ball_diameter / 2, filling_paint ) ;

        //  If this ball is activated, it will have a thick black edge

        if ( this_ball_is_activated  ==  true )
        {
            outline_paint.setStrokeWidth( 3 ) ;
        }

        canvas.drawCircle( ball_center_point_x, ball_center_point_y,
                ball_diameter / 2, outline_paint ) ;
    }
}