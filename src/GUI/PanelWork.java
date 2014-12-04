package GUI;

import API.DataModel;
import API.PersonTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class PanelWork extends JPanel
{
    TableModel model = null;
    public JTable table;

    public PanelWork(DataModel dm)
    {
        model = new PersonTableModel(dm);                   // Обьевление обьекта и = создание нового класса
        table = new JTable(model);                          // Создание таблицы
        table.setPreferredSize(new Dimension(600, 700));
        JScrollPane scrollPane = new JScrollPane(table);    // Обьявление и создание  scroll
        scrollPane.setBounds(10, 10, 500, 500);             // Привязка во фрейме с размерами
        add(scrollPane);                                    // Добавление scroll в JPanel
    }

}
