package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;//COLOR
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame{
    Reception(){

        super("Hotel Management System - VISTARA");
        //panels
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(280,5,1238,820);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,270,820);
        panel1.setBackground(new Color(3,45,48));
        add(panel1);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Icons/Reception_main.png"));
        Image i1 = image.getImage().getScaledInstance(1280,853,Image.SCALE_DEFAULT);
        ImageIcon i11 = new ImageIcon(i1);
        JLabel i111 = new JLabel(i11);
        i111.setBounds(00,20,1280,853);
        panel.add(i111);

        ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("Icons/Vistara.gif"));
        Image i2 = image2.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(i2);
        JLabel i222 = new JLabel(i22);
        i222.setBounds(5,550,250,250);
        panel1.add(i222);

        JButton btnNCF = new JButton("New Customer Form");
        btnNCF.setBounds(30,30,200,30);
        btnNCF.setBackground(Color.BLACK);
        btnNCF.setForeground(Color.WHITE);
        panel1.add(btnNCF);
        btnNCF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new NewCustomer();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton btnRoom = new JButton("Room");
        btnRoom.setBounds(30,70,200,30);
        btnRoom.setBackground(Color.BLACK);
        btnRoom.setForeground(Color.WHITE);
        panel1.add(btnRoom);
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Room();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton btnDepartment = new JButton("Department");
        btnDepartment.setBounds(30,110,200,30);
        btnDepartment.setForeground(Color.WHITE);
        btnDepartment.setBackground(Color.BLACK);
        panel1.add(btnDepartment);
        btnDepartment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Department();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton btnAEI = new JButton("All Employee Info");
        btnAEI.setBounds(30,150,200,30);
        btnAEI.setBackground(Color.BLACK);
        btnAEI.setForeground(Color.WHITE);
        panel1.add(btnAEI);
        btnAEI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Employee();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton btnCI = new JButton("Customer Info");
        btnCI.setBounds(30,190,200,30);
        btnCI.setBackground(Color.BLACK);
        btnCI.setForeground(Color.WHITE);
        panel1.add(btnCI);
        btnCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new CustomerInfo();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton btnMI = new JButton("Manager Info");
        btnMI.setBounds(30,230,200,30);
        btnMI.setBackground(Color.BLACK);
        btnMI.setForeground(Color.WHITE);
        panel1.add(btnMI);
        btnMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Manager();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton btnCO = new JButton("Check Out");
        btnCO.setBounds(30,270,200,30);
        btnCO.setBackground(Color.BLACK);
        btnCO.setForeground(Color.WHITE);
        panel1.add(btnCO);
        btnCO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new checkout();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton btnUC = new JButton("Update Check-in Details");
        btnUC.setBounds(30,310,200,30);
        btnUC.setBackground(Color.BLACK);
        btnUC.setForeground(Color.WHITE);
        panel1.add(btnUC);
        btnUC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new UpdateCheck();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton btnURS = new JButton("Update Room Status");
        btnURS.setBounds(30,350,200,30);
        btnURS.setBackground(Color.BLACK);
        btnURS.setForeground(Color.WHITE);
        panel1.add(btnURS);
        btnURS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new UpdateRoom();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton btnPUS = new JButton("Pick-up Service");
        btnPUS.setBounds(30,390,200,30);
        btnPUS.setBackground(Color.BLACK);
        btnPUS.setForeground(Color.WHITE);
        panel1.add(btnPUS);
        btnPUS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new PickUp();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton btnSR = new JButton("Search Room");
        btnSR.setBounds(30,430,200,30);
        btnSR.setBackground(Color.BLACK);
        btnSR.setForeground(Color.WHITE);
        panel1.add(btnSR);
        btnSR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new SearchRoom();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton btnOc = new JButton("Past Customer Records");
        btnOc.setBounds(30,470,200,30);
        btnOc.setBackground(Color.BLACK);
        btnOc.setForeground(Color.WHITE);
        panel1.add(btnOc);
        btnOc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new OldCustomer();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(30,520,95,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel1.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==back){
                    setVisible(false);
                    new Dashboard();
                }

            }
        });

        JButton logout = new JButton("LOGOUT");
        logout.setBounds(130,520,95,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        panel1.add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    System.exit(7);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                }
        });

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Reception();
    }
}
