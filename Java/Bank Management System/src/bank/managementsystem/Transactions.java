package bank.managementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton fastcash, deposit, pinchange, cash, mini, balance, exit ;
    String pinnumber;  
    JLabel text;
    
    Transactions(String pinumber){
        
        setLayout(null);
        this.pinnumber = pinnumber;
        setTitle("ATM");
        
        text = new JLabel("Please Select Your Transaction");
        text.setBounds(130, 230, 330, 25);
        text.setForeground(Color.white);
        text.setFont(new Font("serif", Font.BOLD, 15));
        add(text); 
                   
        deposit = new JButton("Deposit");
        deposit.setBounds(130, 320, 100, 25);
        deposit.setForeground(Color.black);  
        deposit.setBackground(Color.white);
        deposit.setBorder(null);
        deposit.setFont(new Font("serif", Font.PLAIN, 20));
        deposit.addActionListener(this);
        add(deposit); 
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(130, 350, 100, 25);
        fastcash.setForeground(Color.black);  
        fastcash.setBackground(Color.white);
        fastcash.setBorder(null);
        fastcash.setFont(new Font("serif", Font.PLAIN, 20));
        fastcash.addActionListener(this);
        add(fastcash); 
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(130, 380, 100, 25);
        pinchange.setForeground(Color.black);  
        pinchange.setBackground(Color.white);
        pinchange.setBorder(null);
        pinchange.setFont(new Font("serif", Font.PLAIN, 20));
        pinchange.addActionListener(this);
        add(pinchange); 
        
        cash = new JButton("Cash Withdrawl");
        cash.setBounds(250, 320, 150, 25);
        cash.setForeground(Color.black);  
        cash.setBackground(Color.white);
        cash.setBorder(null);
        cash.setFont(new Font("serif", Font.PLAIN, 20));
        cash.addActionListener(this);
        add(cash); 
        
        mini = new JButton("Mini Statement");
        mini.setBounds(250, 350, 150, 25);
        mini.setForeground(Color.black);  
        mini.setBackground(Color.white);;
        mini.setBorder(null);
        mini.setFont(new Font("serif", Font.PLAIN, 20));
        mini.addActionListener(this);
        add(mini); 
        
        balance = new JButton("Balance Enquiry");
        balance.setBounds(250, 380, 150, 25);
        balance.setForeground(Color.black);  
        balance.setBackground(Color.white);
        balance.setBorder(null);
        balance.setFont(new Font("serif", Font.PLAIN, 20));
        balance.addActionListener(this);
        add(balance); 

        exit = new JButton("Exit");
        exit.setBounds(250, 410, 150, 25);
        exit.setForeground(Color.black);  
        exit.setBackground(Color.white);
        exit.setBorder(null);
        exit.setFont(new Font("serif", Font.PLAIN, 20));
        exit.addActionListener(this);
        add(exit); 
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0,700, 700);
        add(image);  
        
        getContentPane().setBackground(Color.white); 
        setLayout(null);
        
        setBounds(250, 20, 700, 700);
        setVisible(true);
}
    public void actionPerformed (ActionEvent ae){
        
        if(ae.getSource()== exit){
            System.exit(0);            
        } else if (ae.getSource()== deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);           
        }else if (ae.getSource()== cash){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);           
        }else if (ae.getSource()== fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);           
        }else if (ae.getSource()== pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);           
        }else if (ae.getSource()== balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);           
        }else if (ae.getSource()== mini){
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);           
        }
        
    }
    
    public static void main (String[]args){        
       new Transactions(""); 
    
    }

}