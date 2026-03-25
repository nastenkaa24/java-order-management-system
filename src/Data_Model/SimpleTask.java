package Data_Model;

public class SimpleTask extends Task {
    private int startHour;
    private int endHour;

  public SimpleTask( Task.TaskStatus statusTask, int startHour, int endHour)
    {
        super(statusTask);
        this.startHour=startHour;
        this.endHour=endHour;
    }

    @Override
    public int estimateDuration()
    {
        if (startHour<0 || startHour>=24 || endHour<0 || endHour>=24) {
            return -1;
        }
        if (endHour<=startHour) {
            return (24-startHour)+endHour;
        }

        return this.endHour-this.startHour;
    }

    public String toString()
    {
        return "simple "+this.getIdTask()+" -- "+this.getStatusTask()+ " ,start: "+startHour+" end: "+endHour;
    }
}
