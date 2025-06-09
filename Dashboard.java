package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JButton add,rec;

    Dashboard()
    {
        super("Hotel Management System - VISTARA");

        rec = new JButton("RECEPTION");
        rec.setBounds(425,510,140,30);
        rec.setFont(new Font("Tahoma",Font.BOLD,15));
        rec.setBackground(new Color(255,98,0));
        rec.setForeground(Color.WHITE);
        rec.addActionListener(this);
        add(rec);

        add = new JButton("ADMIN");
        add.setBounds(880,510,140,30);
        add.setFont(new Font("Tahoma",Font.BOLD,15));
        add.setBackground(new Color(255,98,0));
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        ImageIcon ad = new ImageIcon(ClassLoader.getSystemResource("Icons/boss.png"));
        Image admin = ad.getImage().getScaledInstance(200,195, Image.SCALE_DEFAULT);
        ImageIcon admin1 = new ImageIcon(admin);
        JLabel label1 = new JLabel(admin1);
        label1.setBounds(850,300,200,195);
        add(label1);

        ImageIcon rec = new ImageIcon(ClassLoader.getSystemResource("Icons/Reception.png"));
        Image reception = rec.getImage().getScaledInstance(200,195, Image.SCALE_DEFAULT);
        ImageIcon reception1 = new ImageIcon(reception);
        JLabel label11 = new JLabel(reception1);
        label11.setBounds(400,300,200,195);
        add(label11);

        ImageIcon bcg = new ImageIcon(ClassLoader.getSystemResource("Icons/Dashboard.gif"));
        Image bcgimage = bcg.getImage().getScaledInstance(1950,1090, Image.SCALE_DEFAULT);
        ImageIcon bcg1 = new ImageIcon(bcgimage);
        JLabel label = new JLabel(bcg1);
        label.setBounds(0,0,1950,1090);
        add(label);

        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
            if(e.getSource()==rec)
            {
                new Reception();
                setVisible(false);
            }
            else{
                new Login2();
                setVisible(false);
            }
    }

    public static void main(String[] args)
    {
     new Dashboard();
    }
}
