package to.pkgdo.list;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TaskComponent extends JPanel implements ActionListener {
    
    private JCheckBox checkBox;
    private JTextPane taskField;
    private JButton deleteButton;   
    
    public JTextPane getTaskField(){
        return taskField;
    }
    
    private JPanel parentPanel;
    
    public TaskComponent(JPanel parentPanel){
        this.parentPanel = parentPanel;
        
        taskField = new JTextPane();
        taskField.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        taskField.setPreferredSize(CommonContants.TASKFIELD_SIZE);
        taskField.setContentType("text/html");        
        taskField.addFocusListener(new FocusListener() {
            // indicate which task field is currently being edited
            @Override
            public void focusGained(FocusEvent e) {
                taskField.setBackground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                taskField.setBackground(null);
            }
        });
        
        checkBox = new JCheckBox();
        checkBox.setPreferredSize(CommonContants.CHECKBOX_SIZE);
        checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        checkBox.addActionListener(this);
        
        deleteButton = new JButton("X");
        deleteButton.setPreferredSize(CommonContants.DELETE_BUTTON_SIZE);
        deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
        deleteButton.addActionListener(this);
        
        add(checkBox);
        add(taskField);        
        add(deleteButton);
    }
    
    @Override
        public void actionPerformed(ActionEvent e){   
            
            if(checkBox.isSelected()){
            // replaces all html tags to empty string to grab the main text
            String taskText = taskField.getText().replaceAll("<[^>]*>", "");

            // add strikethrough text
            taskField.setText("<html><s>"+ taskText + "</s></html>");
        }else if(!checkBox.isSelected()){
            String taskText = taskField.getText().replaceAll("<[^>]*>", "");

            taskField.setText(taskText);
        }
            
            if(e.getActionCommand().equalsIgnoreCase("X")){
                parentPanel.remove(this);
                parentPanel.repaint();
                parentPanel.revalidate();
            
            }  
        }    
}
