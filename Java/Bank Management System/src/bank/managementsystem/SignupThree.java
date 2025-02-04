package bank.managementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JButton cancel, submit;
    JLabel card, accounttype, cardnumber, pin, pinnumber, service, cardnumberinfo, pininfo, subtitle;
    JRadioButton rbsaving, rbcurrent, rbfixed, rbrecuring;    
    JCheckBox atmcard, mobile, cheque, internetbanking, emailalerts, statement, info;
    String title; 
   
    SignupThree(String title){
        
        setLayout(null);
        this.title = title;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        
        subtitle = new JLabel("Page 3: Account Details");
        subtitle.setBounds(240, 50, 300, 30);
        subtitle.setForeground(Color.black);
        subtitle.setFont(new Font("serif", Font.BOLD, 20));
        add(subtitle);      
        
        accounttype = new JLabel("Account Type");
        accounttype.setBounds(40, 110, 150, 30);
        accounttype.setForeground(Color.black);
        accounttype.setFont(new Font("serif", Font.BOLD, 25));
        add(accounttype);  
        
        rbsaving = new JRadioButton("Saving Account");
        rbsaving.setBounds(40, 150, 150, 20);
        rbsaving.setBackground(Color.white);
        rbsaving.setFont(new Font("serif", Font.PLAIN, 14));
        add(rbsaving);
        
        rbcurrent = new JRadioButton("Current Account");
        rbcurrent.setBounds(40, 180, 150, 20);
        rbcurrent.setBackground(Color.white);
        rbcurrent.setFont(new Font("serif", Font.PLAIN, 14));
        add(rbcurrent);
        
        rbfixed = new JRadioButton("Fixed Deposit Account");
        rbfixed.setBounds(250, 150, 200, 20);
        rbfixed.setBackground(Color.white);
        rbfixed.setFont(new Font("serif", Font.PLAIN, 14));
        add(rbfixed);
        
        rbrecuring = new JRadioButton("Recuring Deposit Account");
        rbrecuring.setBounds(250, 180, 200, 20);
        rbrecuring.setBackground(Color.white);
        rbrecuring.setFont(new Font("serif", Font.PLAIN, 14));
        add(rbrecuring);
    
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbsaving);
        bg.add(rbcurrent);
        bg.add(rbfixed);
        bg.add(rbrecuring);
                
        card = new JLabel("Card Number");
        card.setBounds(40, 230, 150, 30);
        card.setForeground(Color.black);
        card.setFont(new Font("serif", Font.BOLD, 25));
        add(card); 
        
        cardnumberinfo = new JLabel("Your 16 Digit Card Number");
        cardnumberinfo.setBounds(40, 255, 150, 20);
        cardnumberinfo.setForeground(Color.black);
        cardnumberinfo.setFont(new Font("serif", Font.BOLD, 10));
        add(cardnumberinfo); 
        
        cardnumber = new JLabel("XXXX-XXXX-XXXX-1234");
        cardnumber.setBounds(260, 230, 300, 30);
        cardnumber.setForeground(Color.black);
        cardnumber.setFont(new Font("serif", Font.BOLD, 25));
        add(cardnumber); 
        
        pin = new JLabel("Pin");
        pin.setBounds(40, 290, 150, 30);
        pin.setForeground(Color.black);
        pin.setFont(new Font("serif", Font.BOLD, 25));
        add(pin);
        
        pininfo = new JLabel("Your 4 Digit Password");
        pininfo.setBounds(40, 315, 150, 20);
        pininfo.setForeground(Color.black);
        pininfo.setFont(new Font("serif", Font.BOLD, 10));
        add(pininfo); 
        
        pinnumber = new JLabel("XXXX");
        pinnumber.setBounds(260, 290, 150, 30);
        pinnumber.setForeground(Color.black);
        pinnumber.setFont(new Font("serif", Font.BOLD, 25));
        add(pinnumber);
       
        service = new JLabel("Service Required");
        service.setBounds(40, 360, 200, 30);
        service.setForeground(Color.black);
        service.setFont(new Font("serif", Font.BOLD, 25));
        add(service);       

        atmcard = new JCheckBox("ATM CARD");
        atmcard.setBounds(40, 400, 200, 20);
        atmcard.setBackground(Color.white);
        atmcard.setFont(new Font("serif", Font.PLAIN, 14));
        add(atmcard);

        mobile = new JCheckBox("Mobile Banking");
        mobile.setBounds(40, 430, 200, 20);
        mobile.setBackground(Color.white);
        mobile.setFont(new Font("serif", Font.PLAIN, 14));
        add(mobile);
        
        cheque = new JCheckBox("Cheque Book");
        cheque.setBounds(40, 460, 200, 20);
        cheque.setBackground(Color.white);
        cheque.setFont(new Font("serif", Font.PLAIN, 14));
        add(cheque);
        
        internetbanking = new JCheckBox("Internet Banking");
        internetbanking.setBounds(250, 400, 200, 20);
        internetbanking.setBackground(Color.white);
        internetbanking.setFont(new Font("serif", Font.PLAIN, 14));
        add(internetbanking);
        
        emailalerts = new JCheckBox("Email & SMS Alerts");
        emailalerts.setBounds(250, 430, 200, 20);
        emailalerts.setBackground(Color.white);
        emailalerts.setFont(new Font("serif", Font.PLAIN, 14));
        add(emailalerts);
        
        statement = new JCheckBox("E-Statement");
        statement.setBounds(250, 460, 200, 20);
        statement.setBackground(Color.white);
        statement.setFont(new Font("serif", Font.PLAIN, 14));
        add(statement);
        
        info = new JCheckBox("I hereby declares that the above entered details correct to the best of my knowledge", true);
        info.setBounds(70, 530, 450, 16);
        info.setBackground(Color.white);
        info.setFont(new Font("serif", Font.PLAIN, 12));
        add(info);
        
        submit = new JButton("Submit");
        submit.setBounds(170, 570, 100, 30);
        submit.setForeground(Color.white);  
        submit.setBackground(Color.black);
        submit.setBorder(null);
        submit.setFont(new Font("serif", Font.PLAIN, 20));
        submit.addActionListener(this);
        add(submit); 

        cancel = new JButton("Cancel");
        cancel.setBounds(320, 570, 100, 30);
        cancel.setForeground(Color.white);  
        cancel.setBackground(Color.black);
        cancel.setBorder(null);
        cancel.setFont(new Font("serif", Font.PLAIN, 20));
        cancel.addActionListener(this);
        add(cancel); 
        
        getContentPane().setBackground(Color.white); 
        setLayout(null);
        
        setBounds(250, 20, 700, 700);
        setVisible(true);
}
    public void actionPerformed (ActionEvent ae){
        
        if(ae.getSource()== submit){
      
            String accounttype = null;        
            if(rbsaving.isSelected()){
                accounttype= "Saving Account";
            } else if (rbcurrent.isSelected()){
                accounttype= "Current Account";
            }  else if (rbfixed.isSelected()){
                accounttype= "Fixed Deposit Account";
            } else if (rbrecuring.isSelected()){
                accounttype= "Recuring Deposit Account";
            }       
            
            Random ran = new Random();
            long cardnumber = (ran.nextLong() % 90000000L) + 5040936000000000L;           

            long pinnumber = (ran.nextLong() % 9000L) + 1000L;
                
            String service = "";
            if(atmcard.isSelected()){
                service= service + "ATM CARD";
            } else if (mobile.isSelected()){
                service= service + "Mobile Banking";
            }  else if (cheque.isSelected()){
                service= service + "Cheque Book";
            } else if (internetbanking.isSelected()){
                service= service + "Internet Banking";
            }else if (emailalerts.isSelected()){
                service= service + "Email & SMS ";
            }else if (statement.isSelected()){
                service= service + "Alerts E-Statement";
            }  
            
            try{
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(null, "Account type is Required");
                } else{
                       try{            
                        Conn c = new Conn();
                        String query = "INSERT INTO signupthree values( '"+accounttype+"', '"+service+"', '"+cardnumber+"','"+pinnumber+"', '"+title+"')";       
                        String query2 = "INSERT INTO login values( '"+cardnumber+"', '"+pinnumber+"', '"+title+"')";
                        
                        c.s.executeUpdate(query);    
                        c.s.executeUpdate(query2);
                        
                        JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: " + pinnumber);
                        //  create table signupthree(accounttype varchar(40), service varchar(20), cardnumber varchar(25),pinnumber varchar(10), title varchar(15));
                        setVisible(false);
                        new Deposit("pinnumber").setVisible(false);

                        }catch (Exception e){
                         e.printStackTrace();
                        }
                }       
            }catch (Exception e){
             e.printStackTrace();
            }
            
        } else if (ae.getSource()== cancel){
        setVisible(false);
        new Login().setVisible(true);
        }
      }
    
    public static void main (String[]args){        
       new SignupThree(""); 
    
    }

}