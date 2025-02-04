package bank.managementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener{
    
    JButton withdrawl, back ;
    JLabel amount;
    JTextField amountt;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        
        setLayout(null);
        this.pinnumber = pinnumber;
        setTitle("Deposit");
        
        amount = new JLabel("Enter the amount you want to withdraw");
        amount.setBounds(130, 230, 330, 25);
        amount.setForeground(Color.white);
        amount.setFont(new Font("serif", Font.BOLD, 15));
        add(amount);  
        
        amountt = new JTextField();        
        amountt.setBounds(130, 260, 260, 25);
        add(amountt);  
        
        withdrawl = new JButton("withdrawl");
        withdrawl.setBounds(250, 380, 150, 20);
        withdrawl.setForeground(Color.black);  
        withdrawl.setBackground(Color.white);
        withdrawl.setBorder(null);
        withdrawl.setFont(new Font("serif", Font.PLAIN, 15));
        withdrawl.addActionListener(this);
        add(withdrawl); 

        back = new JButton("Back");
        back.setBounds(250, 410, 150, 20);
        back.setForeground(Color.black);  
        back.setBackground(Color.white);
        back.setBorder(null);
        back.setFont(new Font("serif", Font.PLAIN, 15));
        back.addActionListener(this);
        add(back); 
        
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
        
        if(ae.getSource()== back){
            setVisible(false);
            new Transactions(""); 
            
        }else if (ae.getSource()== withdrawl){
            
            String number = amountt.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdrawl");
            }else{
                try{
                    Conn c = new Conn();
                    String query = "Insert into bank value ('"+pinnumber+"', '"+date+"', 'withdrawl', '"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " +number+ " withdrawl Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }catch (Exception e){
                e.printStackTrace();
             }
            }
        }
        
    }
    
    public static void main (String[]args){        
       new Withdrawl(""); 
    
    }

}

