import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JButton button7 ;
    JButton button8 ;
    JButton button9 ;
    JButton button4 ;
    JButton button5 ;
    JButton button6 ;
    JButton button3 ;
    JButton button2 ;
    JButton button1 ;
    JButton button0 ;
    JButton buttonDot;
    JButton buttonInto ;
    JButton buttonEqual;
    JButton buttonDiv ;
    JButton buttonPlus ;
    JButton buttonMinus ;
    JButton buttonClear ;
    JLabel display ;

    String currentText ;

    Double answerTemp = 0.0 ;
    boolean operatorClicked = false ;
    boolean plusOperatorIsActive = false ;
    boolean minusOperatorIsActive = false ;
    boolean intoOperatorIsActive = false ;
    boolean divOperatorIsActive = false ;
    boolean operationOccured = false ;

    boolean ParseErrorCondition ;

    Calculator()
    {
        //creating frame
        JFrame jf = new JFrame("Calculator by shibil") ;

        //adding panel
        JPanel panel = new JPanel () ;
        panel.setLayout(null) ;
        jf.add(panel) ;

        jf.setBounds(200,300,465,600);
        jf.setLocationRelativeTo(null) ;
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        jf.setVisible(true) ;

        //creating j label object display
        display = new JLabel ("",SwingConstants.RIGHT) ;
        panel.add(display) ;
        display.setFont(new Font("Bahnschrift SemiCondensed",Font.PLAIN,85) );
        display.setVisible(true) ;
        display.setBounds(20,20,410,100) ;
        display.setOpaque(true) ;
        display.setBackground(Color.BLACK) ;
        display.setForeground(Color.WHITE) ;

        //setting icon to JFrame
        ImageIcon img = new ImageIcon("icon.png") ;
        jf.setIconImage(img.getImage()) ;


        //BUTTON 7
        button7 = new JButton ("7") ;
        panel.add(button7) ;
        button7.setVisible(true) ;
        button7.setBackground(Color.RED) ;
        button7.setFont(new Font("Arial Black",Font.PLAIN,60));
        button7.setForeground(Color.WHITE);
        button7.setBounds(20,140,100,100) ;
        button7.addActionListener(this) ;


        //BUTTON 8
        button8 = new JButton ("8") ;
        panel.add(button8) ;
        button8.setVisible(true) ;
        button8.setBackground(Color.RED) ;
        button8.setFont(new Font("Arial Black",Font.PLAIN,60));
        button8.setForeground(Color.WHITE);
        button8.setBounds(140,140,100,100) ;
        button8.addActionListener(this) ;


        //BUTTON 9
        button9 = new JButton ("9") ;
        panel.add(button9) ;
        button9.setVisible(true) ;
        button9.setBackground(Color.RED) ;
        button9.setFont(new Font("Arial Black",Font.PLAIN,60));
        button9.setForeground(Color.WHITE);
        button9.setBounds(260,140,100,100) ;
        button9.addActionListener(this) ;


        //BUTTON 4
        button4 = new JButton ("4") ;
        panel.add(button4) ;
        button4.setVisible(true) ;
        button4.setBackground(Color.RED) ;
        button4.setFont(new Font("Arial Black",Font.PLAIN,60));
        button4.setForeground(Color.WHITE);
        button4.setBounds(20,260,100,100) ;
        button4.addActionListener(this) ;


        //BUTTON 5
        button5 = new JButton ("5") ;
        panel.add(button5) ;
        button5.setVisible(true) ;
        button5.setBackground(Color.RED) ;
        button5.setFont(new Font("Arial Black",Font.PLAIN,60));
        button5.setForeground(Color.WHITE);
        button5.setBounds(140,260,100,100) ;
        button5.addActionListener(this) ;


        //BUTTON 6
        button6 = new JButton ("6") ;
        panel.add(button6) ;
        button6.setVisible(true) ;
        button6.setBackground(Color.RED) ;
        button6.setFont(new Font("Arial Black",Font.PLAIN,60));
        button6.setForeground(Color.WHITE);
        button6.setBounds(260,260,100,100) ;
        button6.addActionListener(this) ;


        //BUTTON 1
        button1 = new JButton ("1") ;
        panel.add(button1) ;
        button1.setVisible(true) ;
        button1.setBackground(Color.RED) ;
        button1.setFont(new Font("Arial Black",Font.PLAIN,60));
        button1.setForeground(Color.WHITE);
        button1.setBounds(20,380,100,100) ;
        button1.addActionListener(this) ;


        //BUTTON 2
        button2 = new JButton ("2") ;
        panel.add(button2) ;
        button2.setVisible(true) ;
        button2.setBackground(Color.RED) ;
        button2.setFont(new Font("Arial Black",Font.PLAIN,60));
        button2.setForeground(Color.WHITE);
        button2.setBounds(140,380,100,100) ;
        button2.addActionListener(this) ;


        //BUTTON 3
        button3 = new JButton ("3") ;
        panel.add(button3) ;
        button3.setVisible(true) ;
        button3.setBackground(Color.RED) ;
        button3.setFont(new Font("Arial Black",Font.PLAIN,60));
        button3.setForeground(Color.WHITE);
        button3.setBounds(260,380,100,100) ;
        button3.addActionListener(this) ;


        //BUTTON 0
        button0 = new JButton ("0") ;
        panel.add(button0) ;
        button0.setVisible(true) ;
        button0.setBackground(Color.RED) ;
        button0.setFont(new Font("Arial Black",Font.PLAIN,40));
        button0.setForeground(Color.WHITE);
        button0.setBounds(20,500,100,50) ;
        button0.addActionListener(this) ;


        //BUTTON dot
        buttonDot = new JButton (".") ;
        panel.add(buttonDot) ;
        buttonDot.setVisible(true) ;
        buttonDot.setBackground(Color.RED) ;
        buttonDot.setFont(new Font("Arial Black",Font.PLAIN,40));
        buttonDot.setForeground(Color.WHITE);
        buttonDot.setBounds(140,500,100,50) ;
        buttonDot.addActionListener(this) ;


        //BUTTON =
        buttonEqual = new JButton ("=") ;
        panel.add(buttonEqual) ;
        buttonEqual.setVisible(true) ;
        buttonEqual.setBackground(Color.GREEN) ;
        buttonEqual.setFont(new Font("Arial Black",Font.PLAIN,40));
        buttonEqual.setForeground(Color.RED);
        buttonEqual.setBounds(260,500,100,50) ;
        buttonEqual.addActionListener(this) ;


        //BUTTON clear
        buttonClear = new JButton ("c") ;
        panel.add(buttonClear) ;
        buttonClear.setVisible(true) ;
        buttonClear.setBackground(Color.YELLOW) ;
        buttonClear.setFont(new Font("Arial Black",Font.PLAIN,20));
        buttonClear.setForeground(Color.BLUE);
        buttonClear.setBounds(380,500,50,50) ;
        buttonClear.addActionListener(this) ;


        //BUTTON /
        buttonDiv = new JButton ("/") ;
        panel.add(buttonDiv) ;
        buttonDiv.setVisible(true) ;
        buttonDiv.setBackground(Color.BLUE) ;
        buttonDiv.setFont(new Font("Arial Black",Font.PLAIN,30));
        buttonDiv.setForeground(Color.WHITE);
        buttonDiv.setBounds(380,140,50,100) ;
        buttonDiv.addActionListener(this) ;


        //BUTTON X
        buttonInto = new JButton ("x") ;
        panel.add(buttonInto) ;
        buttonInto.setVisible(true) ;
        buttonInto.setBackground(Color.BLUE) ;
        buttonInto.setFont(new Font("Arial Black",Font.PLAIN,20));
        buttonInto.setForeground(Color.WHITE);
        buttonInto.setBounds(380,260,50,100) ;
        buttonInto.addActionListener(this) ;


        //BUTTON +
        buttonPlus = new JButton ("+") ;
        panel.add(buttonPlus) ;
        buttonPlus.setVisible(true) ;
        buttonPlus.setBackground(Color.BLUE) ;
        buttonPlus.setFont(new Font("Arial Black",Font.PLAIN,20));
        buttonPlus.setForeground(Color.WHITE);
        buttonPlus.setBounds(380,431,50,48) ;
        buttonPlus.addActionListener(this) ;


        //BUTTON -
        buttonMinus = new JButton ("-") ;
        panel.add(buttonMinus) ;
        buttonMinus.setVisible(true) ;
        buttonMinus.setBackground(Color.BLUE) ;
        buttonMinus.setFont(new Font("Arial Black",Font.PLAIN,30));
        buttonMinus.setForeground(Color.WHITE);
        buttonMinus.setBounds(380,380,50,48) ;
        buttonMinus.addActionListener(this) ;




    }
    public static void main(String[] args) {
        new Calculator() ;
    }

    void operation ()
    {
        if (plusOperatorIsActive)
        {
            answerTemp = answerTemp + Double.parseDouble(display.getText()) ;
            operationOccured = true ;
        }
        else if (minusOperatorIsActive)
        {
            answerTemp = answerTemp - Double.parseDouble(display.getText()) ;
            operationOccured = true ;
        }
        else if (intoOperatorIsActive)
        {
            answerTemp = answerTemp * Double.parseDouble(display.getText()) ;
            operationOccured = true ;
        }
        else if (divOperatorIsActive)
        {
            answerTemp = answerTemp / Double.parseDouble(display.getText()) ;
            operationOccured = true ;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //button clicks

        if (e.getSource() == button7)
        {
            if (operatorClicked)
            {
                display.setText("7") ;
                operatorClicked = false ;
            }
            else
            {
                currentText = display.getText() ;
                display.setText(currentText + "7") ;
            }
        }
        else if (e.getSource() == button8)
        {
            if (operatorClicked)
            {
                display.setText("8") ;
                operatorClicked = false ;
            }
            else
            {
                currentText = display.getText() ;
                display.setText(currentText + "8") ;
            }
        }
        else if (e.getSource() == button9)
        {
            if (operatorClicked)
            {
                display.setText("9") ;
                operatorClicked = false ;
            }
            else
            {
                currentText = display.getText() ;
                display.setText(currentText + "9") ;
            }
        }
        else if (e.getSource() == button4)
        {
            if (operatorClicked)
            {
                display.setText("4") ;
                operatorClicked = false ;
            }
            else
            {
                currentText = display.getText() ;
                display.setText(currentText + "4") ;
            }
        }
        else if (e.getSource() == button5)
        {
            if (operatorClicked)
            {
                display.setText("5") ;
                operatorClicked = false ;
            }
            else
            {
                currentText = display.getText() ;
                display.setText(currentText + "5") ;
            }
        }
        else if (e.getSource() == button6)
        {
            if (operatorClicked)
            {
                display.setText("6") ;
                operatorClicked = false ;
            }
            else
            {
                currentText = display.getText() ;
                display.setText(currentText + "6") ;
            }
        }
        else if (e.getSource() == button1)
        {
            if (operatorClicked)
            {
                display.setText("1") ;
                operatorClicked = false ;
            }
            else
            {
                currentText = display.getText() ;
                display.setText(currentText + "1") ;
            }
        }
        else if (e.getSource() == button2)
        {
            if (operatorClicked)
            {
                display.setText("2") ;
                operatorClicked = false ;
            }
            else
            {
                currentText = display.getText() ;
                display.setText(currentText + "2") ;
            }
        }
        else if (e.getSource() == button3)
        {
            if (operatorClicked)
            {
                display.setText("3") ;
                operatorClicked = false ;
            }
            else
            {
                currentText = display.getText() ;
                display.setText(currentText + "3") ;
            }
        }
        else if (e.getSource() == button0)
        {
            if (operatorClicked)
            {
                display.setText("0") ;
                operatorClicked = false ;
            }
            else
            {
                currentText = display.getText() ;
                display.setText(currentText + "0") ;
            }
        }
        else if (e.getSource() == buttonDot)
        {
            if (operatorClicked)
            {
                display.setText(".") ;
                operatorClicked = false ;
            }
            else
            {
                currentText = display.getText() ;
                display.setText(currentText + ".") ;
            }
        }

        //operation clicks

        else if (e.getSource() == buttonPlus)
        {
            operatorClicked = true ;
            operation();
            if (!operationOccured)
                answerTemp = Double.parseDouble(display.getText()) ;

            plusOperatorIsActive = true ;
            minusOperatorIsActive = false ;
            intoOperatorIsActive = false ;
            divOperatorIsActive = false ;

            display.setText("+") ;
        }
        else if (e.getSource() == buttonMinus)
        {
            operatorClicked = true ;
            operation() ;
            if(!operationOccured)
                answerTemp = Double.parseDouble(display.getText()) ;

            minusOperatorIsActive = true ;
            plusOperatorIsActive = false ;
            intoOperatorIsActive = false ;
            divOperatorIsActive = false ;

            display.setText("-") ;
        }
        else if (e.getSource() == buttonInto)
        {
            operatorClicked = true ;
            operation() ;
            if (!operationOccured)
                answerTemp = Double.parseDouble(display.getText()) ;

            intoOperatorIsActive = true ;
            plusOperatorIsActive = false ;
            minusOperatorIsActive = false ;
            divOperatorIsActive = false ;

            display.setText("x") ;
        }
        else if (e.getSource() == buttonDiv)
        {
            operatorClicked = true ;
            operation () ;
            if(!operationOccured)
                answerTemp = Double.parseDouble(display.getText()) ;

            divOperatorIsActive = true ;
            plusOperatorIsActive = false ;
            minusOperatorIsActive = false ;
            intoOperatorIsActive = false ;

            display.setText("/") ;
        }

        //equal button .

        else if (e.getSource() == buttonEqual)
        {
            operation() ;
            display.setText(answerTemp+"") ;
            answerTemp = 0.0 ;
            operationOccured = false ;
            plusOperatorIsActive = false ;
            minusOperatorIsActive = false ;
            intoOperatorIsActive = false ;
            divOperatorIsActive = false ;
        }

        //clear button

        else if (e.getSource() == buttonClear)
        {
            display.setText("") ;
            answerTemp = 0.0 ;
            operationOccured = false ;
            plusOperatorIsActive = false ;
            minusOperatorIsActive = false ;
            intoOperatorIsActive = false ;
            divOperatorIsActive = false ;
            operatorClicked = false ;
        }

    }
}