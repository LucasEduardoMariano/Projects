package bank.managementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
    
    JTextField namet, lastnamet, districtt, pscodet, emailt, addresst, cityt;
    JButton next;
    JLabel name, lastname, dateb, gender , email, marital, address, city, pscode, district, title, subtitle;
    JRadioButton rbfemale, rbmale, rbbinary, rbmarried, rbunmarried, rbother;
    JDateChooser dateChooser;
    long random;
    
    SignupOne(){
        
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong()% 9000L)+ 1000L);
        
        title = new JLabel("APPLICATION FORM N°" + random);
        title.setBounds(170, 20, 350, 30);
        title.setForeground(Color.black);
        title.setFont(new Font("serif", Font.BOLD, 25));
        add(title);
        
        subtitle = new JLabel("Page 1: Personal Details");
        subtitle.setBounds(240, 50, 300, 30);
        subtitle.setForeground(Color.black);
        subtitle.setFont(new Font("serif", Font.BOLD, 20));
        add(subtitle); 
      
        
        name = new JLabel("Name");
        name.setBounds(40, 120, 100, 30);
        name.setForeground(Color.black);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);  
        
        namet = new JTextField();        
        namet.setBounds(160, 130, 400, 20);
        add(namet); 
        
        lastname = new JLabel("Last Name");
        lastname.setBounds(40, 165, 100, 30);
        lastname.setForeground(Color.black);
        lastname.setFont(new Font("serif", Font.BOLD, 20));
        add(lastname);  
        
        lastnamet = new JTextField();        
        lastnamet.setBounds(160, 170, 400, 20);
        add(lastnamet);
        
        dateb = new JLabel("Date of Birth");
        dateb.setBounds(40, 200, 150, 30);
        dateb.setForeground(Color.black);
        dateb.setFont(new Font("serif", Font.BOLD, 20));
        add(dateb);       
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(160, 210, 400, 20);
        add(dateChooser);

        
        gender = new JLabel("Gender");
        gender.setBounds(40, 230, 100, 30);
        gender.setForeground(Color.black);
        gender.setFont(new Font("serif", Font.BOLD, 20));
        add(gender);
        
        rbfemale = new JRadioButton("female");
        rbfemale.setBounds(180, 230, 70, 30);
        rbfemale.setBackground(Color.white);
        rbfemale.setFont(new Font("serif", Font.PLAIN, 14));
        add(rbfemale);
        
        rbmale = new JRadioButton("male");
        rbmale.setBounds(270, 230, 70, 30);
        rbmale.setBackground(Color.white);
        rbmale.setFont(new Font("serif", Font.PLAIN, 14));
        add(rbmale);
        
        rbbinary = new JRadioButton("Non - Binary");
        rbbinary.setBounds(370, 230, 150, 30);
        rbbinary.setBackground(Color.white);
        rbbinary.setFont(new Font("serif", Font.PLAIN, 14));
        add(rbbinary);   
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbfemale);
        bg.add(rbmale);
        bg.add(rbbinary);
        
        email = new JLabel("Email");
        email.setBounds(40, 273, 100, 30);
        email.setForeground(Color.black);
        email.setFont(new Font("serif", Font.BOLD, 20));
        add(email);  
        
        emailt = new JTextField();        
        emailt.setBounds(160, 280, 400, 20);
        add(emailt);
        
        marital = new JLabel("Marital Status");
        marital.setBounds(40, 330, 150, 30);
        marital.setForeground(Color.black);
        marital.setFont(new Font("serif", Font.BOLD, 20));
        add(marital);
        
        rbmarried = new JRadioButton("Married");
        rbmarried.setBounds(180, 330, 70, 30);
        rbmarried.setBackground(Color.white);
        rbmarried.setFont(new Font("serif", Font.PLAIN, 14));
        add(rbmarried);
        
        rbunmarried = new JRadioButton("Unmarried");
        rbunmarried.setBounds(270, 330, 100, 30);
        rbunmarried.setBackground(Color.white);
        rbunmarried.setFont(new Font("serif", Font.PLAIN, 14));
        add(rbunmarried);
        
        rbother = new JRadioButton("Other");
        rbother.setBounds(370, 330, 100, 30);
        rbother.setBackground(Color.white);
        rbother.setFont(new Font("serif", Font.PLAIN, 14));
        add(rbother);
        
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(rbmarried);
        bg1.add(rbunmarried);
        bg1.add(rbother);
        
        address = new JLabel("Address");
        address.setBounds(40, 375, 100, 30);
        address.setForeground(Color.black);
        address.setFont(new Font("serif", Font.BOLD, 20));
        add(address);  
        
        addresst = new JTextField();        
        addresst.setBounds(160, 380, 400, 20);
        add(addresst);
                
        city = new JLabel("City");
        city.setBounds(40, 425, 100, 30);
        city.setForeground(Color.black);
        city.setFont(new Font("serif", Font.BOLD, 20));
        add(city);  
        
        cityt = new JTextField();        
        cityt.setBounds(160, 430, 400, 20);
        add(cityt); 
        
        district = new JLabel("District");
        district.setBounds(40, 475, 100, 30);
        district.setForeground(Color.black);
        district.setFont(new Font("serif", Font.BOLD, 20));
        add(district);  
        
        districtt = new JTextField();        
        districtt.setBounds(160, 480, 400, 20);
        add(districtt);     
        
        pscode = new JLabel("Postal Code");
        pscode.setBounds(40, 525, 150, 30);
        pscode.setForeground(Color.black);
        pscode.setFont(new Font("serif", Font.BOLD, 20));
        add(pscode);  
        
        pscodet = new JTextField();        
        pscodet.setBounds(160, 530, 400, 20);
        add(pscodet);         
        
        next = new JButton("next");
        next.setBounds(550, 600, 75, 30);
        next.setForeground(Color.white);  
        next.setBackground(Color.black);
        next.setBorder(null);
        next.setFont(new Font("serif", Font.PLAIN, 20));
        next.addActionListener(this);
        add(next); 
        
        getContentPane().setBackground(Color.white); 
        setLayout(null);
        
        setBounds(250, 20, 700, 700);
        setVisible(true);
}      
      
   public void actionPerformed (ActionEvent ae){
        String title = "" + random;
        String name = namet.getText();
        String lastname = lastnamet.getText();
        String dateb = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText(); 
        String city = cityt.getText();
        String email = emailt.getText();
        String address = addresst.getText();  
        String pscode = pscodet.getText();
        String district = districtt.getText();
        String gender = null;        
        
        if(rbmale.isSelected()){
            gender= "Male";
        } else if (rbfemale.isSelected()){
            gender= "female";
        }
           
        String marital = null;        
        if(rbmarried.isSelected()){
            marital= "Married";
        } else if (rbunmarried.isSelected()){
            marital= "Unmarried";
        }else if (rbother.isSelected()){
            marital= "Other";
        }        
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
        
        }catch (Exception e){
         e.printStackTrace();
        }   
        
        try{            
        Conn c = new Conn();
        
        String query = "INSERT INTO signup values( '"+title+"', '"+name+"', '"+lastname+"','"+dateb+"', '"+city+"', '"+pscode+"','"+address+"', '"+email+"', '"+district+"', '"+gender+"', '"+marital+"')";       
        c.s.executeUpdate(query);  
        
        setVisible(false);
        new SignupTwo(title).setVisible(true);     
        
        }catch (Exception e){
         e.printStackTrace();
        }
    
      }
    
    public static void main (String[]args){        
       new SignupOne(); 
    
    }
    
}

