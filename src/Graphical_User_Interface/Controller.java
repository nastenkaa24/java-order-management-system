package Graphical_User_Interface;

import Business_Logic.TasksManagement;
import Business_Logic.Utility;
import Data_Access.SerializationOperations;
import Data_Model.ComplexTask;
import Data_Model.Employee;
import Data_Model.SimpleTask;
import Data_Model.Task;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;

        view.setAddEmployeeListener(new AddEmployeeListener());
        view.setAddSimpleTaskListener(new AddSimpleTaskLisener());
        view.setAddComplexTaskListener(new AddComplexTaskLisener());
        view.setAssignTaskListener(new AssignTaskListener());
        view.setModifyStatusListener(new ModifyStatusListener());
        view.setFilterAndSortListener(new FilterAndSortListener());
        view.setStatisticsListener(new StatisticsListener());
        view.setAddSaveListener(new SaveListener());

        view.setClearListener(new ClearListener());
    }

    class AddEmployeeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        //leaga view de model
            String employeeName=view.getEmployeeInput();
            Employee employee=new Employee(employeeName);
            model.addEmployee(employee);
            view.addEmployeeToCombo(employee);
            view.clearEmployeeField();
        }
    }

    class AssignTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            ArrayList<Task> taskList = view.getSelectedTask();
            Employee employee = view.getSelectedEmployee();
            TasksManagement management = model.getEmployeeRecords();

            String result = "";
            management.addMap(employee);

            for (Task task : taskList) {
                management.assignTaskToEmployee(employee.getIdEmployee(), task);
                result += "task "+ task.getIdTask() + " dureaza " + task.estimateDuration() + " ore\n";
                if(task.estimateDuration()==-1) result+=" task invalid\n";
            }

            view.setTaskListDurationField(result);
        }
    }

    class ModifyStatusListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Task> taskList = view.getSelectedTask();
            Employee employee = view.getSelectedEmployee();
            String result = "";

            for (Task task : taskList) {
                result+= model.modifyTaskStatus(employee.getIdEmployee(), task.getIdTask());

            }
            view.repaint(model.getTasks());
            view.setTaskListDurationField(result);
        }
        }


    class FilterAndSortListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TasksManagement management = model.getEmployeeRecords();
            view.setFilterField(Utility.filterEmployeesOver40Hours(management));

        }
    }

    class StatisticsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TasksManagement management = model.getEmployeeRecords();
            view.setStatisticsField(Utility.countCompletedAndUncompletedTasks(management).toString());
        }
    }

    class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.clear();
            view.clearAll();
        }
    }

    class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SerializationOperations.saveModel(model);
        }
    }

    private class AddSimpleTaskLisener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e)
        {
           Task.TaskStatus status= view.getSelectedStatus();
           String startHour=view.getStartInput();
           String endHour= view.getEndInput();
           SimpleTask task=new SimpleTask(status,Integer.parseInt(startHour),Integer.parseInt(endHour));
           model.addTask(task);
           view.addTaskToCheckBoxes(task);
           view.clearTaskFields();
        }
    }

    private class AddComplexTaskLisener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            ArrayList<Task> taskList=view.getSelectedTasksForComplexTask();
            ComplexTask complexTask=new ComplexTask(taskList);
            for(Task t:complexTask.getTaskList())
            {
                if (t.getStatusTask()== Task.TaskStatus.UNCOMPLETED)
                {
                    complexTask.setStatusTask(Task.TaskStatus.UNCOMPLETED);
                }
            }
            model.addTask(complexTask);
            view.addTaskToCheckBoxes(complexTask);
        }
    }
}