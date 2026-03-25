package Graphical_User_Interface;

import Business_Logic.TasksManagement;
import Data_Model.ComplexTask;
import Data_Model.Employee;
import Data_Model.SimpleTask;
import Data_Model.Task;
import java.io.*;

import java.io.Serializable;
import java.util.*;

public class Model implements Serializable {
    private List<Employee> employees; //nume Emp
    private List<Task> tasks; //nume Taskuri
    private TasksManagement employeeRecords;


    public Model() {
        employees = new ArrayList<>();
        tasks = new ArrayList<>();
        employeeRecords = new TasksManagement();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public TasksManagement getEmployeeRecords() {
        return employeeRecords;
    }

    public void setEmployeeRecords(TasksManagement employeeRecords) {
        this.employeeRecords = employeeRecords;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String modifyTaskStatus(int idEmployee,int idTask)
    {

        for(Employee e: this.employees)
        {

                for(Task t: this.tasks)
                {
                    if (t.getIdTask()==idTask)
                    {

                        if( t instanceof SimpleTask)
                        {
                            if(t.getStatusTask()==Task.TaskStatus.COMPLETED)
                            {
                                t.setStatusTask(Task.TaskStatus.UNCOMPLETED);
                                return "Statusul taskului "+idTask+" a fost modificat din COMPLETED in UNCOMPLETED .\n";
                            }
                            else if (t.getStatusTask()== Task.TaskStatus.UNCOMPLETED)
                            {
                                t.setStatusTask(Task.TaskStatus.COMPLETED);
                                return "Statusul taskului "+idTask+" a fost modificat din UNCOMPLETED in COMPLETED .\n";
                            }
                        }
                        else if (t instanceof ComplexTask)
                        {
                            if(t.getStatusTask()==Task.TaskStatus.COMPLETED)
                            {
                                ((ComplexTask) t).setComplexStatusTask();
                                if (t.getStatusTask()== Task.TaskStatus.COMPLETED)
                                {
                                    return "Statusul taskului "+idTask+" nu a putut fi modificat deoarece contine doar taskuri complete in lista sa.\n";
                                }
                                else
                                {
                                    return "Statusul taskului "+idTask+" a fost modificat din COMPLETED in UNCOMPLETED .\n";
                                }
                            }
                            else if (t.getStatusTask()== Task.TaskStatus.UNCOMPLETED)
                            {
                                ((ComplexTask) t).setComplexStatusTask();
                                if (t.getStatusTask()== Task.TaskStatus.UNCOMPLETED)
                                {
                                    return "Statusul taskului "+idTask+" nu a putut fi modificat deoarece contine taskuri uncomplete in lista sa.\n" ;
                                }
                                else
                                {
                                    return "Statusul taskului "+idTask+" a fost modificat din UNCOMPLETED in COMPLETED .\n";
                                }

                            }
                        }
                    }
                }
            }
        return "";
    }

    public void clear() {
        employees.clear();
        tasks.clear();
        employeeRecords.clear();
    }
}