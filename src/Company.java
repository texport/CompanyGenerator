import java.util.*;

public class Company {
    String companyName;
    int inCome;
    Map<Employees, String> employeesList = new HashMap<>();

    public Company(String companyName) {
        this.companyName = companyName;
        this.inCome = setInCome();
    }

    public void hire(String employeesType, Double baseSalary, int bonusesSalary, Company company){
        if ("1".equals(employeesType)) {
            employeesList.put(new Operator(baseSalary, bonusesSalary, company), employeesType);
        } else if ("2".equals(employeesType)) {
            employeesList.put(new Manager(baseSalary, bonusesSalary, company), employeesType);
        } else if ("3".equals(employeesType)) {
            employeesList.put(new TopManager(baseSalary, bonusesSalary, company), employeesType);
        }
    }

    public void hireAll(String employeesType, int countEmployees, Double baseSalary, int bonusesSalary, Company company){
        if ("1".equals(employeesType)) {
            for (int i = 0; i < countEmployees; i++) {
                employeesList.put(new Operator(baseSalary, bonusesSalary, company), employeesType);
            }
        } else if ("2".equals(employeesType)) {
            for (int i = 0; i < countEmployees; i++) {
                employeesList.put(new Manager(baseSalary, bonusesSalary, company), employeesType);
            }
        } else if ("3".equals(employeesType)) {
            for (int i = 0; i < countEmployees; i++) {
                employeesList.put(new TopManager(baseSalary, bonusesSalary, company), employeesType);
            }
        }
    }

    public void fire(String employeesType, int countEmployees)
    {
        ArrayList<Employees> tempEmployees = findKeysByValueForEmployees(employeesList, employeesType);

        if (countEmployees <= tempEmployees.size()) {
            for (int i = 0; i < countEmployees; i++) {
                employeesList.remove(tempEmployees.get(i));
            }
        }
        else {
            System.out.println("У вас нет стольких сотрудников");
        }
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getInCome() {
        return inCome;
    }

    private int setInCome() {
        Random random = new Random();
        return random.nextInt((50000000 - 10000000) + 1) + 10000000;
    }

    public List<Employees> getTopSalaryStaff(String employeesType, int count){
        Comparator<Employees> tempComparator = new EmployeesBaseSalaryComparatorMax();
        List<Employees> tempEmployees = findKeysByValueForEmployees(employeesList, employeesType);
        tempEmployees.sort(tempComparator);

        if (tempEmployees.size() > count) {
            tempEmployees.subList(count, tempEmployees.size()).clear();
        }
        return tempEmployees;
    }

    public List<Employees> getLowestSalaryStaff(String employeesType, int count){
        Comparator<Employees> tempComparator = new EmployeesBaseSalaryComparatorMin();
        List<Employees> tempEmployees = findKeysByValueForEmployees(employeesList, employeesType);
        tempEmployees.sort(tempComparator);

        for (int i = tempEmployees.size(); i > count; i--)
        {
            tempEmployees.remove(i - 1);
        }
        return tempEmployees;
    }

    // Служебный, ищем ключ по значению в Сотрудниках
    private static ArrayList<Employees> findKeysByValueForEmployees(Map<Employees, String> map, String value){
        ArrayList<Employees> result = new ArrayList<>();
        if (map.containsValue(value)){
            for (Map.Entry<Employees, String> entry : map.entrySet()){
                if (Objects.equals(entry.getValue(), value)){
                    result.add(entry.getKey());
                }
            }
        }
        return result;
    }

    public Map<Employees, String> getEmployeesList() {
        return employeesList;
    }
}