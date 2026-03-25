package Graphical_User_Interface;

import Data_Model.Employee;
import Data_Model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static Data_Model.Task.TaskStatus.COMPLETED;
import static Data_Model.Task.TaskStatus.UNCOMPLETED;

public class View extends JFrame {

    private JLabel employeeLabel = new JLabel("Employee");
    private JComboBox<Employee> empCombo = new JComboBox<>();

    private JLabel tasksLabel = new JLabel("Tasks");
    private JPanel tasksCheckPanel = new JPanel();

    private JLabel employeeNameLabel = new JLabel("Employee name");
    private JTextField employeeField = new JTextField(20);
    private JButton addEmployee = new JButton("Add Employee");

    private JLabel statusLabel = new JLabel("Task status");
    private JComboBox<Enum> statusBox = new JComboBox<>(new Enum[]{UNCOMPLETED, COMPLETED});

    private JLabel startHourLabel = new JLabel("Start hour");
    private JLabel endHourLabel = new JLabel("End hour");
    private JTextField startField = new JTextField(10);
    private JTextField endField = new JTextField(10);

    private JButton addSimpleTask = new JButton("Add Simple Task");
    private JButton addComplexTask = new JButton("Add Complex Task");

    private JLabel complexTasksLabel = new JLabel("Select tasks for complex task");
    private JPanel complexTasksCheckPanel = new JPanel();

    private JButton assignTaskToEmployee = new JButton("Assign Task");
    private JButton modifyStatus = new JButton("Modify Status");

    private JButton filterAndSort = new JButton("Filter Employees who work > 40 (ascending)");
    private JButton statistics = new JButton("Statistics");

    private JLabel detailsAboutEmployee = new JLabel("Details About Selected Employee (Task -- Duration)/ Modify status");
    private JTextArea taskListDurationField = new JTextArea(6, 35);

    private JTextArea filterField = new JTextArea(6, 30);
    private JTextArea statisticsField = new JTextArea(6, 30);

    private JButton clearBtn = new JButton("Clear");
    private JButton saveBtn = new JButton("Save ");

    private List<JCheckBox> taskCheckBoxes = new ArrayList<>();
    private List<Task> taskListForTopPanel = new ArrayList<>();

    private List<JCheckBox> complexTaskCheckBoxes = new ArrayList<>();
    private List<Task> taskListForComplexPanel = new ArrayList<>();

    private Model model;

    public View(Model model) {
        this.model = model;

        setTitle("Managing Tasks Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 800);

        Color pink = new Color(250, 171, 182);
        Color blue = new Color(163, 255, 255);

        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BoxLayout(principalPanel, BoxLayout.Y_AXIS));
        principalPanel.setBackground(pink);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        topPanel.setBackground(pink);

        JPanel employeeSelectionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        employeeSelectionPanel.setBackground(pink);
        employeeSelectionPanel.add(employeeLabel);
        employeeSelectionPanel.add(empCombo);

        JPanel taskSelectionPanel = new JPanel();
        taskSelectionPanel.setLayout(new BoxLayout(taskSelectionPanel, BoxLayout.Y_AXIS));
        taskSelectionPanel.setBackground(pink);

        tasksCheckPanel.setLayout(new BoxLayout(tasksCheckPanel, BoxLayout.Y_AXIS));
        tasksCheckPanel.setBackground(blue);

        JScrollPane tasksScrollPane = new JScrollPane(tasksCheckPanel);
        tasksScrollPane.setPreferredSize(new Dimension(220, 120));

        taskSelectionPanel.add(tasksLabel);
        taskSelectionPanel.add(Box.createVerticalStrut(5));
        taskSelectionPanel.add(tasksScrollPane);

        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new BoxLayout(actionsPanel, BoxLayout.Y_AXIS));
        actionsPanel.setBackground(pink);
        actionsPanel.add(assignTaskToEmployee);
        actionsPanel.add(Box.createVerticalStrut(10));
        actionsPanel.add(modifyStatus);

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setBackground(pink);
        taskListDurationField.setEditable(false);
        taskListDurationField.setBackground(blue);

        JScrollPane detailsScroll = new JScrollPane(taskListDurationField);
        detailsScroll.setPreferredSize(new Dimension(350, 120));

