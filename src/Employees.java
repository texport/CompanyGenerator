import java.util.Comparator;

public abstract class Employees implements Salary
{
    double baseSalary;
    int bonusesSalary;

    Company company;

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getBonusesSalary() {
        return bonusesSalary;
    }

    public Company getCompany() {
        return company;
    }
}
