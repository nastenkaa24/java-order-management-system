package Data_Model;

import java.io.Serializable;

public class Employee implements Serializable {
    private int idEmployee;
   private static int idEmployeeStart=1;
   private String name;

    public Employee( String name)
    {
        this.idEmployee=generareId();
        this.name=name;
    }

    public int generareId()
    {
        return idEmployeeStart++;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public String getName() {
        return name;
    }

   public String toString()
    {
        return  this.idEmployee+" -- "+this.name;
    }
}
