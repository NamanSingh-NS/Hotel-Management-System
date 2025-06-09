package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUp extends JFrame {

    PickUp(){


        JPanel panel = new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        add(panel);

        JLabel pus = new JLabel("Pick Up Service");
        pus.setBounds(300,11,160,25);
        pus.setForeground(Color.WHITE);
        pus.setFont(new Font("Tahoma", Font.BOLD,20));
        panel.add(pus);

        JLabel toc = new JLabel("Car Type : ");
        toc.setBounds(100,67,89,20);
        toc.setForeground(Color.WHITE);
        toc.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(toc);

        Choice ch = new Choice();
        ch.setBounds(191,67,150,25);
        panel.add(ch);

//
        try
        {
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("Select * from driver");
            while(resultSet.next())
            {
                ch.add(resultSet.getString("Car_Name"));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        JTable table = new JTable();
        table.setBounds(5,160,840,250);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(table);

        try
        {
            con c = new con();
            String q = "select * from driver";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(35,135,46,20);
        name.setForeground(Color.WHITE);
        name.setBackground(new Color(3,45,48));
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(170,135,46,20);
        age.setForeground(Color.WHITE);
        age.setBackground(new Color(3,45,48));
        age.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(278,135,55,20);
        gender.setForeground(Color.WHITE);
        gender.setBackground(new Color(3,45,48));
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gender);

        JLabel company = new JLabel("Company");
        company.setBounds(385,135,75,20);
        company.setForeground(Color.WHITE);
        company.setBackground(new Color(3,45,48));
        company.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(company);

        JLabel carName = new JLabel("Car Name");
        carName.setBounds(500,135,90,20);
        carName.setForeground(Color.WHITE);
        carName.setBackground(new Color(3,45,48));
        carName.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(carName);

        JLabel avail = new JLabel("Availability");
        avail.setBounds(630,135,90,20);
        avail.setForeground(Color.WHITE);
        avail.setBackground(new Color(3,45,48));
        avail.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(avail);

        JLabel loc = new JLabel("Location");
        loc.setBounds(745,135,90,20);
        loc.setForeground(Color.WHITE);
        loc.setBackground(new Color(3,45,48));
        loc.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(loc);

        JButton display  = new JButton("Display");
        display.setBounds(200,500,120,30);
        display.setForeground(Color.WHITE);
        display.setBackground(Color.BLACK);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try
                {
                    con c = new con();
                    String q = "select * from driver where Car_Name = '"+ch.getSelectedItem()+"'";
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        panel.add(display);

        JButton back  = new JButton("Back");
        back.setBounds(420,500,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(back);

        setUndecorated(true);
        setLayout(null);
        setSize(850,550);
        setLocation(500,150);
        setVisible(true);

    }
    public static void main(String[] args) {
        new PickUp();
    }

}
