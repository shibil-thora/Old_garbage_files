import javax.swing.*;

public class Frame extends JFrame {
    static final int FRAME_WIDTH = 500 ;
    static final int FRAME_HEIGHT = 500 ;
    protected final int FRAME_LOCATION_X = 380;
    protected final int FRAME_LOCATION_Y = 100;
    public Frame ()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        this.setLocationRelativeTo(null) ;
        this.setTitle("Snake Apple by Shibil") ;
        this.setResizable(false) ;
        this.pack() ;
        this.setVisible(true) ;
        this.setLocationRelativeTo(null) ;
        this.setBounds(FRAME_LOCATION_X , FRAME_LOCATION_Y ,Panel.GROUND_WIDTH , Panel.GROUND_HEIGHT);
        this.add(new Panel()) ;
    }
}