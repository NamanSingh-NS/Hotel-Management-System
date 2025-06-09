package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame {

    String old_room;
    UpdateCheck()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Check-in Details");
        label1.setBounds(124,11,222,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("ID : ");
        label2.setBounds(25,88,46,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice ch = new Choice();
        ch.setBounds(248,88,140,20);
        panel.add(ch);

        try{
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("select * from customer");
            while(resultSet.next()){
                ch.add(resultSet.getString("Number"));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number : ");
        label3.setBounds(25,129,197,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textField1 = new JTextField();
        textField1.setBounds(248,129,140,20);
        panel.add(textField1);

        JLabel label4 = new JLabel("Name : ");
        label4.setBounds(25,174,97,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textField2 = new JTextField();
        textField2.setBounds(248,174,140,20);
        panel.add(textField2);

        JLabel label5 = new JLabel("Checked-in : ");
        label5.setBounds(25,216,97,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textField3 = new JTextField();
        textField3.setBounds(248,216,140,20);
        panel.add(textField3);

        JLabel label6 = new JLabel("Amount Paid(Rs) : ");
        label6.setBounds(25,261,175,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textField4 = new JTextField();
        textField4.setBounds(248,261,140,20);
        panel.add(textField4);

        JLabel label7 = new JLabel("Pending Amount(Rs): ");
        label7.setBounds(25,302,175,20);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        label7.setForeground(Color.WHITE);
        panel.add(label7);

        JTextField textField5 = new JTextField();
        textField5.setBounds(248,302,140,20);
        panel.add(textField5);

        JButton update = new JButton("Update");
        update.setBounds(56,378,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    con c = new con();
                    String q = ch.getSelectedItem();
                    String room = textField1.getText();
                    String name = textField2.getText();
                    String check = textField3.getText();
                    String amount = textField4.getText();
                    c.statement.executeUpdate("update customer set Room_No = '"+room+"', Name = '"+name+"', Check_In_Time = '"+check+"', Deposit_Amount = '"+amount+"' where Number = '"+q+"'");
                    c.statement.executeUpdate("update room set Availability = 'Occupied' where Room_Number = '"+room+"'");
                    //change in room table also
                    c.statement.executeUpdate("update room set Availability = 'Available' where Room_Number = '"+old_room+"'");

                    JOptionPane.showMessageDialog(null,"Updated Successfully!");
                    setVisible(false);
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        panel.add(update);

        JButton back = new JButton("Back");
        back.setBounds(168,378,89,23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(back);

        JButton check = new JButton("Check");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    con c = new con();
                    String id = ch.getSelectedItem();
                    String q = "select * from customer where Number = '"+id+"'";
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while(resultSet.next()){
                        textField1.setText(resultSet.getString("Room_No"));
                        textField2.setText(resultSet.getString("Name"));
                        textField3.setText(resultSet.getString("Check_In_Time"));
                        textField4.setText(resultSet.getString("Deposit_Amount"));
                        old_room = textField1.getText();
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where Room_Number = '"+textField1.getText()+"'");
                    while(resultSet1.next()){
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price) -  Integer.parseInt(textField4.getText());
                        textField5.setText(""+amountPaid);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(check);

        setUndecorated(true);
        setLayout(null);
        setSize(950,500);
        setLocation(500,150);
        setVisible(true);

    }
    public static void main(String[] args) {
        new UpdateCheck();
    }
}
