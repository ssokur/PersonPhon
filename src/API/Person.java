package API;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                // указывает на то, что данный класс является сущностью.
@Table(name="person")	// задает имя таблицы, в которой будут храниться объекты класса

public class Person
{
    @Id        //	 обозначает поле id
    @GeneratedValue(generator="increment")	// GeneratedValue и @GenericGenerator — указывает на то, как будет генерироваться id
//	@GenericGenerator(name="increment", strategy = "increment") // (у нас — по возрастанию)

    @Column(name="Id") // @Column — обозначает имя колонки, соответствующей данному полю.
    public int Id;

    @Column(name="FName")
    public String FName;

    @Column(name="LName")
    public String LName;

    @Column(name="Age")
    public int Age;

    public Person(int id, String FName, String LName, int age)
    {
        Id = id;
        this.FName = FName;
        this.LName = LName;
        Age = age;
    }

    public Person()
    {
        setId(Id);
        this.setFName(FName);
        this.setLName(LName);
        setAge(Age);
    }

    public int 		getId()
    {
        return Id;
    }
    public void 	setId(int id)
    {
        Id = id;
    }

    public String 	getFName()
    {
        return FName;
    }
    public void 	setFName(String fName)
    {
        FName = fName;
    }

    public String 	getLName()
    {
        return LName;
    }
    public void 	setLName(String lName)
    {
        LName = lName;
    }

    public int 		getAge()
    {
        return Age;
    }
    public void 	setAge(int age)
    {
        Age = age;
    }
}
