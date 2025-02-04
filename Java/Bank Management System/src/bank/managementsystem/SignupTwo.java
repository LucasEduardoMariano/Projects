package bank.managementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class SignupTwo extends JFrame implements ActionListener{

    JTextField  nift, cardt;
    JButton next;
    JLabel religion, category, income, eduquali , occupation, nif, card, senior, existing, subtitle;
    JRadioButton rbyes, rbno, rbyes1, rbno1;
    JComboBox cbreligion, cbcategory, cbincome, cbeduquali, cboccupation;
    String title;
      
    SignupTwo(String title){
        
        this.title = title;
        setLayout(null);
        
        subtitle = new JLabel("Page 2: Personal Details");
        subtitle.setBounds(240, 50, 300, 30);
        subtitle.setForeground(Color.black);
        subtitle.setFont(new Font("serif", Font.BOLD, 20));
        add(subtitle);      
        
        religion = new JLabel("Religion");
        religion.setBounds(40, 123, 100, 30);
        religion.setForeground(Color.black);
        religion.setFont(new Font("serif", Font.BOLD, 17));
        add(religion);  
        
        String str1[] = {"Hindu","Muslim","Sikh","Christian","Other"};        
        cbreligion = new JComboBox(str1);
        cbreligion.setBounds(200, 130, 400, 20);
        cbreligion.setBackground(Color.white);
        add(cbreligion); 
        
        category = new JLabel("Category");
        category.setBounds(40, 163, 100, 30);
        category.setForeground(Color.black);
        category.setFont(new Font("serif", Font.BOLD, 17));
        add(category);  
        
        String str2[] = {"General","OBC","SC","ST","Other"};        
        cbcategory = new JComboBox(str2);
        cbcategory.setBounds(200, 170, 400, 20);
        cbcategory.setBackground(Color.white);
        add(cbcategory); 
        
        income = new JLabel("Income");
        income.setBounds(40, 203, 150, 30);
        income.setForeground(Color.black);
        income.setFont(new Font("serif", Font.BOLD, 17));
        add(income);  
        
        String str3[] = {"Null","<1000","<5000","<10000","Upto 15000","Above 20000"};        
        cbincome = new JComboBox(str3);
        cbincome.setBounds(200, 210, 400, 20);
        cbincome.setBackground(Color.white);
        add(cbincome); 
        
        eduquali = new JLabel("Educational");
        eduquali.setBounds(40, 243, 150, 30);
        eduquali.setForeground(Color.black);
        eduquali.setFont(new Font("serif", Font.BOLD, 17));
        add(eduquali);  
        
        String str4[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};        
        cbeduquali = new JComboBox(str4);
        cbeduquali.setBounds(200, 250, 400, 20);
        cbeduquali.setBackground(Color.white);
        add(cbeduquali); 
        
        occupation = new JLabel("Occupation");
        occupation.setBounds(40, 283, 100, 30);
        occupation.setForeground(Color.black);
        occupation.setFont(new Font("serif", Font.BOLD, 17));
        add(occupation);  
        
        String str5[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};        
        cboccupation = new JComboBox(str5);
        cboccupation.setBounds(200, 290, 400, 20);
        cboccupation.setBackground(Color.white);
        add(cboccupation); 
        
        nif = new JLabel("NIF");
        nif.setBounds(40, 323, 150, 30);
        nif.setForeground(Color.black);
        nif.setFont(new Font("serif", Font.BOLD, 17));
        add(nif);  
        
        nift = new JTextField();        
        nift.setBounds(200, 330, 400, 20);
        add(nift); 
        
        card = new JLabel("Cidadan Card");
        card.setBounds(40, 363, 150, 30);
        card.setForeground(Color.black);
        card.setFont(new Font("serif", Font.BOLD, 17));
        add(card);  
       
        cardt = new JTextField();        
        cardt.setBounds(200, 370, 400, 20);
        add(cardt); 
        
        senior = new JLabel("Senior Citizen");
        senior.setBounds(40, 400, 150, 30);
        senior.setForeground(Color.black);
        senior.setFont(new Font("serif", Font.BOLD, 17));
        add(senior);
        
        rbyes = new JRadioButton("Yes");
        rbyes.setBounds(200, 403, 100, 20);
        rbyes.setBackground(Color.white);
        rbyes.setFont(new Font("serif", Font.PLAIN, 14));
        add(rbyes);
        
        rbno = new JRadioButton("No");
        rbno.setBounds(300, 403, 100, 20);
        rbno.setBackground(Color.white);
        rbno.setFont(new Font("serif", Font.PLAIN, 14));
        add(rbno);
    
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbyes);
        bg.add(rbno);  
        
        existing = new JLabel("Existing Account");
        existing.setBounds(40, 440, 200, 30);
        existing.setForeground(Color.black);
        existing.setFont(new Font("serif", Font.BOLD, 17));
        add(existing);
        
        rbyes1 = new JRadioButton("Yes");
        rbyes1.setBounds(200, 443, 100, 20);
        rbyes1.setBackground(Color.white);
        rbyes1.setFont(new Font("serif", Font.PLAIN, 14));
        add(rbyes1);
        
        rbno1 = new JRadioButton("No");
        rbno1.setBounds(300, 443, 100, 20);
        rbno1.setBackground(Color.white);
        rbno1.setFont(new Font("serif", Font.PLAIN, 14));
        add(rbno1);
    
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(rbyes1);
        bg1.add(rbno1);
        
        next = new JButton("next");
        next.setBounds(550, 500, 75, 30);
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
        String religion = (String) cbreligion.getSelectedItem();
        String category = (String) cbcategory.getSelectedItem();
        String income = (String) cbincome.getSelectedItem();
        String eduquali = (String) cbeduquali.getSelectedItem();
        String occupation = (String) cboccupation.getSelectedItem();
        String card = cardt.getText();
        String nif = nift.getText();
        
        String senior = null;            
        if(rbyes.isSelected()){
            senior= "Yes";
        } else if (rbno.isSelected()){
            senior= "No";
        }    
        
        String existing = null;        
        if(rbyes1.isSelected()){
            existing= "Yes";
        } else if (rbno1.isSelected()){
            existing= "No";
        }   
        
        try{
            if(nif.equals("")){
                JOptionPane.showMessageDialog(null, "NIF is Required");
            }
        
        }catch (Exception e){
         e.printStackTrace();
        }       
        
        try{            
        Conn c = new Conn();

        String query = "INSERT INTO signuptwo values('"+religion+"', '"+category+"', '"+income+"','"+eduquali+"', '"+occupation+"', '"+nif+"','"+card+"', '"+senior+"', '"+existing+"', '"+title+"')";       
        
        c.s.executeUpdate(query);    
     
        //  religion varchar(15), category varchar(15), income varchar(25),eduquali varchar(30), occupation varchar(30), nif varchar(20), card varchar(30), senior varchar(10), existing varchar(10)
        
        setVisible(false);
        new SignupThree(title).setVisible(true);
        
        }catch (Exception e){
         e.printStackTrace();
        }
    
      }
    
    public static void main (String[]args){        
       new SignupTwo(""); 
    
    }
    
}
