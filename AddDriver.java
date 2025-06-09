package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener
{
    JTextField nameText, ageText, carCText,carNText,carLText;
    JComboBox g,ava;
    JButton add,back;

    AddDriver()
    {

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel driver = new JLabel("ADD DRIVERS");
        driver.setBounds(194,10,200,22);
        driver.setFont(new Font("Tahoma",Font.BOLD,22));
        driver.setForeground(Color.white);
        panel.add(driver);

        //name
        JLabel name = new JLabel("NAME");
        name.setBounds(64,70,102,22);
        name.setFont(new Font("serif",Font.BOLD,14));
        name.setForeground(Color.WHITE);
        panel.add(name);

        nameText = new JTextField();
        nameText.setBounds(194,70,156,20);
        nameText.setForeground(Color.WHITE);
        nameText.setBackground(new Color(16,108,115));
        nameText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(nameText);

        //age
        JLabel age = new JLabel("AGE");
        age.setBounds(64,110,102,22);
        age.setFont(new Font("serif",Font.BOLD,14));
        age.setForeground(Color.WHITE);
        panel.add(age);

        ageText = new JTextField();
        ageText.setBounds(194,110,156,20);
        ageText.setForeground(Color.WHITE);
        ageText.setBackground(new Color(16,108,115));
        ageText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(ageText);

        //gender
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(64,150,102,22);
        gender.setFont(new Font("serif",Font.BOLD,14));
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        g = new JComboBox(new String[]{"Male","Female"});
        g.setBounds(194,150,154,20);
        g.setBackground(new Color(16,108,115));
        g.setForeground(Color.WHITE);
        g.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(g);

        //car company
        JLabel carC = new JLabel("CAR COMPANY");
        carC.setBounds(64,190,130,22);
        carC.setFont(new Font("serif",Font.BOLD,14));
        carC.setForeground(Color.WHITE);
        panel.add(carC);

        carCText = new JTextField();
        carCText.setBounds(194,190,156,20);
        carCText.setForeground(Color.WHITE);
        carCText.setBackground(new Color(16,108,115));
        carCText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(carCText);

        //car name
        JLabel carN = new JLabel("CAR NAME");
        carN.setBounds(64,230,102,22);
        carN.setFont(new Font("serif",Font.BOLD,14));
        carN.setForeground(Color.WHITE);
        panel.add(carN);

        carNText = new JTextField();
        carNText.setBounds(194,230,156,20);
        carNText.setForeground(Color.WHITE);
        carNText.setBackground(new Color(16,108,115));
        carNText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(carNText);

        //Car Availability
        JLabel available = new JLabel("AVAILABLE");
        available.setBounds(64,270,102,22);
        available.setFont(new Font("serif",Font.BOLD,14));
        available.setForeground(Color.WHITE);
        panel.add(available);

        ava = new JComboBox(new String[]{"Yes","No"});
        ava.setBounds(194,270,154,20);
        ava.setBackground(new Color(16,108,115));
        ava.setForeground(Color.WHITE);
        ava.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(ava);

        //Location
        JLabel carL = new JLabel("LOCATION");
        carL.setBounds(64,310,102,22);
        carL.setFont(new Font("serif",Font.BOLD,14));
        carL.setForeground(Color.WHITE);
        panel.add(carL);

        carLText = new JTextField();
        carLText.setBounds(194,310,156,20);
        carLText.setForeground(Color.WHITE);
        carLText.setBackground(new Color(16,108,115));
        carLText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(carLText);

        //Add
        add = new JButton("ADD");
        add.setBounds(74,380,111,33);
        add.setFont(new Font("Tahoma",Font.BOLD,14));
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        panel.add(add);

        //Back
        back = new JButton("BACK");
        back.setBounds(208,380,111,33);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        panel.add(back);

        //image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/license.png"));
        Image i = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        setUndecorated(true);
        setLocation(20,200);
        setLayout(null);
        setSize(900,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==add)
        {
            try{
                String name = nameText.getText();
                String age = ageText.getText();
                String Gender = (String)g.getSelectedItem();
                String company = carCText.getText();
                String cname = carNText.getText();
                String avail = (String)ava.getSelectedItem();
                String location = carLText.getText();

                con c = new con();
                String q = "insert into driver values('"+name+"','"+age+"','"+Gender+"','"+company+"','"+cname+"','"+avail+"','"+location+"')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Driver Added! ");
                setVisible(false);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else if (e.getSource()==back)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new AddDriver();
    }
}
