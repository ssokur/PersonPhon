package GUI;

import API.Commands;
import API.DataModel;

import javax.swing.*;
import java.awt.*;
import java.net.UnknownHostException;
import java.text.ParseException;

public class Frame_Person extends JFrame
{
    Main_Menu       menu;         // init main mane
    ToolBar         tBar;         // init toolbar
    StatBar         stBar;        // init Status Bar
    Commands        comands;      // init class with commands
    Data_Person     data;         // init class with structure Person ArrayList
    PanelButton     pbtn;         // init panel for 4 buttons
    DataModel dataModel;    // init class with ArrayList structure
    PanelWork       tablePerson;  // init table for data

    public Frame_Person() throws ParseException, UnknownHostException {
        setLayout(null);

        dataModel = new DataModel();
        data = new Data_Person();
        comands = new Commands(dataModel);
        menu = new Main_Menu(comands);
        tBar = new ToolBar(comands);
        stBar = new StatBar(comands, data);
        pbtn = new PanelButton(comands);

        tablePerson = new PanelWork(dataModel);
        comands.pw = tablePerson;

        tBar.setBounds(0, 0, 590, 30);
        tablePerson.setBounds(0, 30, 590, 540);
        pbtn.setBounds(0, 570, 590, 40);
        stBar.setBounds(0, 510, 586, 30);

        add(tBar);          // add panel with toolBar
        add(tablePerson);   // add panel with table data
        add(pbtn);          // add panel with buttons

        setJMenuBar(menu);
        setPreferredSize(new Dimension(600, 680));
        pack();
        setDefaultCloseOperation(Frame_Person.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
