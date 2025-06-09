package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {

    JButton add_Employee,add_Room,add_Drivers,logout,back;
    Admin(){

        super("Hotel Management System - VISTARA");
        add_Employee = new JButton("ADD EMPLOYEE");
        add_Employee.setBounds(250,230,200,30);
        add_Employee.setBackground(Color.WHITE);
        add_Employee.setForeground(Color.BLACK);
        add_Employee.setFont(new Font("Tahoma",Font.BOLD,15));
        add_Employee.addActionListener(this);
        add(add_Employee);

        add_Room = new JButton("ADD ROOM");
        add_Room.setBounds(250,380,200,30);
        add_Room.setBackground(Color.WHITE);
        add_Room.setForeground(Color.BLACK);
        add_Room.setFont(new Font("Tahoma",Font.BOLD,15));
        add_Room.addActionListener(this);
        add(add_Room);

        add_Drivers = new JButton("ADD DRIVER");
        add_Drivers.setBounds(250,530,200,30);
        add_Drivers.setBackground(Color.WHITE);
        add_Drivers.setForeground(Color.BLACK);
        add_Drivers.setFont(new Font("Tahoma",Font.BOLD,15));
        add_Drivers.addActionListener(this);
        add(add_Drivers);

        logout = new JButton("Log Out");
        logout.setBounds(10,800,95,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma",Font.BOLD,15));
        logout.addActionListener(this);
        add(logout);

        back = new JButton("Back");
        back.setBounds(110,800,95,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,15));
        back.addActionListener(this);
        add(back);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Icons/employees.png"));
        Image i1 = image.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon employee = new ImageIcon(i1);
        JLabel label = new JLabel(employee);
        label.setBounds(70,180,120,120);
        add(label);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icons/room.png"));
        Image i2 = image1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon room = new ImageIcon(i2);
        JLabel label1 = new JLabel(room);
        label1.setBounds(70,340,120,120);
        add(label1);

        ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("Icons/driver.png"));
        Image i3 = image2.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon driver = new ImageIcon(i3);
        JLabel label2 = new JLabel(driver);
        label2.setBounds(70,500,120,120);
        add(label2);

        ImageIcon image3 = new ImageIcon(ClassLoader.getSystemResource("Icons/Vistara.gif"));
        Image i4 = image3.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon logo = new ImageIcon(i4);
        JLabel label3 = new JLabel(logo);
        label3.setBounds(1000,180,400,400);
        add(label3);



        getContentPane().setBackground(new Color(3,45,48));
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add_Employee)
        {
            new AddEmployee();
        }
        else if (e.getSource()==add_Room)
        {
            new AddRoom();
        }
        else if(e.getSource()==add_Drivers)
        {
            new AddDriver();
        }
        else if (e.getSource()==logout)
        {
            System.exit(7);
        }
        else if (e.getSource()==back)
        {
            new Dashboard();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
