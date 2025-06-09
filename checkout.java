package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class checkout extends JFrame {
    JLabel labelcheckouttime;
    checkout()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/checkout.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel pic = new JLabel(imageIcon1);
        pic.setBounds(450,80,300,300);
        panel.add(pic);

        JLabel label = new JLabel("CHECK-OUT");
        label.setBounds(150,20,150,30);
        label.setForeground(Color.WHITE);
        label.setBackground(new Color(3,45,48));
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label);

        JLabel id = new JLabel("Customer ID : ");
        id.setBounds(30,80,150,30);
        id.setForeground(Color.WHITE);
        id.setBackground(new Color(3,45,48));
        id.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(id);

        Choice customer = new Choice();
        customer.setBounds(200,80,150,25);
        panel.add(customer);

        JLabel roomNum = new JLabel("Room Number : ");
        roomNum.setBounds(30,130,150,30);
        roomNum.setForeground(Color.WHITE);
        roomNum.setBackground(new Color(3,45,48));
        roomNum.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(roomNum);

        JLabel labelRoomNumber = new JLabel();
        labelRoomNumber.setBounds(200,130,150,30);
        labelRoomNumber.setForeground(Color.WHITE);
        labelRoomNumber.setBackground(new Color(3,45,48));
        labelRoomNumber.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(labelRoomNumber);

        JLabel checkintime = new JLabel("Check-In Time : ");
        checkintime.setBounds(30,180,150,30);
        checkintime.setForeground(Color.WHITE);
        checkintime.setBackground(new Color(3,45,48));
        checkintime.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(checkintime);

        JLabel labelcheckintime = new JLabel();
        labelcheckintime.setBounds(200,180,250,30);
        labelcheckintime.setForeground(Color.WHITE);
        labelcheckintime.setBackground(new Color(3,45,48));
        labelcheckintime.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(labelcheckintime);

        JLabel checkouttime = new JLabel("Check-Out Time : ");
        checkouttime.setBounds(30,230,150,30);
        checkouttime.setForeground(Color.WHITE);
        checkouttime.setBackground(new Color(3,45,48));
        checkouttime.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(checkouttime);

        Date date = new Date();

        labelcheckouttime = new JLabel(""+date);
        labelcheckouttime.setBounds(200,230,250,30);
        labelcheckouttime.setForeground(Color.WHITE);
        labelcheckouttime.setBackground(new Color(3,45,48));
        labelcheckouttime.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(labelcheckouttime);



        try
        {
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("select * from customer");
            while(resultSet.next())
            {
                customer.add(resultSet.getString("Number"));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        JButton checkOut = new JButton("Check-Out");
        checkOut.setBounds(30,300,120,30);
        checkOut.setBackground(Color.BLACK);
        checkOut.setForeground(Color.WHITE);
        panel.add(checkOut);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    con c = new con();
                    String p="";
                        String Checkout = labelcheckouttime.getText();
                        String price = "Select Price from room where Room_Number = '"+labelRoomNumber.getText()+"'";
                        ResultSet r = c.statement.executeQuery(price);
                        if(r.next()){
                            p = r.getString("Price");
                        }
                        c.statement.executeUpdate("insert into OldCustomer(Document,Number,Name,Gender,Country,Room_No,Check_In_Time,Deposit_Amount) select Document,Number,Name,Gender,Country,Room_No,Check_In_Time,Deposit_Amount from customer where Number = '" + customer.getSelectedItem() + "'");
                        c.statement.executeUpdate("Update OldCustomer set Check_Out_Time = '" + Checkout + "' where Number = '" + customer.getSelectedItem() + "'");
                        c.statement.executeUpdate("Update OldCustomer set Total_Amount = '" + p + "' where Number = '" + customer.getSelectedItem() + "'");
                        c.statement.executeUpdate("delete from customer where Number = '" + customer.getSelectedItem() + "'");
                        c.statement.executeUpdate("update room set Availability = 'Available' where Room_Number = '" + labelRoomNumber.getText() + "'");
                        JOptionPane.showMessageDialog(null, "Check-out Succesfull!");

                        setVisible(false);

                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(300,300,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try
               {
                   con c = new con();
                   ResultSet resultSet = c.statement.executeQuery("select * from customer where Number = '"+customer.getSelectedItem()+"'");
                   while(resultSet.next()){
                       labelRoomNumber.setText(resultSet.getString("Room_No"));
                       labelcheckintime.setText(resultSet.getString("Check_In_Time"));
                   }
               }
               catch (Exception ex)
               {
                   ex.printStackTrace();
               }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(165,300,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setLayout(null);
        setSize(800,400);
        setLocation(500,210);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new checkout();
    }
}
