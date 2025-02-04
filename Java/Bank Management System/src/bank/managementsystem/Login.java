package bank.managementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField cardnumbert;
    JPasswordField pint;
    JButton clear, signin, signup;
    JLabel pinl, cardnumber, title;
    
    Login(){
        
        
    getContentPane().setBackground(Color.white);        
        setLayout(null); //Com esse método, atribui-se um gerenciador de layout ao container, pra que se possa controlar a posição dos componentes nele adicionados. Passar null é o mesmo que nao atribuir nenhum gerenciador.
             
        title = new JLabel("WELCOME TO ATM");
        title.setBounds(200, 50, 300, 40);
        title.setForeground(Color.black);
        title.setFont(new Font("serif", Font.BOLD, 30));
        add(title);
        
        cardnumber = new JLabel("CARD N°");
        cardnumber.setBounds(200, 150, 100, 30);
        cardnumber.setForeground(Color.black);
        cardnumber.setFont(new Font("serif", Font.BOLD, 20));
        add(cardnumber);  
        
        cardnumbert = new JTextField();        
        cardnumbert.setBounds(300, 150, 200, 30);
        add(cardnumbert);  
        
        pinl = new JLabel("PIN");
        pinl.setBounds(200, 200, 100, 30);
        pinl.setForeground(Color.black);
        pinl.setFont(new Font("serif", Font.BOLD, 20));
        add(pinl); 
        
        pint = new JPasswordField();        
        pint.setBounds(300, 200, 200, 30);
        add(pint);
        
        clear = new JButton("Clear");
        clear.setBounds(400, 280, 100, 30);
        clear.setForeground(Color.white);  
        clear.setBackground(Color.black);
        clear.setBorder(null);
        clear.setFont(new Font("serif", Font.PLAIN, 20));
        clear.addActionListener(this);
        add(clear); 
        
        signin = new JButton("Sign in");
        signin.setBounds(200, 280, 100, 30);
        signin.setForeground(Color.white);  
        signin.setBackground(Color.black);
        signin.setBorder(null);
        signin.setFont(new Font("serif", Font.PLAIN, 20));
        signin.addActionListener(this);
        add(signin); 
        
        signup = new JButton("Sign up");
        signup.setBounds(200, 320, 300, 30);
        signup.setForeground(Color.white);  
        signup.setBackground(Color.black);
        signup.setBorder(null);
        signup.setFont(new Font("serif", Font.PLAIN, 20));
        signup.addActionListener(this);
        add(signup); 
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(120, 20,80, 80);
        add(image);      
        
        setBounds(250, 100,700, 500);
        //setSize(1366,565); // tamanho da tela 
        setVisible(true);// tela visivel or not
        //setLocation(2,100);// onde a tela vai aparecer 
    }
    
      public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
           cardnumbert.setText("");
           pint.setText("");
        }else if(ae.getSource()== signin){
            Conn c = new Conn();
            String cardnumber = cardnumbert.getText();
            String pinumber = pint.getText();
            String query = "Select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinumber+"'";       
        
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }

            }catch (Exception e){
                e.printStackTrace();
            }       
        
        }else if(ae.getSource()== signup){
            setVisible(false);
            new SignupOne(); 
        }
         
    
    }
    
    public static void main (String[] args) { // essa classe por ser a principal só vai chamar a anterior a public class HotelManagementSystem extends JFrame
        new Login();
    }  
    
}
