package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    
    JButton view, add, update, remove;
    Home() {
        
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg")); // It loads the image named home.jpg from the icons folder An ImageIcon is an object that Swing components like JLabel can display. home.jpg -> ImageIcon i1 
        Image i2 = i1.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT); // Convert the ImageIcon to an Image and resize it to 1100x700 pixels 
        ImageIcon i3 = new ImageIcon(i2); // convert image into image icon //"i3 will be the converted image object of i2" (Convert the resized Image back into an ImageIcon because JLabel can display only ImageIcon)
        JLabel image = new JLabel(i3); // Create a JLabel and set the resized image as its content  
        image.setBounds(0,0,1120,630); // Set the position (x=0, y=0) and size (width=1120, height=630) of the image label
        add(image); // Add the image label to the JFrame so it becomes visible

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(620,20,400,40);
        heading.setFont(new Font("Raieway", Font.BOLD, 25));
        image.add(heading);
        
        add = new JButton("ADD EMPLOYEE");
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("VIEW EMPLOYEES");
        view.setBounds(820,80,150,40);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("UPDATE EMPLOYEE");
        update.setBounds(650,140,150,40);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("REMOVE EMPLOYEE");
        remove.setBounds(820 ,140,150,40);
        remove.addActionListener(this);
        image.add(remove);
        
        
        
        setSize(1120, 630);
         setLocation(250, 100);
         setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view){
            setVisible(false);
            new ViewEmployee();
        } else if(ae.getSource() == update){
            setVisible(false);
            new ViewEmployee();
        }else {
            setVisible(false);
            new RemoveEmployee();
        }
    }
    
    public static void main(String[] args){
        new Home();
    }
}
