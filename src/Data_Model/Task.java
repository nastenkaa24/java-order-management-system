package Data_Model;

import java.io.Serializable;

public abstract class Task implements Serializable {
    private int idTask;
    private TaskStatus statusTask;
    private static int idTaskStart=1;
    public enum TaskStatus
    {
        COMPLETED, UNCOMPLETED;
    }

    public Task( TaskStatus statusTask) {
        this.idTask = generareId();
        this.statusTask = statusTask;
    }
    public int generareId()
    {
        return idTaskStart++;
    }

    public abstract int estimateDuration();

    public int getIdTask() {
        return idTask;
    }

    public TaskStatus getStatusTask() {
        return statusTask;
    }

    public void setStatusTask(TaskStatus statusTask)
    {
        this.statusTask=statusTask;
    }

    public String toString()
    {
        return "Task id--status:  "+ this.idTask+" -- "+this.statusTask;
    }



}