        detailsPanel.add(detailsAboutEmployee);
        detailsPanel.add(Box.createVerticalStrut(5));
        detailsPanel.add(detailsScroll);

        topPanel.add(employeeSelectionPanel);
        topPanel.add(taskSelectionPanel);
        topPanel.add(actionsPanel);
        topPanel.add(detailsPanel);

        // ================= ADD EMPLOYEE PANEL =================
        JPanel addEmployeePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        addEmployeePanel.setBackground(pink);
        addEmployeePanel.add(employeeNameLabel);
        addEmployeePanel.add(employeeField);
        addEmployeePanel.add(addEmployee);

        // ================= TASK PANEL =================
        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        taskPanel.setBackground(pink);
        taskPanel.setBorder(BorderFactory.createTitledBorder("Task Management"));

        JPanel simpleTaskPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        simpleTaskPanel.setBackground(pink);
        simpleTaskPanel.add(statusLabel);
        simpleTaskPanel.add(statusBox);
        simpleTaskPanel.add(startHourLabel);
        simpleTaskPanel.add(startField);
        simpleTaskPanel.add(endHourLabel);
        simpleTaskPanel.add(endField);
        simpleTaskPanel.add(addSimpleTask);

        JPanel complexTaskPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        complexTaskPanel.setBackground(pink);

        complexTasksCheckPanel.setLayout(new BoxLayout(complexTasksCheckPanel, BoxLayout.Y_AXIS));
        complexTasksCheckPanel.setBackground(blue);

        JScrollPane complexTasksScrollPane = new JScrollPane(complexTasksCheckPanel);
        complexTasksScrollPane.setPreferredSize(new Dimension(220, 120));

        complexTaskPanel.add(addComplexTask);
        complexTaskPanel.add(complexTasksLabel);
        complexTaskPanel.add(complexTasksScrollPane);

        taskPanel.add(simpleTaskPanel);
        taskPanel.add(complexTaskPanel);

        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
        infoPanel.setBackground(pink);

        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
        filterPanel.setBackground(pink);
        filterField.setEditable(false);
        filterField.setBackground(blue);
        JScrollPane filterScroll = new JScrollPane(filterField);
        filterScroll.setPreferredSize(new Dimension(320, 120));
        filterPanel.add(filterAndSort);
        //filterPanel.add(Box.createVerticalStrut(5));
        filterPanel.add(filterScroll);

        JPanel statisticsPanel = new JPanel();
        statisticsPanel.setLayout(new BoxLayout(statisticsPanel, BoxLayout.Y_AXIS));
        statisticsPanel.setBackground(pink);
        statisticsField.setEditable(false);

        statisticsField.setBackground(blue);
        JScrollPane statisticsScroll = new JScrollPane(statisticsField);
        statisticsPanel.add(statistics);
        statisticsPanel.add(statisticsScroll);

        infoPanel.add(filterPanel);
        infoPanel.add(statisticsPanel);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottomPanel.setBackground(pink);
        bottomPanel.add(clearBtn);
        bottomPanel.add(saveBtn);

        employeeField.setBackground(blue);
        startField.setBackground(blue);
        endField.setBackground(blue);

        principalPanel.add(topPanel);
        principalPanel.add(addEmployeePanel);
        principalPanel.add(taskPanel);
        principalPanel.add(infoPanel);
        principalPanel.add(bottomPanel);

