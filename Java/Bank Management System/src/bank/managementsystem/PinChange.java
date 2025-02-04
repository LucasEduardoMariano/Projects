package bank.managementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class PinChange extends JFrame implements ActionListener{
    
    JButton fastcash, deposit, cash, mini, change, exit ;
    String pinchange;  
    JLabel text, newpin, renter;
    JTextField newpint, rentert;
    
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber; 
        setLayout(null);
        setTitle("ATM");
        
        text = new JLabel("Change Your Pin");
        text.setBounds(130, 230, 330, 25);
        text.setForeground(Color.white);
        text.setFont(new Font("serif", Font.BOLD, 15));
        add(text); 
                   
        newpin = new JLabel("New Pin");
        newpin.setBounds(130, 280, 330, 25);
        newpin.setForeground(Color.white);
        newpin.setFont(new Font("serif", Font.BOLD, 15));
        add(newpin); 
        
        newpint = new JTextField();
        newpint.setBounds(280, 280, 100, 25);
        newpint.setForeground(Color.white);
        newpint.setFont(new Font("serif", Font.BOLD, 15));
        add(newpint); 
        
        renter = new JLabel("Re-Enter New Pin");
        renter.setBounds(130, 320, 330, 25);
        renter.setForeground(Color.white);
        renter.setFont(new Font("serif", Font.BOLD, 15));
        add(renter);    
        
        rentert = new JTextField();
        rentert.setBounds(280, 320, 100, 25);
        rentert.setForeground(Color.white);
        rentert.setFont(new Font("serif", Font.BOLD, 15));
        add(rentert);
        
        exit = new JButton("Exit");
        exit.setBounds(280, 400, 100, 25);
        exit.setForeground(Color.black);  
        exit.setBackground(Color.white);
        exit.setBorder(null);
        exit.setFont(new Font("serif", Font.PLAIN, 20));
        exit.addActionListener(this);
        add(exit); 
        
        change = new JButton("Change");
        change.setBounds(130, 400, 100, 25);
        change.setForeground(Color.black);  
        change.setBackground(Color.white);
        change.setBorder(null);
        change.setFont(new Font("serif", Font.PLAIN, 20));
        change.addActionListener(this);
        add(change);
        
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
        
        if(ae.getSource()== change){
                try{
                    String npin = newpint.getText();
                    String rpin = rentert.getText();
                    
                    if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered Pin does not match");
                    return;
                    }
                    if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "PLease enter PIN");
                    return;
                    }
                    if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "PLease re-enter PIN");
                    return;
                    }
                    
                    Conn c = new Conn();
                    String query1 = "update bank set pin ='"+rpin+"' where pin = '"+pinnumber+"' ";
                    String query2 = "update login set pin ='"+rpin+"' where pin = '"+pinnumber+"' ";
                    String query3 = "update singupthree set pin ='"+rpin+"' where pin = '"+pinnumber+"' ";
                   
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    setVisible(false);
                    new Transactions(rpin).setVisible(true);  
                    

                    
            }  catch(Exception e){
                System.out.println(e);
            }          
        } else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);           
        }
        
    }
    
    public static void main (String[]args){        
       new PinChange(""); 
    
    }

}