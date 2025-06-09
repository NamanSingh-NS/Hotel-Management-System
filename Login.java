package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textfield1;
    JPasswordField passwordField1;
    JButton b1,b2;
    Login()
    {
        //(3) Add Username Text
        JLabel label1 = new JLabel("Username");
        label1.setBounds(40,20,100,30);
        label1.setFont(new Font("Tahoma", Font.BOLD,16));
        label1.setForeground(Color.WHITE);//text color
        add(label1);

        //(4) Add Password Text
        JLabel label2 = new JLabel("Password");
        label2.setBounds(40,70,100,30);
        label2.setFont(new Font("Tahoma", Font.BOLD,16));
        label2.setForeground(Color.white);
        add(label2);

        //(5) Add Text Field for Username(Declare textfield as a global variable as it will be accessed by the Action Listener which is outside the constructor)
        textfield1 = new JTextField();
        textfield1.setBounds(150,20,150,30);
        textfield1.setForeground(Color.white);
        textfield1.setFont(new Font("Tahoma",Font.PLAIN,15));
        textfield1.setBackground(new Color(26,104,110));
        add(textfield1);

        //(6) Add Password Field
        passwordField1 = new JPasswordField();
        passwordField1.setBounds(150,70,150,30);
        passwordField1.setForeground(Color.white);
        passwordField1.setBackground(new Color(26,104,110));
        add(passwordField1);

        //(7) Add Logo
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/Vistara.gif"));
        Image i = imageIcon.getImage().getScaledInstance(255,300,Image.SCALE_DEFAULT);
        ImageIcon i1 = new ImageIcon(i);
        JLabel label = new JLabel(i1);
        label.setBounds(318,-30,255,300);
        add(label);

        //(8) Add Login Button
        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.PLAIN,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);//Action Listener oversees the action performed on button
        add(b1);

        //(9) Add Cancel Button
        b2 = new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.PLAIN,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        //(2) Set Background color of login frame
        getContentPane().setBackground(new Color(3,45,48));

        //(1) Login Frame
        setUndecorated(true);
        setLayout(null);
        setLocation(400,270);
        setSize(600,300);
        setVisible(true);

    }

    //(10) Add Action Listener to make the button Functional, it is implemented by overriding the class
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1)//e will get the information when button is clicked, in this case if user press sign in button the following things will be performed
        {
            try{

                //make object of con class to access the db
                con c = new con();

                String user = textfield1.getText(); // "user" will get the value of the username entered the user
                String pass = passwordField1.getText(); // "pass" will get the value of the password entered the user

                //check whether the details entered by the user matches the data in the db
                String q = "select * from login where username = '"+user+"' and password = '"+pass+"'";
                //retreive data
                ResultSet resultSet = c.statement.executeQuery(q);//data stored in resultset after query is executed, ResultSet is a part of sql package

                if(resultSet.next())//data matches with that of db
                {
                    new Dashboard();
                    setVisible(false);
                }
                else//data don't match
                {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password!");//show error message
                }

            }catch(Exception E)
            {
                E.printStackTrace();
            }
        }else{
            System.exit(7);
        }
    }

    public static void main(String[] args) {

        new Login();
    }
}