        add(principalPanel);
        setVisible(true);
    }

    public void setAddEmployeeListener(ActionListener listener) {
        addEmployee.addActionListener(listener);
    }

    public void setAddSaveListener(ActionListener listener) {
        saveBtn.addActionListener(listener);
    }

    public void setAddSimpleTaskListener(ActionListener listener) {
        addSimpleTask.addActionListener(listener);
    }

    public void setAddComplexTaskListener(ActionListener listener) {
        addComplexTask.addActionListener(listener);
    }

    public void setAssignTaskListener(ActionListener listener) {
        assignTaskToEmployee.addActionListener(listener);
    }

    public void setModifyStatusListener(ActionListener listener) {
        modifyStatus.addActionListener(listener);
    }

    public void setFilterAndSortListener(ActionListener listener) {
        filterAndSort.addActionListener(listener);
    }

    public void setStatisticsListener(ActionListener listener) {
        statistics.addActionListener(listener);
    }

    public void setClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }

    public String getEmployeeInput() {
        return employeeField.getText();
    }

    public Task.TaskStatus getSelectedStatus() {
        return (Task.TaskStatus) statusBox.getSelectedItem();
    }

    public String getStartInput() {
        return startField.getText();
    }

    public String getEndInput() {
        return endField.getText();
    }

    public void clearEmployeeField() {
        employeeField.setText("");
    }

    public void clearTaskFields() {
        startField.setText("");
        endField.setText("");
        statusBox.setSelectedIndex(0);

        for (JCheckBox checkBox : taskCheckBoxes) {
            checkBox.setSelected(false);
        }

        for (JCheckBox checkBox : complexTaskCheckBoxes) {
            checkBox.setSelected(false);
        }
    }

    public void addEmployeeToCombo(Employee employee) {
        empCombo.addItem(employee);
    }


    public void repaint(List<Task> t){
        for (int i = 0; i < taskCheckBoxes.size() && i < t.size(); i++) {
            taskCheckBoxes.get(i).setText(t.get(i).toString());
        }
        tasksCheckPanel.revalidate();
        tasksCheckPanel.repaint();

        for (int i = 0; i < complexTaskCheckBoxes.size() && i < t.size(); i++) {
            complexTaskCheckBoxes.get(i).setText(t.get(i).toString());
        }
        complexTasksCheckPanel.revalidate();
        complexTasksCheckPanel.repaint();


    }
    public void addTaskToCheckBoxes(Task task) {
        JCheckBox topCheckBox = new JCheckBox(task.toString());
        topCheckBox.setBackground(new Color(163, 255, 255));
        taskCheckBoxes.add(topCheckBox);
        taskListForTopPanel.add(task);
        tasksCheckPanel.add(topCheckBox);

        JCheckBox complexCheckBox = new JCheckBox(task.toString());
        complexCheckBox.setBackground(new Color(163, 255, 255));
        complexTaskCheckBoxes.add(complexCheckBox);
        taskListForComplexPanel.add(task);
        complexTasksCheckPanel.add(complexCheckBox);

        tasksCheckPanel.revalidate();
        tasksCheckPanel.repaint();

        complexTasksCheckPanel.revalidate();
        complexTasksCheckPanel.repaint();
    }


    public Employee getSelectedEmployee() {
        return (Employee) empCombo.getSelectedItem();
    }

    public ArrayList<Task> getSelectedTask() {
        ArrayList<Task> selectedTasks = new ArrayList<>();

        for (int i = 0; i < taskCheckBoxes.size(); i++) {
            if (taskCheckBoxes.get(i).isSelected()) {
                selectedTasks.add(taskListForTopPanel.get(i));
            }
        }

        return selectedTasks;
    }



    public ArrayList<Task> getSelectedTasksForComplexTask() {
        ArrayList<Task> selectedTasks = new ArrayList<>();

        for (int i = 0; i < complexTaskCheckBoxes.size(); i++) {
            if (complexTaskCheckBoxes.get(i).isSelected()) {
                selectedTasks.add(taskListForComplexPanel.get(i));
            }
        }

        return selectedTasks;
    }

    public void setTaskListDurationField(String text) {
        taskListDurationField.setText(text);
    }

    public void setFilterField(String text) {
        filterField.setText(text);
    }

    public void setStatisticsField(String text) {
        statisticsField.setText(text);
    }

    public void clearAll() {
        employeeField.setText("");
        startField.setText("");
        endField.setText("");
        taskListDurationField.setText("");
        filterField.setText("");
        statisticsField.setText("");
        empCombo.removeAllItems();

        taskCheckBoxes.clear();
        taskListForTopPanel.clear();
        tasksCheckPanel.removeAll();

        complexTaskCheckBoxes.clear();
        taskListForComplexPanel.clear();
        complexTasksCheckPanel.removeAll();

        statusBox.setSelectedIndex(0);
        tasksCheckPanel.revalidate();
        tasksCheckPanel.repaint();

        complexTasksCheckPanel.revalidate();
        complexTasksCheckPanel.repaint();
    }
}