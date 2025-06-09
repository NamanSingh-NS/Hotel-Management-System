package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    Splash(){

        super("Hotel Management System");
        //(2) Add Splash Image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/newSplash.gif"));//get image
        Image i = imageIcon.getImage().getScaledInstance(858,680,Image.SCALE_DEFAULT);
        ImageIcon i1 = new ImageIcon(i);
        JLabel label = new JLabel(i1);//image & text are displayed on the frame using Jlabel, therefore convert it into Jlabel
        label.setBounds(0,0,858,680);//frame me image ka size(same as size of frame)
        add(label);//used to add the label

        //(1) Frame Layout
        setLayout(null);//by default border layout, but we want to customize the frame as per our needs, therefore null.
        setLocation(300,80);//Kaha se khulega Frame
        setSize(858,680);//frame ka size
        setVisible(true);//by default false, therefor make it true to make the frame visible

        //(3) Make the frame disappear, we use try catch because there are chances of getting an exception
        try
        {
            Thread.sleep(7000);//Frame closes after 5 sec
            new Login();//Display login page after closing of the splash screen
            setVisible(false);//make the frame disappear
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    public static void main(String[] args)
    {

        new Splash();
    }
}
