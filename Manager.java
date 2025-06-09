package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Manager extends JFrame
{
    Manager(){
        JPanel panel =new JPanel();
        panel.setBounds(5,5,990,670);
//        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,100,980,450);
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(3,45,48));
        panel.add(table);

        JLabel head = new JLabel("MANAGER'S  INFORMATION");
        head.setBounds(340,20,380,19);
        head.setBackground(new Color(3,45,48));
        head.setFont(new Font("Tahoma",Font.BOLD,20));
        head.setForeground(Color.white);
        panel.add(head);

        try{
            con c = new con();
            String ManagerInfo = "select * from employee where job = 'Manager'";
            ResultSet resultSet = c.statement.executeQuery(ManagerInfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception ex){
            ex.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBounds(400,566,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel name = new JLabel("Name");
        name.setBounds(41,72,70,19);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setForeground(Color.WHITE);
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(159,72,70,19);
        age.setFont(new Font("Tahoma",Font.BOLD,14));
        age.setForeground(Color.WHITE);
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(273,72,70,19);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        JLabel job = new JLabel("Job");
        job.setBounds(416,72,70,19);
        job.setFont(new Font("Tahoma",Font.BOLD,14));
        job.setForeground(Color.WHITE);
        panel.add(job);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(536,72,70,19);
        salary.setFont(new Font("Tahoma",Font.BOLD,14));
        salary.setForeground(Color.WHITE);
        panel.add(salary);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(656,72,70,19);
        phone.setFont(new Font("Tahoma",Font.BOLD,14));
        phone.setForeground(Color.WHITE);
        panel.add(phone);

        JLabel email = new JLabel("Email");
        email.setBounds(786,72,70,19);
        email.setFont(new Font("Tahoma",Font.BOLD,14));
        email.setForeground(Color.WHITE);
        panel.add(email);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(896,72,70,19);
        aadhar.setFont(new Font("Tahoma",Font.BOLD,14));
        aadhar.setForeground(Color.WHITE);
        panel.add(aadhar);

        setUndecorated(true);
        setLayout(null);
        setLocation(430,100);
        setSize(1000,680);
//        setLocation(430,100);
//        setSize(1000,600);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new Manager();
    }
}
