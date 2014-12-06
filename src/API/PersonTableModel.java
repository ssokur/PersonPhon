package API;

import javax.swing.table.AbstractTableModel;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;

public class PersonTableModel extends AbstractTableModel
{
    DataModel dm = null;

    final String[] colNames = {"Id", "FName", "LName", "Age"};

    public PersonTableModel(DataModel dm) {
        this.dm = dm;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public String getColumnName(int columnIndex)
    {

        return colNames[columnIndex];
    }

    @Override
    public int getRowCount()
    {
        return dm.personList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) // Name of column
    {
        Person bean = dm.personList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return bean.getId();
            case 1:
                return bean.getFName();
            case 2:
                return bean.getLName();
            case 3:
                return bean.getAge();
        }
        return "";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex)
    {
        String val = (String) value;
        System.out.println(rowIndex + " x " + columnIndex + ": " + value);
        Person p = new Person(dm.personList.get(rowIndex).Id,
                dm.personList.get(rowIndex).FName,
                dm.personList.get(rowIndex).LName,
                dm.personList.get(rowIndex).Age);
        String str = null;
        str = PersonTableModel.this.getColumnName(columnIndex);
        if (str.equals("Id")) {
            p.setId(Integer.valueOf(val));
        } else if (str.equals("FName"))
        {
            p.setFName( val);
        } else if (str.equals("LName")) {
            p.setLName(val);
        } else if (str.equals("Age")) {
            p.setAge(Integer.valueOf(val));
        }
        dm.personList.set(rowIndex,p);
        try {
            DAL_Person dp = new DAL_Person();
            try {
                dp.update(p);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        System.out.println(PersonTableModel.this.getValueAt(rowIndex, columnIndex));
    }

}
