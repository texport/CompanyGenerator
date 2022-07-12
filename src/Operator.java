public class Operator extends Employees {
    public Operator(Double baseSalary, int bonusesSalary, Company company) {
        this.baseSalary = baseSalary;
        this.bonusesSalary = bonusesSalary;
        this.company = company;
    }

    @Override
    public Double getMonthSalary() {
        return getBaseSalary() + getBonusesSalary();
    }
}
