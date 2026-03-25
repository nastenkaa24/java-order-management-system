import Business_Logic.TasksManagement;
import Business_Logic.Utility;
import Data_Access.SerializationOperations;
import Data_Model.ComplexTask;
import Data_Model.Employee;
import Data_Model.SimpleTask;
import Data_Model.Task;
import Graphical_User_Interface.Controller;
import Graphical_User_Interface.Model;
import Graphical_User_Interface.View;

public static void main(String[] args)
{
//    Employee e1=new Employee("Employee1");
//    Employee e2=new Employee("Employee2");
//    Employee e3=new Employee("Employee3");
//    Employee e4=new Employee("Employee4");
//    //Afisare date angajatului 1
//    System.out.println(e1);
//    System.out.println();
//
//    SimpleTask simple1=new SimpleTask( Task.TaskStatus.COMPLETED,10,17);//7
//    SimpleTask simple2=new SimpleTask( Task.TaskStatus.COMPLETED,2,24);//invalid
//    SimpleTask simple3=new SimpleTask( Task.TaskStatus.UNCOMPLETED,12,19);//7
//    SimpleTask simple4=new SimpleTask( Task.TaskStatus.UNCOMPLETED,-3,13);//invalid
//    SimpleTask simple5=new SimpleTask( Task.TaskStatus.UNCOMPLETED,6,12);//6
//
//    //taskurile complexe initial au lista goala, deci sunt complete
//    ComplexTask complex6=new ComplexTask();
//    ComplexTask complex7=new ComplexTask();
//    ComplexTask complex8=new ComplexTask();
//    ComplexTask complex9=new ComplexTask();
//
//    SimpleTask simple10=new SimpleTask( Task.TaskStatus.COMPLETED,4,12);//8
//    SimpleTask simple11=new SimpleTask(Task.TaskStatus.COMPLETED,3,2);//23
//
//    ComplexTask complex12=new ComplexTask();
//    ComplexTask complex13=new ComplexTask();
//
//
//    SimpleTask simple14=new SimpleTask( Task.TaskStatus.COMPLETED,0,0); //24
//    SimpleTask simple15=new SimpleTask( Task.TaskStatus.COMPLETED,0,0);//24
//    SimpleTask simple16=new SimpleTask( Task.TaskStatus.COMPLETED,0,0);//24
//    SimpleTask simple17=new SimpleTask( Task.TaskStatus.COMPLETED,0,0);//24
//    SimpleTask simple18=new SimpleTask( Task.TaskStatus.COMPLETED,1,1);//24
//    SimpleTask simple19=new SimpleTask( Task.TaskStatus.COMPLETED,5,7);//2
//
//
//
//    //daca unui task complex cu lista goala(complet) i se adauga un task uncomplet, statusul lui complex se modifica automat uncomplet
//    System.out.println("Modificarea statusului unui complex prin add: "+ complex12.getStatusTask());//COMPLETED
//    complex12.addTask(simple2);
//    complex12.addTask(simple3);
//    System.out.println("Modificarea statusului unui complex prin add: "+ complex12.getStatusTask());//UNCOMPLETED
//
//
//    complex13.addTask(simple3);//UNCOMPLET
//    complex13.addTask(simple4);//UNCOMPLET
//    complex13.addTask(simple11);//COMPLET
//    //complex13-uncompleted
//
//    complex6.addTask(simple1);//COMPLETED
//    complex6.addTask(simple3);//UNCOMPLETED
//    //complex6-uncompleted
//
//    complex7.addTask(simple1);//COMPLETED
//    complex7.addTask(simple2);//COMPLETED
//    //complex7-completed
//
//    complex8.addTask(complex6);//UNCOMPLETED
//    complex8.addTask(simple1);//COMPLETED
//    complex8.addTask(complex7);
//    complex8.deleteTask(complex7);
//    //complex8-uncompleted
//
//    complex9.addTask(complex6);//UNCOMPLETED
//    complex9.addTask(simple1);//COMPLETED
//    //complex9-completed
//
//    System.out.println();
//
//    //durata estimata a unor taskuri
//    System.out.println("Durata estimata a taskului cu id 1 este: "+ simple1.estimateDuration()); //7
//    System.out.println("Durata estimata a taskului cu id 2 este: "+ simple2.estimateDuration());  //-1
//    System.out.println("Durata estimata a taskului cu id 3 este: "+ simple3.estimateDuration());  //7
//    System.out.println("Durata estimata a taskului cu id 4 este: "+ simple4.estimateDuration());  //-1
//    System.out.println("Durata estimata a taskului cu id 5 este: "+ simple5.estimateDuration());  //6
//
//    System.out.println("Durata estimata a taskului cu id 6 este: "+ complex6.estimateDuration()); //14
//    System.out.println("Durata estimata a taskului cu id 7 este: "+ complex7.estimateDuration()); //7
//    System.out.println("Durata estimata a taskului cu id 8 este: "+ complex8.estimateDuration()); //21
//    System.out.println("Durata estimata a taskului cu id 11 este: "+ simple11.estimateDuration()); //23
//    System.out.println("Durata estimata a taskului cu id 12 este: "+ complex12.estimateDuration()); //7
//    System.out.println("Durata estimata a taskului cu id 13 este: "+ complex13.estimateDuration()); //30
//    System.out.println();
//    System.out.println("Durata estimata a taskului cu id 14 este: "+ simple14.estimateDuration()); //24
//    System.out.println("Durata estimata a taskului cu id 15 este: "+ simple15.estimateDuration()); //24
//    System.out.println("Durata estimata a taskului cu id 16 este: "+ simple16.estimateDuration()); //24
//    System.out.println("Durata estimata a taskului cu id 17 este: "+ simple17.estimateDuration()); //24
//    System.out.println("Durata estimata a taskului cu id 18 este: "+ simple18.estimateDuration()); //24
//    System.out.println("Durata estimata a taskului cu id 19 este: "+ simple19.estimateDuration()); //2
//    System.out.println();
//
//    //printare date a unui task complex, inclusiv lista sa cu id-urile taskurilor continute
//    System.out.println(complex6);
//    System.out.println();
//
//
//    TasksManagement employeeRecords=new TasksManagement();
//    employeeRecords.addMap(e1);
//    employeeRecords.addMap(e2);
//
//    //asignare taskuri angajatilor din map
//    employeeRecords.assignTaskToEmployee(1,simple1); //complet 7
//    employeeRecords.assignTaskToEmployee(1,simple4); //invalid 0
//    employeeRecords.assignTaskToEmployee(1,simple3); //uncomplet 0
//    employeeRecords.assignTaskToEmployee(1,complex7); //complet 7
//    employeeRecords.assignTaskToEmployee(1,complex12);//uncomplet 0
//    employeeRecords.assignTaskToEmployee(1,complex13);//uncomplet 0
//
//    //durata doar a taskurilor complexe
//    System.out.println("Estimeaza durata muncii angajatului 1(doar taskurile complete) "+employeeRecords.calculateEmployeeWorkDuration(1)); //14
//    System.out.println();
//
//    employeeRecords.modifyTaskStatus(1,1);//se modifica din COMPLETED in UNCOMPLETED
//    employeeRecords.modifyTaskStatus(1,3);//se modifica din UNCOMPLETED in COMPLETED
//    System.out.println("Status task 1 modificat din COMPLETED in "+simple1.getStatusTask());//UNCOMPLETED
//    System.out.println("Status task 3 modificat din UNCOMPLETED in "+simple3.getStatusTask());//COMPLETED
//
//    //taskul 12 este format din simple 2(completed) si simple 3(completed-modificat anterior(initial a fost uncompleted).
//    // Statusul taskului 12 este uncompleted. Se va modifica in completed dupa apelarea functiei modifyTaskStatus.
//    employeeRecords.modifyTaskStatus(1,12);//COMPLETED
//    System.out.println("Status task 12 modificat din UNCOMPLETED in "+complex12.getStatusTask());
//
//    //taskul 13 este format din simple 3(completed) si simple 4(uncompleted) si simple 11(completed). Statusul taskului 13 este uncompleted.
//    //Nu se va modifica in completed dupa apelarea functiei modifyTaskStatus deoarece inca are taskuri incomplete in lista sa.
//    employeeRecords.modifyTaskStatus(1,13);//UNCOMPLETED
//    System.out.println("Statusul taskului 13 a fost UNCOMPLETED, a ramas tot "+complex13.getStatusTask());
//    System.out.println();
//
//    //calculul orelor de munca(bazate pe taskurile complete) a angajatilor din map-ul employeeRecords2
//    TasksManagement employeeRecords2=new TasksManagement();
//    employeeRecords2.addMap(e3);
//    employeeRecords2.addMap(e4);
//    employeeRecords2.assignTaskToEmployee(4,simple14);//COMPLETED
//    employeeRecords2.assignTaskToEmployee(4,simple15);//COMPLETED
//
//    employeeRecords2.assignTaskToEmployee(3,simple19);//COMPLETED
//    employeeRecords2.assignTaskToEmployee(3,simple16);//COMPLETED
//    employeeRecords2.assignTaskToEmployee(3,simple17);//COMPLETED
//    employeeRecords2.assignTaskToEmployee(3,simple18);//COMPLETED
//    employeeRecords2.assignTaskToEmployee(3,complex6);//UNCOMPLETED
//
//
//    System.out.println("Estimeaza durata muncii angajatului 3(doar taskurile complete) "+employeeRecords2.calculateEmployeeWorkDuration(3));//74
//
//    System.out.println("Estimeaza durata muncii angajatului 4(doar taskurile complete) "+employeeRecords2.calculateEmployeeWorkDuration(4));//48
//    System.out.println();
//
//    //sortarea angajatilor din map dupa numarul orele de munca
//    System.out.println("SORTARE:");
//    Utility.filterEmployeesOver40Hours(employeeRecords2);
//
//    System.out.println();
//    //pentru fiecare angajat din map se afiseaza cate taskuri complete si uncomplete a realizat
//    //angajat 3(4 complete, 1 uncomplet )
//    //angajat 4(2 complete, 0 uncomplet)
//   System.out.println(Utility.countCompletedAndUncompletedTasks(employeeRecords2));

    Model model = SerializationOperations.loadModel();
    View view = new View(model);
    Controller controller = new Controller(view, model);
    view.setVisible(true);

    for(Employee e : model.getEmployees()) {
        view.addEmployeeToCombo(e);
    }

    for(Task t : model.getTasks()) {
        view.addTaskToCheckBoxes(t);
    }

}
