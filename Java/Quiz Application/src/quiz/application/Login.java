package quiz.application; //onde esta

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    
    JButton rules, back;
    JTextField tfname;
    
    
    Login(){       

        getContentPane().setBackground(new Color(133, 17, 180)); // fundo da tela
        setLayout(null); //Com esse método, atribui-se um gerenciador de layout ao container, pra que se possa controlar a posição dos componentes nele adicionados. Passar null é o mesmo que nao atribuir nenhum gerenciador.
                
        /*ImageIcon il = new ImageIcon (ClassLoader.getSystemResource("icons/Login.png"));
        JLabel image = new JLabel(il);
        image.setBounds(0, 0, 600, 500); //o setBounds é uma forma de definir a posição e o tamanho ao mesmo tempo, enquanto que o setSize define apenas o tamanho e o setLocation apenas a posição
        add(image);*/
        
        /*ImageIcon i2 = new ImageIcon (ClassLoader.getSystemResource("icons/flynandrapunzel.png"));
        JLabel image2 = new JLabel(i2);
        image2.setBounds(950, -30, 280, 780); //o setBounds é uma forma de definir a posição e o tamanho ao mesmo tempo, enquanto que o setSize define apenas o tamanho e o setLocation apenas a posição
        add(image2);
        
        ImageIcon i3 = new ImageIcon (ClassLoader.getSystemResource("icons/pascoal.png"));
        JLabel image3 = new JLabel(i3);
        image3.setBounds(738,250,120,90); //o setBounds é uma forma de definir a posição e o tamanho ao mesmo tempo, enquanto que o setSize define apenas o tamanho e o setLocation apenas a posição
        add(image3);*/
        
        /*JLabel heading = new JLabel("QUIZ TIME !");// aqui define o que vai escrito no começo
        heading.setBounds(750, 60, 300, 45);//o setBounds é uma forma de definir a posição e o tamanho ao mesmo tempo, enquanto que o setSize define apenas o tamanho e o setLocation apenas a posição
        heading.setFont( new Font("Princess Sofia", Font.BOLD, 40));  // tipo da fonte      
        heading.setForeground(new Color(251, 206, 36));// cor da fonte
        add(heading);*/
        
        /*JLabel name = new JLabel("What is your name?");// aqui define o que vai escrito no começo
        name.setBounds(735, 170, 300, 20);//o setBounds é uma forma de definir a posição e o tamanho ao mesmo tempo, enquanto que o setSize define apenas o tamanho e o setLocation apenas a posição
        name.setFont( new Font("Mongolian Baiti", Font.BOLD, 20));  // tipo da fonte      
        name.setForeground(new Color(197, 152, 46));// cor da fonte
        add(name);*/
        
        tfname = new JTextField(); //JTextField é para criar um box para escrever nome etc
        tfname.setBounds(350,349,440,25);
        tfname.setFont( new Font("Times New Roman", Font.BOLD, 20));  // tipo da fonte  
        tfname.setBackground(Color.white);   
        tfname.setBorder(null);
        add(tfname);
        
        rules = new JButton("Start"); //JButton cria button. Essa linha assim por exemplo JButton rules = new JButton(); é paraacho que definiar uma classe ou variavel
        rules.setBounds(434, 410, 70, 16);
        rules.setBorder(null);
        rules.setBackground(new Color(152, 203, 219));
        rules.setForeground(Color.white);// cor da fonte
        rules.addActionListener(this);
        add(rules);
        
        back = new JButton("Back"); //JButton cria button. Essa linha assim por exemplo JButton rules = new JButton(); é paraacho que definiar uma classe ou variavel
        back.setBounds(616, 410, 70, 16);
        back.setBorder(null);
        back.setBackground (new Color(152, 203, 219));
        back.setForeground(Color.white);// cor da fonte
        back.addActionListener(this);
        add(back);    
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/quiz2.png"));
        JLabel image = new JLabel(i1);
        image.setSize(1200,500);
        //image.setBounds(0, 0, 600, 500); //o setBounds é uma forma de definir a posição e o tamanho ao mesmo tempo, enquanto que o setSize define apenas o tamanho e o setLocation apenas a posição
        add(image);
        
        setSize(1200,500); // tamanho da tela ou quadro largura e altura
        setLocation(100,150); // onde a tela ou quadro tem que abrir
        setVisible(true); // basicamente o setVisible é para uma tela ficar visivel
        

    
    }
    
    public void actionPerformed(ActionEvent ae){ // Resumindo o que aconteceu aqui: Basicamente foi preciso cirar um if e um else if para se caso clique no rules aparece algo na tela e caso clique no back a tela fecha
        if(ae.getSource() == rules){
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        
        } else if (ae.getSource() == back){
            setVisible(false); // setVisible(false) para tela fechar no caso se clicar no back mas o comando é para não exibir nada pois esta false
        
        }
    
    }    
    
    public static void main (String[] args){ //metodo para iniciar um programa em java é main
      
      new Login(); 
        
    }
    
}
