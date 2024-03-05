import java.util.List;

public interface IManageEmployee {

    void add (Employee e);
    List<Employee> getAll();
    int count();
    void addAll(List<Employee> employees);
}