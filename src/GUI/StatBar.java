package GUI;

import API.Commands;
import com.sun.java.swing.plaf.motif.MotifBorders;

import javax.swing.*;
import java.awt.*;

public class StatBar extends JPanel
{
    JTextField fieldX = new JTextField();
    JTextField fieldY = new JTextField();
    JButton colPres = new JButton();
    Data_Person data;

    public StatBar(Commands comands, Data_Person dataIn)
    {
        data = dataIn;
        setLayout(null);
        setBackground(Color.PINK);
//        setPreferredSize(new Dimension(super.getWidth(), 30));

        fieldX.setBounds(650, 2, 50, 26);
        fieldX.setText("X: ");
        add(fieldX);

        fieldY.setBounds(720, 2, 50, 26);
        fieldY.setText("Y: ");
        add(fieldY);


        colPres.setBackground(Color.BLUE);
        colPres.setSize(50, 26);
        colPres.setBounds(500, 2, 50, 26);
        add(colPres);
        setBorder(new MotifBorders.BevelBorder(true,Color.black,null));
    }
   }
