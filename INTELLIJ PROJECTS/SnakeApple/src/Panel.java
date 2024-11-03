import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;

public class Panel extends JPanel implements ActionListener {
    static final int GROUND_WIDTH = 500 ;
    static final int GROUND_HEIGHT = 500 ;
    static final int UNIT_SIZE = 20 ;
    static final int DELAY = 150 ;
    static final int MAX_UNITS = (GROUND_HEIGHT * GROUND_WIDTH) /( UNIT_SIZE * UNIT_SIZE );
    Timer timer ;
    Random random ;
    boolean running = false ;
    int appleX ;
    int appleY ;
    int[] bodyX = new int[MAX_UNITS];
    int[] bodyY = new int[MAX_UNITS] ;
    int bodyLength = 5 ;
    char direction = 'R' ;
    public Panel()
    {
        this.setPreferredSize(new Dimension(GROUND_WIDTH,GROUND_HEIGHT)) ;
        this.setBackground(Color.BLACK) ;
        this.setFocusable(true) ;
        random = new Random() ;
        startGame();


        this.requestFocusInWindow () ;
    }
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g) ;
        draw(g) ;
    }
    public void startGame ()
    {
        feedNewApple();
        running = true ;
        timer = new Timer (DELAY , this) ;
        timer.start();
    }
    public void feedNewApple()
    {
        appleX = (int) random.nextInt(((GROUND_WIDTH-UNIT_SIZE)/UNIT_SIZE)) * UNIT_SIZE;
        appleY = (int) random.nextInt(((GROUND_HEIGHT-UNIT_SIZE)/UNIT_SIZE)) * UNIT_SIZE;
    }
    public void draw (Graphics g)
    {
        //Drawing apple
        g.setColor(Color.RED) ;
        g.fillOval(appleX,appleY,UNIT_SIZE,UNIT_SIZE) ;

        //Drawing snake
        for (int i = 0 ; i < bodyLength ; i++)
        {
            g.setColor(Color.GREEN) ;
            g.fillRect(bodyX[i],bodyY[i],UNIT_SIZE,UNIT_SIZE) ;
        }
    }
    public void move ()
    {
          getKey();
          for (int i = bodyLength ; i>0 ; i--)
          {
              bodyX[i] = bodyX[i-1] ;
              bodyY[i] = bodyY[i-1] ;
          }
          switch (direction)
          {
              case 'U' :
                  bodyY[0] = bodyY[0] - UNIT_SIZE ;
                  break ;
              case 'D' :
                  bodyY[0] = bodyY[0] + UNIT_SIZE ;
                  break ;
              case 'R' :
                  bodyX[0] = bodyX[0] + UNIT_SIZE ;
                  break ;
              case 'L' :
                  bodyX[0] = bodyX[0] - UNIT_SIZE ;

          }
    }
    public void checkApple ()
    {
        if (bodyX[0] == appleX && bodyY[0] == appleY)
        {
            bodyLength++ ;
            feedNewApple();
        }

    }
    public void checkCollision ()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running)
        {
            move () ;
            checkApple () ;
            checkCollision () ;
        }
        repaint() ;
    }
    public void getKey ()
    {
        Scanner s = new Scanner (System.in) ;
        String director = s.next() ;

        if (director.equals("w"))
        {
            if (direction != 'D') direction = 'U' ;
        }
        else if (director.equals ("s"))
        {
            if (direction != 'U') direction = 'D' ;
        }
        else if (director.equals("d"))
        {
            if (direction != 'L') direction = 'R' ;
        }
        else if (director.equals("a"))
        {
            if (direction != 'R') direction = 'L' ;
        }
    }

}