package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame implements ActionListener
{
    JTable table;
    JButton back;
    Room(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Icons/roomm.png"));
        Image i = image.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon fimage = new ImageIcon(i);
        JLabel roomImage = new JLabel(fimage);
        roomImage.setBounds(580,200,200,200);
        panel.add(roomImage);

        table = new JTable();
        table.setBounds(10,100,500,350);
        table.setBackground(new Color(3,45,48));
        table.setFont(new Font("Tahoma",Font.PLAIN,14));
        table.setForeground(Color.white);
        panel.add(table);

        try
        {
            con c = new con();
            String RoomInfo = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(RoomInfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));//print table on panel
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(200,500,120,30);
        back.addActionListener(this);
        panel.add(back);

        //Titles of table
        JLabel head = new JLabel("ROOM DETAILS");
        head.setBounds(180,20,180,19);
        head.setBackground(new Color(3,45,48));
        head.setFont(new Font("Tahoma",Font.BOLD,20));
        head.setForeground(Color.white);
        panel.add(head);

        JLabel no = new JLabel("Room No.");
        no.setBounds(12,75,80,19);
        no.setBackground(new Color(3,45,48));
        no.setFont(new Font("Tahoma",Font.BOLD,14));
        no.setForeground(Color.white);
        panel.add(no);

        JLabel avail = new JLabel("Availability");
        avail.setBounds(119,75,80,19);
        avail.setBackground(new Color(3,45,48));
        avail.setFont(new Font("Tahoma",Font.BOLD,14));
        avail.setForeground(Color.white);
        panel.add(avail);

        JLabel cs = new JLabel("Clean Status");
        cs.setBounds(216,75,150,19);
        cs.setBackground(new Color(3,45,48));
        cs.setFont(new Font("Tahoma",Font.BOLD,14));
        cs.setForeground(Color.white);
        panel.add(cs);

        JLabel price = new JLabel("Price");
        price.setBounds(330,75,80,19);
        price.setBackground(new Color(3,45,48));
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        price.setForeground(Color.white);
        panel.add(price);

        JLabel type = new JLabel("Bed Type");
        type.setBounds(417,75,80,19);
        type.setBackground(new Color(3,45,48));
        type.setFont(new Font("Tahoma",Font.BOLD,14));
        type.setForeground(Color.white);
        panel.add(type);

        setUndecorated(true);
        setLayout(null);
        setLocation(500,150);
        setSize(850,550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Room();
    }
}
