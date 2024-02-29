import java.util.HashSet;
import java.util.Set;

public abstract class Employee {
    private String name;
    private int employeeId;
    private int age;
    private boolean active;
    private Set<Skill> skills;
    protected Set<Project> projects;

    public Employee(String name, int employeeId, int age, Set<Skill> skills) {
        this.name = name;
        this.employeeId = employeeId;
        this.age = age;
        this.skills = skills;
        this.active = true;
        this.projects = new HashSet<>();
    }

    public boolean assign(Project project) {
        return projects.add(project);
    }
    public boolean leave(Project project) {
        return projects.remove(project);
    }

    public abstract String role();

    public String getName() {
        return name;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public int getAge() {
        return age;
    }
    public boolean getActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public Set<Skill> getSkills() {
        return skills;
    }
    public Set<Project> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "Employee {"
                + "\n    name: " + name
                + "\n    employeeId: " + employeeId
                + "\n    age: " + age
                + "\n    active: " + active
                + "\n    skills: " + skills
                + "\n    projects: " + projects
                + "\n}";
    }
    @Override
    public boolean equals(Object other) {
        if(other != null && (other instanceof Employee))
            return employeeId == ((Employee)other).employeeId;
        else
            return false;
    }
}