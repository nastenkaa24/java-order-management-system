package Business_Logic;

import Data_Model.Employee;
import Data_Model.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Utility {

    public static String filterEmployeesOver40Hours (TasksManagement employeeRecords)
    {

        System.out.println(employeeRecords);
        Map<Employee, ArrayList<Task>> map=employeeRecords.getMap();
        ArrayList <Employee> filteredListOfEmployee=new ArrayList<>();

        for(Employee e: map.keySet())
        {
            int totalDurationPerEmployee=employeeRecords.calculateEmployeeWorkDuration(e.getIdEmployee());
            if(totalDurationPerEmployee>40)
            {
                filteredListOfEmployee.add(e);
            }
        }
        filteredListOfEmployee.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {

                int d1 = employeeRecords.calculateEmployeeWorkDuration(e1.getIdEmployee());
                int d2 = employeeRecords.calculateEmployeeWorkDuration(e2.getIdEmployee());

                return Integer.compare(d1, d2);
            }
        });

        String res = "";
        for(Employee e : filteredListOfEmployee)
        {
            int duration = employeeRecords.calculateEmployeeWorkDuration(e.getIdEmployee());
            res+=e.getName() + " - " + duration + " ore \n";
            System.out.println(e.getName() + " - " + duration + " ore ");
        }

       return res;
    }


    public static Map<String, Map<String,Integer>> countCompletedAndUncompletedTasks(TasksManagement employeeRecords)
    {
        Map<String, Map<String,Integer>> resultMap = new HashMap<>();

        Map<Employee, ArrayList<Task>> map = employeeRecords.getMap();

        for(Employee e : map.keySet())
        {
            int completed = 0;
            int uncompleted = 0;

            ArrayList<Task> taskList = map.get(e);

            for(Task t : taskList)
            {
                if(t.getStatusTask() == Task.TaskStatus.COMPLETED)
                {
                    completed++;
                }
                else
                {
                    uncompleted++;
                }
            }

            Map<String,Integer> innerMap = new HashMap<>();
            innerMap.put("Completed", completed);
            innerMap.put("Uncompleted", uncompleted);

            String employeeName=e.getName();
            resultMap.put(employeeName, innerMap);
        }

        return resultMap;
    }

}
