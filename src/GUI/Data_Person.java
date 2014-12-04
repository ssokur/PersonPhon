package GUI;

import API.Person;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class Data_Person
{
    public ResourceBundle res = null;
    public static ToolBar toolBar = null;
    public ArrayList<Person> current = null;


    public void initList(ArrayList<Person> currentIn)
    {
        current = currentIn;
    }

}
