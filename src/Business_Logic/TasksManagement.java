package Business_Logic;

import Data_Model.ComplexTask;
import Data_Model.Employee;
import Data_Model.SimpleTask;
import Data_Model.Task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TasksManagement implements Serializable {
    private Map<Employee, ArrayList<Task>> map=new HashMap<>();

    public TasksManagement() {

    }

    public Map<Employee, ArrayList<Task>> getMap() {
        return map;
    }

    public void addMap(Employee e)
    {
        map.put(e, new ArrayList<>());
    }

    public void assignTaskToEmployee(int idEmployee, Task task)
    {

        for(Employee e:map.keySet())
        {
            if (e.getIdEmployee()==idEmployee)
            {
                map.get(e).add(task);

                break;
            }
        }
    }

    public int calculateEmployeeWorkDuration(int idEmployee)
    {
        int total = 0;
        for(Employee e:map.keySet())
        {
            if(e.getIdEmployee() == idEmployee)
            {

                List<Task> taskList=map.get(e);

                for(Task t : taskList)
                {
                    if(t.getStatusTask()== Task.TaskStatus.COMPLETED) {
                        int duration = t.estimateDuration();
                        if (duration != -1) {
                            total +=duration;
                        }
                    }
                }

                return total;
            }

        }

        return 0;
    }

    public void clear()
    {
        map.clear();
    }

}
