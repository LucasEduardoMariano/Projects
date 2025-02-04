package bank.managementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton fastcash, deposit, cash, mini, change, exit ;
    String pinnumber;  
    JLabel text, newpin, renter;
    JTextField newpint, rentert;

    BalanceEnquiry(String pinnumber) {
        
        this.pinnumber = pinnumber;       
         
        text = new JLabel("Change Your Pin");
        text.setBounds(130, 230, 330, 25);
        text.setForeground(Color.white);
        text.setFont(new Font("serif", Font.BOLD, 15));
        add(text); 
                   
        exit = new JButton("Exit");
        exit.setBounds(280, 400, 100, 25);
        exit.setForeground(Color.black);  
        exit.setBackground(Color.white);
        exit.setBorder(null);
        exit.setFont(new Font("serif", Font.PLAIN, 20));
        exit.addActionListener(this);
        add(exit);  
        
        Conn c = new Conn();
        int balance = 0;
        try {            
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amout"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amout"));
                }
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
               
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0,700, 700);
        add(image);  
        
        text = new JLabel("Your Current Account balance is "+ balance);
        text.setBounds(130, 230, 330, 25);
        text.setForeground(Color.white);
        text.setFont(new Font("serif", Font.BOLD, 15));
        add(text); 
        
        getContentPane().setBackground(Color.white); 
        setLayout(null);
        
        setBounds(250, 20, 700, 700);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}