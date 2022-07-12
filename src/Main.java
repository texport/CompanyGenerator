import java.util.*;

public class Main {
    static Map<Company, String> companyList = new HashMap<>();
    static Company company = null;

    public static void main(String[] args) {
        String text;

        while (true)
        {
            System.out.println("""
                Что вы хотите сделать:
                1: Создать компанию
                2: Управлять компанией""");
            text = getText();

            switch (text){
                case "1" -> {
                    System.out.println("------------------------");
                    System.out.println("Давайте создадим компанию\n" +
                            "Введите имя компании");
                    System.out.println("Вы создали компанию " + companyList.get(createCompany(getText())));
                    System.out.println("------------------------");
                }
                case "2" -> {
                    System.out.println("Введите имя компании");
                    text = getText();

                    if (findKeysByValueForCompany(companyList, text) != null) {
                        company = findKeysByValueForCompany(companyList, text);
                        System.out.println("------------------------");
                        System.out.println("Вы управляете компанией " + company.getCompanyName());
                        System.out.println("------------------------");
                    }
                    else {
                        System.out.println("Нет такой компании!");
                        break;
                    }

                    while (true)
                    {
                        System.out.println("""
                        ------------------------
                        Что вы хотите сделать:
                        1: Нанять одного сотрудника
                        2: Нанять много сотрудников
                        3: Уволить сотрудников
                        4: Узнать сколько сотрудников работает
                        5: Узнать список самых маленьких зарплат
                        6: Узнать список самых больших зарплат
                        7: Узнать какой доход у компании
                        0: Назад
                        ------------------------""");

                        text = getText();

                        if ("1".equals(text)) {
                            System.out.println("""
                                    ------------------------
                                    Выбирите тип сотрудника:
                                    1 - оператор
                                    2 - менеджер
                                    3 - топ менеджер
                                    ------------------------""");
                            String typeEmployees = getText();

                            System.out.println("Какую базовую зарплату установим?");
                            Double baseSalary = Double.parseDouble(getText());

                            System.out.println("Какой бонус зададим?");
                            int bonusesSalary = Integer.parseInt(getText());

                            if (company != null) {
                                company.hire(typeEmployees, baseSalary, bonusesSalary, company);
                                System.out.println(findKeysByValueForEmployees(company.getEmployeesList(), typeEmployees));
                            }
                        }
                        else if ("2".equals(text)) {
                            System.out.println("""
                                    ------------------------
                                    Выбирите тип сотрудника:
                                    1 - оператор
                                    2 - менеджер
                                    3 - топ менеджер
                                    ------------------------""");
                            String typeEmployees = getText();

                            System.out.println("Какое кол-во вы хотите нанять?");
                            int countEmployees = Integer.parseInt(getText());

                            System.out.println("Какую базовую зарплату установим?");
                            Double baseSalary = Double.parseDouble(getText());

                            System.out.println("Какой бонус зададим?");
                            int bonusesSalary = Integer.parseInt(getText());

                            if (company != null) {
                                company.hireAll(typeEmployees, countEmployees, baseSalary, bonusesSalary, company);
                                System.out.println("Вы наняли - " + countEmployees + " сотрудников");
                            }
                        }
                        else if ("3".equals(text)) {
                            System.out.println("""
                                    ------------------------
                                    Выбирите тип сотрудника:
                                    1 - оператор
                                    2 - менеджер
                                    3 - топ менеджер
                                    ------------------------""");
                            String typeEmployees = getText();

                            System.out.println("Какое кол-во вы хотите уволить?");
                            int countEmployees = Integer.parseInt(getText());

                            if (company != null) {
                                company.fire(typeEmployees, countEmployees);
                                System.out.println("Вы уволили - " + countEmployees + " сотрудников");
                            }
                        }
                        else if ("4".equals(text)) {
                            System.out.println("Сейчас в компании работает - " + company.getEmployeesList().size());
                        }
                        else if ("5".equals(text)) {
                            System.out.println("""
                                    ------------------------
                                    Выбирите тип сотрудника:
                                    1 - оператор
                                    2 - менеджер
                                    3 - топ менеджер
                                    ------------------------""");
                            String typeEmployees = getText();

                            System.out.println("Какое вывести зарплат?");
                            int countEmployees = Integer.parseInt(getText());

                            if (company != null) {
                                List<Employees> tempEmployees = company.getLowestSalaryStaff(typeEmployees, countEmployees);

                                for (Employees tempEmployee : tempEmployees) {
                                    System.out.println(tempEmployee.getMonthSalary());
                                }
                            }
                        }
                        else if ("6".equals(text)) {
                            System.out.println("""
                                    ------------------------
                                    Выбирите тип сотрудника:
                                    1 - оператор
                                    2 - менеджер
                                    3 - топ менеджер
                                    ------------------------""");
                            String typeEmployees = getText();

                            System.out.println("Какое вывести зарплат?");
                            int countEmployees = Integer.parseInt(getText());

                            if (company != null) {
                                List<Employees> tempEmployees = company.getTopSalaryStaff(typeEmployees, countEmployees);

                                for (Employees tempEmployee : tempEmployees) {
                                    System.out.println(tempEmployee.getMonthSalary());
                                }
                            }
                        }
                        else if ("7".equals(text)) {
                            System.out.print("Доход компании " + company.getCompanyName() + " - ");
                            System.out.format("%,8d%n", company.getInCome());
                        }
                        else if ("0".equals(text)) {
                            System.out.println("Назад");
                            break;
                        }
                    }
                }
            }
        }
    }

    // Создаем компанию
    private static Company createCompany(String companyName) {
        Company company = new Company(companyName);
        companyList.put(company, companyName);
        return company;
    }

    // Служебный, ищем ключ по значению в Компаниях
    private static Company findKeysByValueForCompany(Map<Company, String> map, String value)
    {
        Company result = null;
        if (map.containsValue(value))
        {
            for (Map.Entry<Company, String> entry : map.entrySet())
            {
                if (Objects.equals(entry.getValue(), value))
                {
                    result = entry.getKey();
                }
            }
        }
        return result;
    }

    // Служебный, ищем ключ по значению в Сотрудниках
    private static HashSet<Employees> findKeysByValueForEmployees(Map<Employees, String> map, String value)
    {
        HashSet<Employees> result = new HashSet<>();
        if (map.containsValue(value))
        {
            for (Map.Entry<Employees, String> entry : map.entrySet())
            {
                if (Objects.equals(entry.getValue(), value))
                {
                    result.add(entry.getKey());
                }
            }
        }
        return result;
    }

    // Читаем ввод с консоли
    private static String getText()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}