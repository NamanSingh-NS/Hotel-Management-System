package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener
{
    JCheckBox checkBox,checkBox1;
    Choice choice;
    JTable table;
    JButton search,back;

    SearchRoom()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel heading = new JLabel("SEARCH FOR ROOM");
        heading .setBounds(300,11,300,31);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        //Room no
        JLabel roomno = new JLabel("Room Number");
        roomno .setBounds(23,142,150,20);
        roomno.setForeground(Color.WHITE);
        roomno.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(roomno);

        //Availability
        JLabel avail = new JLabel("Availablity");
        avail .setBounds(220,142,150,20);
        avail.setForeground(Color.WHITE);
        avail.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(avail);

        //Clean Status
        JLabel clean = new JLabel("Clean Status");
        clean .setBounds(380,142,150,20);
        clean.setForeground(Color.WHITE);
        clean.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(clean);

        //Price
        JLabel price = new JLabel("Price");
        price.setBounds(570,142,150,20);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(price);

        //BedType
        JLabel type = new JLabel("Bed Type");
        type.setBounds(720,142,150,20);
        type.setForeground(Color.WHITE);
        type.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(type);

        checkBox = new JCheckBox("Only Display Available");
        checkBox.setBounds(445,69,205,23);
        checkBox.setForeground(Color.WHITE);
        checkBox.setBackground(new Color(3,45,48));
        checkBox.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(checkBox);

        checkBox1 = new JCheckBox("Display All Rooms");
        checkBox1.setBounds(445,100,205,23);
        checkBox1.setForeground(Color.WHITE);
        checkBox1.setBackground(new Color(3,45,48));
        checkBox.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(checkBox1);

        JLabel rbd = new JLabel("Room Bed Type :");
        rbd.setBounds(95,73,130,25);
        rbd.setForeground(Color.WHITE);
        rbd.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(rbd);

        choice = new Choice();
        choice.add("Single Bed");
        choice.add("Double Bed");
        choice.add("Deluxe");
        choice.setBounds(225,73,120,20);
        choice.setBackground(new Color(3,45,48));
        choice.setForeground(Color.WHITE);
        choice.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,167,840,300);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(table);

        try
        {
            con c = new con();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        search = new JButton("SEARCH");
        search.setBounds(220,470,120,30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Tahoma",Font.BOLD,14));
        search.addActionListener(this);
        panel.add(search);

        back = new JButton("BACK");
        back.setBounds(420,470,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.addActionListener(this);
        panel.add(back);

        setUndecorated(true);
        setLayout(null);
        setLocation(500,150);
        setSize(850,550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search)
        {
            try {
                con c = new con();
                String q0 = "select * from room";
                String q00 = "select * from room where Availability = 'Available'";
                String q = "select * from room where Bed_Type = '" + choice.getSelectedItem() + "'";
                String q1 = "select * from room where Availability ='Available' And Bed_Type = '" + choice.getSelectedItem() + "'";
                ResultSet resultSet = c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
                if(checkBox.isSelected()){
                    ResultSet resultSet1 = c.statement.executeQuery(q1);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet1));
                    String searchItem = "All";
                    for(int i = 0; i < choice.getItemCount(); i++){
                        if(choice.getItem(i).equals(searchItem)){
                            choice.remove("All");
                        }
                    }
                }
                if(checkBox1.isSelected()){
                    ResultSet resultSet0 = c.statement.executeQuery(q0);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet0));
                    String searchItem = "All";
                    for(int i = 0; i < choice.getItemCount(); i++){
                        if(choice.getItem(i).equals(searchItem)){
                            choice.remove("All");
                        }
                    }
                    choice.add("All");
                    choice.select("All");
                }
                if(checkBox.isSelected() && checkBox1.isSelected()){
                    ResultSet resultSet00 = c.statement.executeQuery(q00);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet00));
                    String searchItem = "All";
                    for(int i = 0; i < choice.getItemCount(); i++){
                        if(choice.getItem(i).equals(searchItem)){
                            choice.remove("All");
                        }
                    }
                    choice.add("All");
                    choice.select("All");
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new SearchRoom();
    }
}
