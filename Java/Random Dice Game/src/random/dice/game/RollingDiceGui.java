package random.dice.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RollingDiceGui extends JFrame {
    
    public RollingDiceGui(){
        super("Rolling Double Dice");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700,700));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        
        addGuiComponents();
    }
    
    private void addGuiComponents(){
    
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        
        JLabel bannerImg = ImgService.loadImage("resources/banner.png");
        bannerImg.setBounds(45, 25, 600, 100);
        jPanel.add(bannerImg);
        
        JLabel diceOneImg = ImgService.loadImage("resources/dice1.png");
        diceOneImg.setBounds(100, 200, 200, 200);
        jPanel.add(diceOneImg);
        
        JLabel diceTwoImg = ImgService.loadImage("resources/dice2.png");
        diceTwoImg.setBounds(390, 200, 200, 200);
        jPanel.add(diceTwoImg);
        
       // this.getContentPane().add(jPanel);
        
        Random rand = new Random();
        JButton rollButton = new JButton("Roll!");
        rollButton.setBounds(250,550,200,50);
        rollButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
             rollButton.setEnabled(false);
             
             long startTime = System.currentTimeMillis();
             Thread rollThread = new Thread(new Runnable(){
                
                 @Override                  
                  public void run(){
                      long endTime = System.currentTimeMillis();
                      try{
                          while((endTime - startTime)/100F < 3){
                            int diceOne = rand.nextInt(1,7);
                            int diceTwo = rand.nextInt(1,7);
                            
                            ImgService.updateImage(diceOneImg,"resources/dice" + diceOne + ".png");
                            ImgService.updateImage(diceTwoImg,"resources/dice" + diceTwo + ".png");
                            
                            repaint();
                            revalidate();
                            
                            Thread.sleep(60);
                            
                            endTime  = System.currentTimeMillis();
                          
                          }
                          
                          rollButton.setEnabled(true);
                      }catch(InterruptedException e){
                          System.out.println("Thereading Error: " + e);
                      }
                  }
             });
             rollThread.start();
            }
        
        });
        
        jPanel.add(rollButton);
        this.getContentPane().add(jPanel);

    
    }
    
}
