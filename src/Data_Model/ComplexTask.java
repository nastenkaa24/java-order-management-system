package Data_Model;

import java.util.ArrayList;

public class ComplexTask extends Task {
    private ArrayList<Task> taskList= new ArrayList<>();

    public ComplexTask( ArrayList<Task> taskList) {
        super(TaskStatus.COMPLETED);
        this.taskList=taskList;
    }
    public ComplexTask( ) {
        super(TaskStatus.COMPLETED);

    }

    @Override
    public int estimateDuration() {
        int total = 0;
        for (Task t : taskList) {
            int duration = t.estimateDuration();
            if (duration == -1) duration = 0;
            total += duration;
        }
        return total;
    }

    public void deleteTask(Task task) {
        taskList.remove(task);
    }



    public void setComplexStatusTask()
    {
            for (Task t : taskList)
            {
                if (t.getStatusTask() == TaskStatus.UNCOMPLETED)
                {
                    setStatusTask(TaskStatus.UNCOMPLETED);
                    return;
                }
            }
            setStatusTask(TaskStatus.COMPLETED);
    }

    public void addTask(Task t)
    {
        taskList.add(t);
        if (t.getStatusTask()==TaskStatus.UNCOMPLETED)
        {
            this.setStatusTask(TaskStatus.UNCOMPLETED);
        }
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public String toString() {
        String concat2 = "";
        String concat1 = "complex "+ this.getIdTask() + " -- " + this.getStatusTask() + ":";
        for (Task t : taskList)
            concat2 = concat2 + " ID " + t.getIdTask();
        return concat1+concat2;
    }
}
