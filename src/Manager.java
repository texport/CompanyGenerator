import java.util.Random;

public class Manager extends Employees
{
    int personalManagerInCome;

    public Manager(Double baseSalary, int bonusesSalary, Company company){
        this.baseSalary = baseSalary;
        this.bonusesSalary = bonusesSalary;
        this.personalManagerInCome = setPersonalMangerInCome();
        this.company = company;
    }

    private int setPersonalMangerInCome() {
        Random random = new Random();
        return random.nextInt((140000 - 115000) + 1) + 115000;
    }

    private int getPersonalManagerInCome() {
        return personalManagerInCome;
    }

    @Override
    public Double getMonthSalary() {
        return getBaseSalary() + ((getPersonalManagerInCome() / 100) * getBonusesSalary());
    }
}
