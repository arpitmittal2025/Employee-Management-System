package employee.management.system;

import javax.swing.*;
import java.awt.*; // import for the colour
import java.awt.event.*; // for performing event of changing page from splash page to login page



public class Splash extends JFrame implements ActionListener{ // for performing action of shift window from splash page to login page , we wrote the actionListener method but we didnnot implemented it so we are implementing it in last lines around 74 line number
    Splash() {
        
        getContentPane().setBackground(Color.white); // by getContentPane function we can get full access of the frame 
        setLayout(null);  // we are saying we will not use layout made by swing we will made our own layout
        
         
        
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80,30,1200,60); //by this we can shift and maintain size of SSTRING 80 distance from left, 30 distance ffrom top,1200 lenggth of string, 60 is width of string
        heading.setFont(new Font("serif", Font.PLAIN, 60)); //we can change font type first argument representing font family(NAME Like "Arial","Times new Roman"), second arguement represents Font style (Font.PLAIN or Font.BOLD),3 rd argument epresting font size
        heading.setForeground(Color.RED); // change color of STRING
        
        
        
        
        add(heading); // di rectly by JLabel class it will not print for printing we have to add components 

        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg")); // It loads the image named front.jpg from the icons folder An ImageIcon is an object that Swing components like JLabel can display. front.jpg -> ImageIcon i1 
        Image i2 = i1.getImage().getScaledInstance(1100,700, Image.SCALE_DEFAULT); // Convert the ImageIcon to an Image and resize it to 1100x700 pixels 
        ImageIcon i3 = new ImageIcon(i2); // convert image into image icon //"i3 will be the converted image object of i2" (Convert the resized Image back into an ImageIcon because JLabel can display only ImageIcon)
        JLabel image = new JLabel(i3); // Create a JLabel and set the resized image as its content  
        image.setBounds(50,100,1050,500); // Set the position (x=50, y=100) and size (width=1050, height=500) of the image label
        add(image); // Add the image label to the JFrame so it becomes visible
        
        
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE"); // intializing button 
        clickhere.setBounds(400,400,300,70); // set button sizes
        clickhere.setBackground(Color.black); // set button Background Colour
        clickhere.setForeground(Color.white); // set button Foreground Colour
        clickhere.addActionListener(this); // Call actionPerformed() when the button is clicked
    
        image.add(clickhere);  // Display the button over the background image 
        
        


        setSize(1170,650);   //by setsize function we can mention size of the frame
        setVisible(true); //after using this line full frame will be visible
        setLocation(200,100); // the frame is alway opening from left top so we can change its location setLocation function 200 is distance from left and 100 is distance from top
    
        while(true) {   // Run this loop forever

    heading.setVisible(false); // Hide the heading

    try {
        Thread.sleep(500);     // Wait for 500 milliseconds (0.5 seconds)
    } catch (Exception e) {
        // Ignore any exception
    }

    heading.setVisible(true);  // Show the heading again

    try {
        Thread.sleep(500);     // Keep the heading visible for 0.5 seconds
    } catch (Exception e) {
        // Ignore any exception
    }
}
    
    
    
    }
    
    public void actionPerformed(ActionEvent ae){  // implementation of actionlistener method
        setVisible(false); // close current frame means it will close splash page
        new Login(); // object of new Login;    
    
    }
    
    
    
    
    
    public static void main(String args[]){ //this line is used for running of the Splash class
     new Splash();  //is a new object of the class
     
}
}
