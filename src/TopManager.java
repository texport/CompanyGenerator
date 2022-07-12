import java.util.Random;

public class TopManager extends Employees
{
    public TopManager(Double baseSalary, int bonusesSalary, Company company){
        this.baseSalary = baseSalary;
        this.bonusesSalary = bonusesSalary;
        this.company = company;
    }

    @Override
    public Double getMonthSalary() {
        if (company.getInCome() >= 10000000) {
            return getBaseSalary() + ((company.getInCome() / 100) * getBonusesSalary());
        }
        else{
            return getBaseSalary();
        }
    }
}
