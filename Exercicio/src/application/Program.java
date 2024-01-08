package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        List<Employee> list = new ArrayList<>();

        System.out.print("Quantos colaboradores serão registrado? ");
        int n = sc.nextInt();

        for (int i=0; i<n; i++){
            System.out.println("Employee #" + (i+1) + ":");
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            while (verificarId(list, id)){
                System.out.println("Esse Id já existe, tente novamente!!!");
                id = sc.nextInt();
            }
            System.out.println("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Salary: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id,name,salary);
            list.add(emp);
        }

        System.out.println("Entre com o Id do colaborador que terá o seu salário aumentado: ");
        int idSalary = sc.nextInt();

        Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);

        if(emp == null){
            System.out.println("Esse Id não existe");
        }
        else{
            System.out.println("Entre com a porcentagem: ");
            double porcentagem = sc.nextDouble();
            emp.increaseSalary(porcentagem);
        }

        System.out.println("Lista de colaboradores");
        for (Employee e : list){
            System.out.println(e);
        }
        sc.close();
    }

    public static boolean verificarId (List<Employee> list, int id){
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}
