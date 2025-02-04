package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {
    
    String name;
    JButton start, back;
    
    Rules(String name){
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome " + name + " to Quiz");// aqui define o que vai escrito no começo
        heading.setBounds(160, -120, 900, 400);//o setBounds é uma forma de definir a posição e o tamanho ao mesmo tempo, enquanto que o setSize define apenas o tamanho e o setLocation apenas a posição
        heading.setFont( new Font("Sunserif", Font.BOLD, 40));  // tipo da fonte      
        heading.setForeground(Color.white);// cor da fonte
        add(heading);
        
        JLabel rules = new JLabel("");// aqui define o que vai escrito no começo
        rules.setBounds(30, 140, 700, 350);//o setBounds é uma forma de definir a posição e o tamanho ao mesmo tempo, enquanto que o setSize define apenas o tamanho e o setLocation apenas a posição
        rules.setFont( new Font("Poppins", Font.BOLD, 20));  // tipo da fonte  
        rules.setForeground(Color.white);
        rules.setText(
        "<html>" +
            "1. No Mobile Phones;" + "<br><br>" +
            "2. Focus;" + "<br><br>" +
            "3. Keep Your Voices Down;" + "<br><br>" +
            "4. Keep Calm and Carry On;" + "<br><br>" +
        "<html>"
        );
        
        add(rules);        
      
        back = new JButton("Back"); //JButton cria button. Essa linha assim por exemplo JButton rules = new JButton(); é paraacho que definiar uma classe ou variavel
        back.setBounds(264,494,70,16);
        back.setBorder(null);
        back.setBackground (new Color(152, 203, 219));
        back.setForeground(Color.white);// cor da fonte
        back.addActionListener(this);
        add(back);  
        
        start = new JButton("Start"); //JButton cria button. Essa linha assim por exemplo JButton rules = new JButton(); é paraacho que definiar uma classe ou variavel
        start.setBounds(445,494,70,16);
        start.setBorder(null);
        start.setBackground(new Color(152, 203, 219));
        start.setForeground(Color.white);// cor da fonte
        start.addActionListener(this);
        add(start);
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/avalo.png"));
        JLabel image = new JLabel(i1);
        image.setSize(800, 650);
        add(image);
                
        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){ // Resumindo o que aconteceu aqui: Basicamente foi preciso cirar um if e um else if para se caso clique no rules aparece algo na tela e caso clique no back a tela fecha
        if(ae.getSource() == start){
            setVisible(false);
            new Quiz(name);
                    
        } else{
            setVisible(false); // setVisible(false) para tela fechar no caso se clicar no back mas o comando é para não exibir nada pois esta false
            new Login();
        }
    
    }
    
    public static void main (String[] args){
        new Rules("User");
    }
}
