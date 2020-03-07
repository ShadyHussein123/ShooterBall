import java.awt.Dimension;
import java.util.Random;
import java.awt.Color;

public class Ball implements Runnable
{

    static void init() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Dimension getPreferredSize()
    {
        return new Dimension( MAX_X, MAX_Y );
    } // end method getPreferredSize

    static void setPreferredSize(Dimension dimension) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    private boolean xUp, yUp;

    int x, y; // positions of ball

    private int xDx; // change in horizontal position of ball
    private int yDy; // change in vertical position of ball
    private final int MAX_X = 200; // horizontal edge of JPanel
    private final int MAX_Y = 200; // vertical edge of JPanel
    private Random generator = new Random();
    private Color color; // color of ball

    public Ball( int xPos, int yPos )
    {
        xUp = false;
        yUp = false;
        xDx = generator.nextInt( 5 ) + 1;
        yDy = generator.nextInt( 5 ) + 1;
        x = xPos;
        y = yPos;
        // color = new Color( generator.nextInt( 256 ),
        //    generator.nextInt( 256 ), generator.nextInt( 256 ) );
    } // end Ball constructor


    public void run()
    {
        while ( true ) // infinite loop
        {
            try
            {
                Thread.sleep( 20 ); // sleep for 20 milliseconds
            } // end try

            catch ( InterruptedException exception )
            {
                exception.printStackTrace();
            } // end catch

            // determine new x position
            if ( xUp == true )
                x += xDx;
            else
                x -= xDx;

            // determine new y position
            if ( yUp == true )
                y += yDy;
            else
                y -= yDy;

            if ( y <= 0 )
                yUp = true;
            else if ( y >= MAX_Y - 10 )
                yUp = false;

            if ( x <= 0 )
                xUp = true;
            else if ( x >= MAX_X - 10 )
                xUp = false;
        }  // end while
    } // end method run


    public int getX()
    {
        return x;
    } // end method getX


    public int getY()
    {
        return y;
    } // end method getY

    // get the ball's color
    public Color getColor()
    {
        return color;
    }
} // end class Ball