package bank.managementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel l1, l2, image;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JTextField t1;
    String pinnumber;

    FastCash(String pinnumber) {
        
        this.pinnumber = pinnumber;       
         

        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("10");
        b2 = new JButton("50");
        b3 = new JButton("100");
        b4 = new JButton("200");
        b5 = new JButton("500");
        b6 = new JButton("1000");
        b7 = new JButton("BACK");

        setLayout(null);

        
        l1.setBounds(130, 230, 330, 25);
        add(l1);

        b1.setBounds(130, 320, 100, 25);
        add(b1);

        b2.setBounds(130, 350, 100, 25);
        add(b2);

        b3.setBounds(130, 380, 100, 25);
        add(b3);

        b4.setBounds(250, 320, 150, 25);
        add(b4);

        b5.setBounds(250, 350, 150, 25);
        add(b5);

        b6.setBounds(250, 380, 150, 25);
        add(b6);

        b7.setBounds(250, 410, 150, 25);
        add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0,700, 700);
        add(image); 

        setBounds(250, 20, 700, 700);
        //setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //k
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amout"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amout"));
                }
            } String num = "17";
            if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == b7) {
                this.setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }else{
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}

/*import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton fastcash, deposit, pinchange, cash, mini, balance, exit ;
    String pinnumber; 
    
    JLabel text;
    
    FastCash(String pinumber){
        
        setLayout(null);
        this.pinnumber = pinnumber;
        setTitle("ATM");
        
        text = new JLabel("Select withdraw, amount");
        text.setBounds(130, 230, 330, 25);
        text.setForeground(Color.white);
        text.setFont(new Font("serif", Font.BOLD, 15));
        add(text); 
                   
        deposit = new JButton("10");
        deposit.setBounds(130, 320, 100, 25);
        deposit.setForeground(Color.black);  
        deposit.setBackground(Color.white);
        deposit.setBorder(null);
        deposit.setFont(new Font("serif", Font.PLAIN, 20));
        deposit.addActionListener(this);
        add(deposit);         

        fastcash = new JButton("20");
        fastcash.setBounds(130, 350, 100, 25);
        fastcash.setForeground(Color.black);  
        fastcash.setBackground(Color.white);
        fastcash.setBorder(null);
        fastcash.setFont(new Font("serif", Font.PLAIN, 20));
        fastcash.addActionListener(this);
        add(fastcash); 
        
        pinchange = new JButton("30");
        pinchange.setBounds(130, 380, 100, 25);
        pinchange.setForeground(Color.black);  
        pinchange.setBackground(Color.white);
        pinchange.setBorder(null);
        pinchange.setFont(new Font("serif", Font.PLAIN, 20));
        pinchange.addActionListener(this);
        add(pinchange); 
        
        cash = new JButton("40");
        cash.setBounds(250, 320, 150, 25);
        cash.setForeground(Color.black);  
        cash.setBackground(Color.white);
        cash.setBorder(null);
        cash.setFont(new Font("serif", Font.PLAIN, 20));
        cash.addActionListener(this);
        add(cash); 
        
        mini = new JButton("50");
        mini.setBounds(250, 350, 150, 25);
        mini.setForeground(Color.black);  
        mini.setBackground(Color.white);;
        mini.setBorder(null);
        mini.setFont(new Font("serif", Font.PLAIN, 20));
        mini.addActionListener(this);
        add(mini); 
        
        balance = new JButton("60");
        balance.setBounds(250, 380, 150, 25);
        balance.setForeground(Color.black);  
        balance.setBackground(Color.white);
        balance.setBorder(null);
        balance.setFont(new Font("serif", Font.PLAIN, 20));
        balance.addActionListener(this);
        add(balance); 

        exit = new JButton("back");
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
            setVisible(false);
            new Transactions(pinnumber).setVisible(true); 
            
        }else{            
            String amount = ((JButton)ae.getSource()).getText().substring(2);
             Conn c = new Conn();
             
           try{
               ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
               int balance = 0;
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(rs.getString("amout"));
                   } else{
                       balance -= Integer.parseInt(rs.getString("amout"));
                   }
               }               
               if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                  JOptionPane.showMessageDialog(null, "Insufficient Balance ");
                  return;
               }
               
               Date date = new Date();
               String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Insufficient Balance ");
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);     
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }
        
    }
    
    public static void main (String[]args){        
       new FastCash(""); 
    
    }
    
}
*/