package GUI;

import API.Commands;

import javax.swing.*;

public class PanelButton extends JPanel
{
    public PanelButton(Commands cmd)
    {
        JButton create  = new JButton("Create");
        JButton read    = new JButton("Read");
        JButton edit    = new JButton("Edit");
        JButton delete  = new JButton("Delete");
        JButton lang    = new JButton("Lang");

        add(create);
        add(read);
        add(edit);
        add(delete);
        add(lang);

        create. addActionListener(cmd.evCreate);
        read.   addActionListener(cmd.evRead);
        edit.   addActionListener(cmd.evUpdate);
        delete. addActionListener(cmd.evDelete);
        lang.   addActionListener(cmd.exLang);
    }
}
