//import javax.swing.*;
//import java.awt.event.*;
//
//public class chatGptPanel extends JPanel {
//    private char direction = 'R'; // Default direction
//
//    public chatGptPanel () {
//        // Add a KeyListener to the panel to listen for key presses
//        addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                // Check if the 'S' key is pressed
//                if (e.getKeyChar() == 'S') {
//                    direction = 'D'; // Set direction to 'D' for down
//                    System.out.println("key d is pressed") ;
//                }
//            }
//        });
//
//        // Set the panel to be focusable so it can receive key events
//        setFocusable(true);
//        requestFocusInWindow();
//    }
//
//    // Override the paintComponent method to draw your game board
//
//    // Rest of your Panel class code
//
//    public char getDirection() {
//        return direction;
//    }
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Snake Game");
//        chatGptPanel panel = new chatGptPanel() ;
//        frame.add(panel);
//
//        frame.setSize(400, 400);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
//}
