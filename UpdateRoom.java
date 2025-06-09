package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame {

    UpdateRoom(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,440);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/update.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Room Status");
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

        JLabel label4 = new JLabel("Availability : ");
        label4.setBounds(25,174,97,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textField2 = new JTextField();
        textField2.setBounds(248,174,140,20);
        panel.add(textField2);

        JLabel label5 = new JLabel("Clean Status : ");
        label5.setBounds(25,216,110,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textField3 = new JTextField();
        textField3.setBounds(248,216,140,20);
        panel.add(textField3);


        JButton update = new JButton("Update");
        update.setBounds(125,315,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    con c = new con();
                    String status = textField3.getText();
                    c.statement.executeUpdate("update room set Cleaning_Status = '"+status+"' where Room_Number = " + textField1.getText());
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
        back.setBounds(180,355,89,23);
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
        check.setBounds(60,355,89,23);
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
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where Room_Number = '"+textField1.getText()+"'");
                    while(resultSet1.next()){
                        textField2.setText(resultSet1.getString("Availability"));
                        textField3.setText(resultSet1.getString("Cleaning_Status"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(check);

        setUndecorated(true);
        setLayout(null);
        setSize(950,450);
        setLocation(500,150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
    }

