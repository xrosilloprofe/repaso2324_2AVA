import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class ManageEmployee implements IManageEmployee {
    private List<Employee> employees;

    public ManageEmployee() {
        this.employees = new ArrayList<>();
    }

    @Override
    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employees;
    }

    @Override
    public int count() {
        return employees.size();
    }

    @Override
    public void addAll(List<Employee> employees) {
        this.employees.addAll(employees);
    }


    public List<Employee> getDevelopersSortedAlphabetically() {
        List<Employee> developers = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getProjects().contains("Developer") && employee.isActive()) {
                developers.add(employee);
            }
        }
        Collections.sort(developers);
        return developers;
    }


    public List<Employee> getActiveEmployeesWithoutProjects() {
//        List<Employee> activeWithoutProjects = new ArrayList<>();
//        for (Employee employee : employees) {
//            if (employee.isActive() && employee.getProjects().isEmpty()) {
//                activeWithoutProjects.add(employee);
//            }
//        }
//        return activeWithoutProjects;
//
        return employees.stream().
                filter(employee -> employee.isActive()
                        && employee.projects.isEmpty()).
                collect(Collectors.toList());

    }

    public void saveCSV() throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("ejemplo.csv"))){
            for(Employee employee:employees){
                bw.write(employee.getEmployeeId() +";"+employee.getName()+";"+employee.getAge());
                bw.newLine();
            }
        }
    }

    public List<Employee> load() throws IOException, ClassNotFoundException{
        List<Employee> aux = new ArrayList<>();
        try(ObjectInputStream obj = new ObjectInputStream(new FileInputStream("hola.dat"))){
            aux.add((Employee) obj.readObject());
            //HACEDLO
        }
        return aux;
    }


}