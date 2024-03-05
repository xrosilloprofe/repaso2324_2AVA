import java.util.LinkedHashSet;
import java.util.Set;

public class ProductManager extends Employee{
    private Integer clients;

    public ProductManager(String name, int employeeId, int age, Integer clients){
        super(name, employeeId, age,
                Set.of(Skill.COMMUNICATION, Skill.WORK_ETHIC, Skill.LEADERSHIP));
        this.clients = clients;
    }

    public Integer getClients() {
        return clients;
    }

    @Override
    public boolean leave(Project project){
        if (getSkills().size()==0){
            return false;
        }
       getSkills().remove(project);
        return true;
    }

    @Override
    public String role(){
        return "Product Manager";
    }
}
