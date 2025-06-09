package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener
{
    JComboBox ID;
    JTextField nameText,numberText,countryText,depositText;
    JRadioButton r1,r2;
    Choice roomchoice;
    JLabel date;
    JButton add,back;

    NewCustomer()
    {

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel heading = new JLabel("NEW CUSTOMER FORM");
        heading.setBounds(118,11,260,53);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        heading.setForeground(Color.white);
        panel.add(heading);

        //Gov Id
        JLabel id = new JLabel("ID :");
        id.setBounds(35,76,200,14);
        id.setFont(new Font("Tahoma",Font.PLAIN,14));
        id.setForeground(Color.WHITE);
        panel.add(id);

        ID = new JComboBox(new String[]{"Aadhar Card","Driving License","Passport","Voter Id"});
        ID.setBounds(271,73,150,20);
        ID.setForeground(Color.WHITE);
        ID.setFont(new Font("Tahoma",Font.PLAIN,14));
        ID.setBackground(new Color(3,45,48));
        panel.add(ID);

        //name
        JLabel name = new JLabel("Name :");
        name.setBounds(35,151,200,14);
        name.setFont(new Font("Tahoma",Font.PLAIN,14));
        name.setForeground(Color.WHITE);
        panel.add(name);

        nameText = new JTextField();
        nameText.setBounds(271,151,150,20);
        nameText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(nameText);

        //Number
        JLabel number = new JLabel("Document No. :");
        number.setBounds(35,111,200,14);
        number.setFont(new Font("Tahoma",Font.PLAIN,14));
        number.setForeground(Color.WHITE);
        panel.add(number);

        numberText = new JTextField();
        numberText.setBounds(271,111,150,20);
        numberText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(numberText);

        //gender
        JLabel gender = new JLabel("Gender :");
        gender.setBounds(35,191,200,14);
        gender.setFont(new Font("Tahoma",Font.PLAIN,14));
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(3,45,48));
        r1.setBounds(271,191,80,14);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(3,45,48));
        r2.setBounds(350,191,80,14);
        panel.add(r2);

        //Country
        JLabel country = new JLabel("Country :");
        country.setBounds(35,231,200,18);
        country.setFont(new Font("Tahoma",Font.PLAIN,14));
        country.setForeground(Color.WHITE);
        panel.add(country);

        countryText = new JTextField();
        countryText.setBounds(271,231,150,20);
        countryText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(countryText);

        //Room
        JLabel room = new JLabel("Allocated Room Number :");
        room.setBounds(35,274,200,18);
        room.setFont(new Font("Tahoma",Font.PLAIN,14));
        room.setForeground(Color.WHITE);
        panel.add(room);

        roomchoice = new Choice();
        try
        {
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("select * from room where Availability = 'Available'");
            while(resultSet.next()){
                roomchoice.add(resultSet.getString("Room_Number"));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        roomchoice.setBounds(271,274,150,20);
        roomchoice.setFont(new Font("Tahoma",Font.BOLD,14));
        roomchoice.setForeground(Color.WHITE);
        roomchoice.setBackground(new Color(3,45,48));
        panel.add(roomchoice);

        //checkin
        JLabel checkin = new JLabel("Checked-In :");
        checkin.setBounds(35,316,200,18);
        checkin.setFont(new Font("Tahoma",Font.PLAIN,14));
        checkin.setForeground(Color.WHITE);
        panel.add(checkin);

        //current time
        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(271,316,300,18);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        date.setForeground(Color.white);
        panel.add(date);

        //Deposit
        JLabel deposit = new JLabel("Deposit(Rs.) : ");
        deposit.setBounds(35,359,200,18);
        deposit.setFont(new Font("Tahoma",Font.PLAIN,14));
        deposit.setForeground(Color.WHITE);
        panel.add(deposit);

        depositText = new JTextField();
        depositText.setBounds(271,359,150,20);
        depositText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(depositText);

        add = new JButton("ADD");
        add.setBounds(100,430,120,30);
        add.setFont(new Font("Tahoma",Font.BOLD,14));
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(260,430,120,30);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
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
        if(e.getSource()==add)
        {
            try{
                con c = new con();
                String radioBtn = null;
                if(r1.isSelected()){
                    radioBtn ="Male";
                }
                else if(r2.isSelected()){
                    radioBtn = "Female";
                }
                String s1 = (String)ID.getSelectedItem();
                String s2 = numberText.getText();
                String s3 = nameText.getText();
                String s4 = radioBtn;
                String s5 = countryText.getText();
                String s6 = roomchoice.getSelectedItem();
                String s7 = date.getText();
                String s8 = depositText.getText();

                String q = "insert into customer values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1 = "update room set Availability = 'Occupied' where Room_Number = "+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Customer Added Successfully!");
                setVisible(false);
            }
            catch(Exception ex)
            {
               ex.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
