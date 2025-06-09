package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame implements ActionListener {

    JTextField room,price;
    JComboBox avail,clean,bed;//dropdown
    JButton add,back;

    AddRoom(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,875,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel heading = new JLabel("Add Rooms");
        heading.setBounds(194,10,160,22);
        heading.setFont(new Font("Tahoma",Font.BOLD,22));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        JLabel roomNumber = new JLabel("Room Number");
        roomNumber.setBounds(64,70,152,22);
        roomNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        roomNumber.setForeground(Color.white);
        panel.add(roomNumber);

        room = new JTextField();
        room.setBounds(200,70,156,20);
        room.setFont(new Font("Tahoma",Font.PLAIN,14));
        room.setForeground(Color.WHITE);
        room.setBackground(new Color(16,108,115));
        panel.add(room);

        JLabel Availability = new JLabel("Availability");
        Availability.setBounds(64,110,152,22);
        Availability.setFont(new Font("Tahoma",Font.BOLD,14));
        Availability.setForeground(Color.white);
        panel.add(Availability);

        avail = new JComboBox(new String[]{"Available","Occupied"});//options
        avail.setBounds(200,110,156,20);
        avail.setFont(new Font("Tahoma",Font.PLAIN,14));
        avail.setForeground(Color.WHITE);
        avail.setBackground(new Color(16,108,115));
        panel.add(avail);

        JLabel Price = new JLabel("Price");
        Price.setBounds(64,150,152,22);
        Price.setFont(new Font("Tahoma",Font.BOLD,14));
        Price.setForeground(Color.white);
        panel.add(Price);

        price = new JTextField();
        price.setBounds(200,150,156,20);
        price.setFont(new Font("Tahoma",Font.PLAIN,14));
        price.setForeground(Color.WHITE);
        price.setBackground(new Color(16,108,115));
        panel.add(price);

        JLabel CleanStatus = new JLabel("Cleaning Status");
        CleanStatus.setBounds(64,190,152,22);
        CleanStatus.setFont(new Font("Tahoma",Font.BOLD,14));
        CleanStatus.setForeground(Color.white);
        panel.add(CleanStatus);

        clean = new JComboBox(new String[]{"Cleaned","Dirty"});
        clean.setBounds(200,190,156,20);
        clean.setFont(new Font("Tahoma",Font.PLAIN,14));
        clean.setForeground(Color.WHITE);
        clean.setBackground(new Color(16,108,115));
        panel.add(clean);

        JLabel BedType = new JLabel("Bed Type");
        BedType.setBounds(64,230,152,22);
        BedType.setFont(new Font("Tahoma",Font.BOLD,14));
        BedType.setForeground(Color.white);
        panel.add(BedType);

        bed = new JComboBox(new String[]{"Single Bed","Double Bed","Deluxe"});
        bed.setBounds(200,230,156,20);
        bed.setFont(new Font("Tahoma",Font.PLAIN,14));
        bed.setForeground(Color.WHITE);
        bed.setBackground(new Color(16,108,115));
        panel.add(bed);

        add = new JButton("ADD");
        add.setBounds(64,321,111,33);
        add.setFont(new Font("Tahoma",Font.BOLD,13));
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(198,321,111,33);
        back.setFont(new Font("Tahoma",Font.BOLD,13));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon room = new ImageIcon(ClassLoader.getSystemResource("Icons/roomser.png"));
        Image i = room.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
        ImageIcon roomLogo = new ImageIcon(i);
        JLabel label = new JLabel(roomLogo);
        label.setBounds(500,60,300,300);
        panel.add(label);

        setUndecorated(true);//remove border of frame
        setLocation(20,200);
        setLayout(null);
        setSize(885,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add)
        {
            try
            {
                con c = new con();//connection
                String room_no = room.getText();
                String ava = (String) avail.getSelectedItem();
                String status = (String) clean.getSelectedItem();
                String Price = price.getText();
                String type = (String)bed.getSelectedItem();

                String q = "insert into room values('"+room_no+"','"+ava+"','"+status+"','"+Price+"','"+type+"')";
                c.statement.executeUpdate(q);//add data

                JOptionPane.showMessageDialog(null,"Room Successfully Added");
                setVisible(false);

            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else if (e.getSource()==back)
        {
                setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRoom();
    }
}
