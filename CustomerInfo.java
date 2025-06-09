package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.management.relation.RelationSupport;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame
{
    CustomerInfo()
    {
        JPanel panel = new JPanel();
//        panel.setBounds(5,5,890,590);
        panel.setBounds(5,5,990,670);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel heading = new JLabel("CUSTOMER INFORMATION");
        heading.setBounds(375,11,300,31);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        JTable table = new JTable();
        table.setBounds(10,100,990,380);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);



        try{
            con c = new con();
            String q = "select * from customer";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception ex){
            ex.printStackTrace();
        }

        //ID
        JLabel id = new JLabel("ID");
        id.setBounds(45,71,46,14);
        id.setForeground(Color.WHITE);
        id.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(id);

        //number
        JLabel id_no = new JLabel("ID Number");
        id_no.setBounds(150,71,100,14);
        id_no.setForeground(Color.WHITE);
        id_no.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(id_no);

        //name
        JLabel name = new JLabel("Name");
        name.setBounds(300,71,100,14);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);

        //Gender
        JLabel gender = new JLabel("Gender");
        gender.setBounds(415,71,100,14);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gender);

        //Country
        JLabel country = new JLabel("Country");
        country.setBounds(535,71,100,20);
        country.setForeground(Color.WHITE);
        country.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(country);

        //Room
        JLabel room = new JLabel("Room");
        room.setBounds(675,71,100,14);
        room.setForeground(Color.WHITE);
        room.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(room);

        //Time
        JLabel time = new JLabel("Time");
        time.setBounds(790,71,100,14);
        time.setForeground(Color.WHITE);
        time.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(time);

        //Deposit
        JLabel dep = new JLabel("Deposit");
        dep.setBounds(910,71,100,20);
        dep.setForeground(Color.WHITE);
        dep.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(dep);

        JButton back = new JButton("BACK");
        back.setBounds(450,580,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(back);

        setUndecorated(true);
        setLayout(null);
        setLocation(430,100);
        setSize(1000,680);
//        setLocation(500,100);
//        setSize(900,600);
        setVisible(true);
    }
    public static void main(String[] args) {
        new CustomerInfo();
    }
}
