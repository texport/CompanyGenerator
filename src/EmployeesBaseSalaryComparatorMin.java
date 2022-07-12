import java.util.Comparator;

public class EmployeesBaseSalaryComparatorMin implements Comparator<Employees> {
    @Override
    public int compare(Employees o1, Employees o2) {
        return (int)(o1.getMonthSalary() - o2.getMonthSalary());
    }
}