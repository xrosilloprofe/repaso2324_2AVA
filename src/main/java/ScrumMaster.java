import java.util.Set;

import java.util.Set;

public class ScrumMaster extends Employee{
    private int experience;
    public ScrumMaster(String name, int employeeId, int age, int experience){
        super(name,employeeId,age,
                Set.of(Skill.LEADERSHIP, Skill.COMMUNICATION, Skill.CRITICAL_THINKING));
        this.experience = experience;
    }
    public int getExperience(){
        return experience;
    }
    @Override
    public String role() {
        return "Scrum Master";
    }
    @Override
    public boolean assign(Project project){
        if (super.getProjects().isEmpty()){
            return super.getProjects().add(project);
        }
        return false;
    }
}