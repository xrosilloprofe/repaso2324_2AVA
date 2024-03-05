import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Developer jaime = new Developer("jaime",1,35, Set.of(Skill.LEADERSHIP));
        Developer matthew = new Developer("matthew",2,41,Set.of(Skill.COMMUNICATION));
        ProductManager alex = new ProductManager("alex",3,51,3);
        ScrumMaster marcos = new ScrumMaster("marcos",4,43,20);

        Collection<Employee> employees = new ArrayList<>(List.of(jaime,matthew,marcos,alex));
        save(employees);
        load();
        saveEmployee(employees);
        loadEmployee();

    }

    public static void save(Collection<Employee> empleados){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("empleados.csv"))){
            for(Employee e:empleados){
                bw.write(e.getName() + ";" + e.getEmployeeId() + ";" + e.getAge());
                bw.newLine();
            }
        } catch (IOException e){
            System.err.println("Esto no funciona" + e.getMessage());;
        }
    }

    public static void load(){
        try(BufferedReader br = new BufferedReader(new FileReader("empleados.csv"))){
            String linea;
            while((linea=br.readLine())!=null){
                String[] lineaDividida = linea.split(";");
                System.out.println("Nombre: " + lineaDividida[0]);
                System.out.print("\tID: " + lineaDividida[1]);
                System.out.print("\tEdad: " + lineaDividida[2] + "\n");
            }
        } catch (IOException e){
        }
    }

    public static void saveEmployee(Collection<Employee> empleados){
        try(ObjectOutputStream ous = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("empleados.dat"))
        )){
//            for(Employee e:empleados)
//                ous.writeObject(e);
            ous.writeObject(empleados);
        } catch (IOException e){
        }
    }

    public static void loadEmployee(){
        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("empleados.dat")
        )){
            Collection<Employee> employees = (Collection<Employee>)
                    ois.readObject();
            System.out.println(employees);
        } catch (IOException e){

        } catch (ClassNotFoundException e){

        }
    }


}
