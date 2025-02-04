package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {          
        
        JLabel heading = new JLabel("Thankyou " + name + " for playing the Quiz");
        heading.setBounds(150, 110, 700, 30);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);
        
        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(395, 150, 300, 30);
        lblscore.setForeground(Color.WHITE);
        lblscore.setFont(new Font("Tahoma", Font.BOLD, 26));
        add(lblscore);
        
        JButton submit = new JButton("Play Again");
        submit.setBounds(350, 400, 120, 30);
        submit.setBackground(Color.black);
        submit.setBorder(null);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i4 = new ImageIcon (ClassLoader.getSystemResource("icons/score2.png"));
        JLabel image4 = new JLabel(i4);
        image4.setSize(750, 550);
        add(image4);
        
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}