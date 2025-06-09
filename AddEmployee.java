package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener
{
    JTextField nameText,ageText,salText,phoneText,aadharText,emailText;
    JRadioButton M,F;
    JComboBox j;
    JButton add,back;

    AddEmployee(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        //Add Employee Heading
        JLabel heading = new JLabel("ADD EMPLOYEE DETAILS");
        heading.setBounds(450,24,445,35);
        heading.setFont(new Font("Tahoma",Font.BOLD,31));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        //Logo
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("Icons/addemp.png"));
        Image i1 = i.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i11 = new ImageIcon(i1);
        JLabel Emp = new JLabel(i11);
        Emp.setBounds(500,100,300,300);
        panel.add(Emp);

        //Name
        JLabel name = new JLabel("NAME");
        name.setBounds(60,30,150,27);
        name.setFont(new Font("serif",Font.BOLD,17));
        name.setForeground(Color.white);
        panel.add(name);

        nameText = new JTextField();
        nameText.setBounds(200,30,150,27);
        nameText.setBackground(new Color(16,108,115));
        nameText.setFont(new Font("Tahoma",Font.BOLD,14));
        nameText.setForeground(Color.white);
        panel.add(nameText);


        //Age
        JLabel age = new JLabel("AGE");
        age.setBounds(60,80,150,27);
        age.setFont(new Font("serif",Font.BOLD,17));
        age.setForeground(Color.white);
        panel.add(age);

        ageText = new JTextField();
        ageText.setBounds(200,80,150,27);
        ageText.setBackground(new Color(16,108,115));
        ageText.setFont(new Font("Tahoma",Font.BOLD,14));
        ageText.setForeground(Color.white);
        panel.add(ageText);

        //Gender
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60,130,150,27);
        gender.setFont(new Font("serif",Font.BOLD,17));
        gender.setForeground(Color.white);
        panel.add(gender);

        M = new JRadioButton("MALE");
        M.setBounds(200,130,70,27);
        M.setFont(new Font("Tahoma",Font.BOLD,14));
        M.setBackground(new Color(3,45,48));
        M.setForeground(Color.WHITE);
        panel.add(M);

        F = new JRadioButton("FEMALE");
        F.setBounds(280,130,100,27);
        F.setFont(new Font("Tahoma",Font.BOLD,14));
        F.setBackground(new Color(3,45,48));
        F.setForeground(Color.WHITE);
        panel.add(F);

        //Job
        JLabel job = new JLabel("JOB");
        job.setBounds(60,180,150,27);
        job.setFont(new Font("serif",Font.BOLD,17));
        job.setForeground(Color.white);
        panel.add(job);

        j = new JComboBox(new String[]{"Front Desk","Housekeeping","Kitchen Staff","Room Service","Manager","Accountant","Chef"});
        j.setBounds(200,180,150,30);
        j.setBackground(new Color(16,108,115));
        j.setForeground(Color.WHITE);
        j.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(j);

        //Salary
        JLabel sal = new JLabel("SALARY");
        sal.setBounds(60,230,150,27);
        sal.setFont(new Font("serif",Font.BOLD,17));
        sal.setForeground(Color.white);
        panel.add(sal);

        salText = new JTextField();
        salText.setBounds(200,230,150,27);
        salText.setBackground(new Color(16,108,115));
        salText.setFont(new Font("Tahoma",Font.BOLD,14));
        salText.setForeground(Color.white);
        panel.add(salText);

        //Phone
        JLabel phone = new JLabel("PHONE");
        phone.setBounds(60,280,150,27);
        phone.setFont(new Font("serif",Font.BOLD,17));
        phone.setForeground(Color.white);
        panel.add(phone);

        phoneText = new JTextField();
        phoneText.setBounds(200,280,150,27);
        phoneText.setBackground(new Color(16,108,115));
        phoneText.setFont(new Font("Tahoma",Font.BOLD,14));
        phoneText.setForeground(Color.white);
        panel.add(phoneText);

        //Aadhar
        JLabel aadhar = new JLabel("AADHAR ");
        aadhar.setBounds(60,330,150,27);
        aadhar.setFont(new Font("serif",Font.BOLD,17));
        aadhar.setForeground(Color.white);
        panel.add(aadhar);

        aadharText = new JTextField();
        aadharText.setBounds(200,330,150,27);
        aadharText.setBackground(new Color(16,108,115));
        aadharText.setFont(new Font("Tahoma",Font.BOLD,14));
        aadharText.setForeground(Color.white);
        panel.add(aadharText);

        //Email
        JLabel email = new JLabel("E-MAIL");
        email.setBounds(60,380,150,27);
        email.setFont(new Font("serif",Font.BOLD,17));
        email.setForeground(Color.white);
        panel.add(email);

        emailText = new JTextField();
        emailText.setBounds(200,380,150,27);
        emailText.setBackground(new Color(16,108,115));
        emailText.setFont(new Font("Tahoma",Font.BOLD,14));
        emailText.setForeground(Color.white);
        panel.add(emailText);

        //Back
        back = new JButton("BACK");
        back.setBounds(200,420,100,30);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        panel.add(back);

        //Save
        add = new JButton("SAVE");
        add.setBounds(80,420,100,30);
        add.setFont(new Font("Tahoma",Font.BOLD,14));
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        setUndecorated(true);
        setLocation(60,160);
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
                 String sal = salText.getText();
                 String phone = phoneText.getText();
                 String email = emailText.getText();
                 String aadhar = aadharText.getText();
                 String job = (String)j.getSelectedItem();
                 String Gender = null;
                 if(M.isSelected()){
                     Gender = "Male";
                 }
                 else if(F.isSelected()){
                     Gender = "Female";
                 }

                con c = new con();
                String q = "insert into employee values('"+name+"','"+age+"','"+Gender+"','"+job+"','"+sal+"','"+phone+"','"+email+"','"+aadhar+"')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Employee Added!");
                setVisible(false);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
