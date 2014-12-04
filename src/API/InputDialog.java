package API;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputDialog extends JDialog
{
    Person person = new Person();

    JTextField txt_ID = null;                // Создаем поля для ввода текста
    JTextField txt_FN = null;
    JTextField txt_LN = null;
    JTextField txt_Age = null;

    public String what_button = "";

    public InputDialog()            // создаем диалоговое окно
    {
        super();
        setModal(true);

        setLayout(null);                      // получить расположение
        setBounds(600, 200, 300, 250);

        JLabel lbl1 = new JLabel("ID_Person");   // Обьявление и сразу инициализация НАИМЕНОВАНИЕ ПОЛЯ "куда вводится текст"
        JLabel lbl2 = new JLabel("FName");
        JLabel lbl3 = new JLabel("LName");
        JLabel lbl4 = new JLabel("Age");

        lbl1.setBounds(10, 20, 120, 18);       // setBounds - установить размеры, привязка НАИМЕНОВАНИЕ ПОЛЯ во фрейме
        lbl2.setBounds(10, 50, 120, 18);
        lbl3.setBounds(10, 80, 120, 18);
        lbl4.setBounds(10, 110, 120, 18);

        add(lbl1);                               // Добавление НАИМЕНОВАНИЯ ПОЛЯ
        add(lbl2);
        add(lbl3);
        add(lbl4);

        txt_ID  = new JTextField();               // Инициализация поля "куда вводится текст"
        txt_FN  = new JTextField();
        txt_LN  = new JTextField();
        txt_Age = new JTextField();

        txt_ID. setBounds(130, 20, 120, 18);     // setBounds - установить размеры, привязка ПОЛЯ во фрейме
        txt_FN. setBounds(130, 50, 120, 18);
        txt_LN. setBounds(130, 80, 120, 18);
        txt_Age.setBounds(130, 110, 120, 18);

        add(txt_ID);                              // Добавление поля в рамку фрейм
        add(txt_FN);
        add(txt_LN);
        add(txt_Age);

        JButton btnOk = new JButton("OK");           // созлдаем 2 кнопки
        JButton btnCancel = new JButton("Cancel");

        btnOk.      setBounds(30, 140, 100, 22);           // рамеры кнопок
        btnCancel.  setBounds(150, 140, 100, 22);

        add(btnOk);                                       // добавление кнопок
        add(btnCancel);

        btnOk.      addActionListener(new ActionOk());      //  добавление действия пользователя
        btnCancel.  addActionListener(new ActionCancel());
    }

    public String getResult() {
        return what_button;
    }

    public void setPerson()
    {
        txt_ID. setText(String.valueOf(person.Id));
        txt_FN. setText(person.FName);
        txt_LN. setText(person.LName);
        txt_Age.setText(String.valueOf(person.Age));
    }

    public Person getPerson()
    {

        person.Id = Integer.parseInt(txt_ID.getText());
        person.FName = txt_FN.getText();
        person.LName = txt_LN.getText();
        person.Age = Integer.parseInt(txt_Age.getText());
        return person;
    }

    class ActionOk implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            what_button = "ok";
            setVisible(false);
        }
    }

    class ActionCancel implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            what_button = "cancel";
            setVisible(false);
        }
    }
}