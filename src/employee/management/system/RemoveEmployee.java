package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    
    Choice cEmpId;
    JButton delete , back;
    
    RemoveEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50,50,100,30);
        add(labelempId);
        
        cEmpId = new Choice();
        cEmpId.setBounds(200,50,150,30);
        add(cEmpId);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("name");
        labelname.setBounds(50,100,100,30);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200,100,100,30);
        add(lblname);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50,150,100,30);
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200,150,100,30);
        add(lblphone);
        
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,200,100,30);
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200,200,100,30);
        add(lblemail);
        
        
        
         try{
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
         
         cEmpId.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie) {
            try{
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        }
    });
         delete  = new JButton("Delete"); 
         delete.setBounds(80,300,100,30);
         delete.setBackground(Color.BLACK);
         delete.setForeground(Color.WHITE);
         delete.addActionListener(this);
         add(delete);
        
         back  = new JButton("Back"); 
         back.setBounds(220,300,100,30);
         back.setBackground(Color.BLACK);
         back.setForeground(Color.WHITE);
         back.addActionListener(this);
         add(back);
        
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png")); // It loads the image named front.jpg from the icons folder An ImageIcon is an object that Swing components like JLabel can display. front.jpg -> ImageIcon i1 
        Image i2 = i1.getImage().getScaledInstance(600,400, Image.SCALE_DEFAULT); // Convert the ImageIcon to an Image and resize it to 600x400 pixels 
        ImageIcon i3 = new ImageIcon(i2); // convert image into image icon //"i3 will be the converted image object of i2" (Convert the resized Image back into an ImageIcon because JLabel can display only ImageIcon)
        JLabel image = new JLabel(i3); // Create a JLabel and set the resized image as its content  
        image.setBounds(350,0,600,400); // Set the position (x=350, y=0) and size (width=600, height=400) of the image label
        add(image);
        
        
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == delete){
            try{
                Conn c = new Conn();
                String query = "delete from employee where empId = '"+cEmpId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Successfully");
                setVisible(false);
                new Home();
            } catch (Exception e)
                
            {
                e.printStackTrace();
            }} else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args){
        new RemoveEmployee();
    }
    
}
