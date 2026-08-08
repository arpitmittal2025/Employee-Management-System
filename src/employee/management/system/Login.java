package employee.management.system;


import javax.swing.*;
import java.awt.*; // this package  is for colour
import java.awt.event.*; // this package is for
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JTextField tfusername,tfpassword;
    
    
Login(){
    
    getContentPane().setBackground(Color.white); // changing the background colour
    setLayout(null);
    
    
    JLabel lblusername = new JLabel("Username");
    lblusername.setBounds(40,20,100,30);
    add(lblusername);
    
    tfusername = new JTextField(); // for makin box in the side of password we use 150 because 40 distance is from left of password string and 100 is length of the string so  we add 10  extra in it so it became 40+100+10 = 150 means box we print after 150 distance from left
    tfusername.setBounds(150,20,150,30);
    add(tfusername);
    
    
    JLabel lblpassword = new JLabel("Password");
    lblpassword.setBounds(40,70,100,30);
    add(lblpassword);

    tfpassword = new JTextField(); // for makin box in the side of password we use 150 because 40 distance is from left of password string and 100 is length of the string so  we add 10  extra in it so it became 40+100+10 = 150 means box we print after 150 distance from left
    tfpassword.setBounds(150,70,150,30);
    add(tfpassword);
    
    
    
    JButton login = new JButton("Login"); // intializing button 
        login.setBounds(150,140,150,30); // set button sizes we want login button just below of password box so we use exact 150 distance from left  and we took 70+70=140 distance from top and length and width is 150,30 same as password box
        login.setBackground(Color.black); // set button Background Colour
        login.setForeground(Color.white); // set button Foreground Colour
        login.addActionListener(this);
        
        add(login);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg")); // It loads the image named second.jpg from the icons folder An ImageIcon is an object that Swing components like JLabel can display. (second.jpg -> ImageIcon i1)
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT); // Convert the ImageIcon to an Image and resize it to 200x200 pixels 
        ImageIcon i3 = new ImageIcon(i2); // convert image into image icon //"i3 will be the converted image object of i2" (Convert the resized Image back into an ImageIcon because JLabel can display only ImageIcon)
        JLabel image = new JLabel(i3); // Create a JLabel and set the resized image as its content  
        image.setBounds(350,0,200,200); // Set the position (x=350, y=0) and size (width=200, height=200) of the image label
        add(image); // Add the image label to the JFrame so it becomes visible
        
        
        
    
    
    
    setSize(600,300); // size of the login page
    setLocation(450,200); // set location from left an top
    setVisible(true); // by this command our login page will be visible
    
}


public void actionPerformed(ActionEvent ae ){
    try{
        String username = tfusername.getText(); // get text function text field mai kya value vo aapko nikal ke deta hai
        String password = tfpassword.getText();
        
        Conn c = new Conn();
        String query = "select * from login where username = '" + username + "'  and password = '" + password + "'"; // here CREATION OF QUERY .
        
        ResultSet rs = c.s.executeQuery(query); // Here EXECUTING THE QUERY
        if(rs.next()){
            setVisible(false);
            new Home();// next class
        } else{
            JOptionPane.showMessageDialog(null, "Invalid usernmae or password");
            setVisible(false);
        }
    
    
    } catch (Exception e){
        e.printStackTrace();
    }
}

public static void main(String[] args){
    new Login();
}}