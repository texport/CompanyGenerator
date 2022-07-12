import java.util.Comparator;

public class EmployeesBaseSalaryComparatorMax implements Comparator<Employees> {
    @Override
    public int compare(Employees o1, Employees o2) {
        return (int)(o2.getMonthSalary() - o1.getMonthSalary());
    }
}