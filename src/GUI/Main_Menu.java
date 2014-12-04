package GUI;

import API.Commands;

import javax.swing.*;

public class Main_Menu extends JMenuBar
{
    public Main_Menu(Commands cmd)
    {
        JMenu       mmEdit          = new JMenu("File");
        JMenuItem   mmFileCreate    = new JMenuItem("Create");
        JMenuItem   mmFileRead      = new JMenuItem("Read");
        JMenuItem   mmFileUpdate    = new JMenuItem("Update");
        JMenuItem   mmFileDelete    = new JMenuItem("Delete");
        JMenuItem   mmExit          = new JMenuItem("Exit");

        JMenu       mmHelp          = new JMenu("Help");
        JMenuItem   mmAbout         = new JMenuItem("About");

        add(mmEdit);
        mmEdit.add(mmFileCreate);
        mmEdit.add(mmFileRead);
        mmEdit.add(mmFileUpdate);
        mmEdit.add(mmFileDelete);
        mmEdit.add(mmExit);

        add(mmHelp);
        mmHelp.add(mmAbout);

        mmFileCreate.       addActionListener(cmd.evCreate);
        mmFileRead.         addActionListener(cmd.evRead);
        mmFileUpdate.       addActionListener(cmd.evUpdate);
        mmFileDelete.       addActionListener(cmd.evDelete);
        mmHelp.             addActionListener(cmd.evAbout);
        mmAbout.            addActionListener(cmd.evAbout);
        mmExit.             addActionListener(cmd.evExit);

        mmFileCreate.       setAccelerator(KeyStroke.getKeyStroke("ctrl 1"));
        mmFileRead.         setAccelerator(KeyStroke.getKeyStroke("ctrl 2"));
        mmFileUpdate.       setAccelerator(KeyStroke.getKeyStroke("ctrl 3"));
        mmFileDelete.       setAccelerator(KeyStroke.getKeyStroke("ctrl 4"));
        mmExit.             setAccelerator(KeyStroke.getKeyStroke("alt f4"));

    }
}
