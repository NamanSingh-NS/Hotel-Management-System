package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame
{
    Department(){

        JPanel panel = new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(3,45,48));
        table.setBounds(10,120,400,350);
        table.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(table);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/Budget2.png"));
//        Image image = imageIcon.getImage().getScaledInstance(450,350,Image.SCALE_DEFAULT);
//        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(420,100,450,350);
        panel.add(label);


        try{
            con c = new con();
            String departmentInfo = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(departmentInfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBounds(165,475,100,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel head = new JLabel("BUDGET ALLOCATION");
        head.setBounds(100,30,400,20);
        head.setForeground(Color.WHITE);
        head.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(head);

        JLabel l1 = new JLabel("Department");
        l1.setBounds(50,90,105,20);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l1);

        JLabel l2 = new JLabel("Budget");
        l2.setBounds(280,90,105,20);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l2);

        setUndecorated(true);
        setLayout(null);
        setLocation(500,150);
        setSize(850,550);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Department();
    }
}
