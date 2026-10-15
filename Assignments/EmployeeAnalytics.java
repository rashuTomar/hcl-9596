
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeAnalytics {
        record Employee(int id, String name, String dept, BigDecimal salary,
                        LocalDate hireDate, Set<String> skills) {
        }

        static Employee e(int id, String n, String d, int sal, String date, String... skills) {
                return new Employee(id, n, d, BigDecimal.valueOf(sal),
                                LocalDate.parse(date), Set.of(skills));
        }

        public static void main(String[] args) {
                List<Employee> emps = List.of(
                                e(1, "Asha", "Engineering", 90000, "2019-03-01", "Java", "SQL"),
                                e(2, "Ravi", "Engineering", 120000, "2016-07-15", "Java", "Spring", "AWS"),
                                e(3, "Meera", "HR", 60000, "2020-01-10", "Recruiting"),
                                e(4, "John", "Sales", 70000, "2018-11-20", "Negotiation", "CRM"),
                                e(5, "Priya", "Engineering", 105000, "2021-05-05", "Java", "React"),
                                e(6, "Karan", "Sales", 65000, "2022-02-14", "CRM"),
                                e(7, "Sara", "HR", 62000, "2017-09-09", "Recruiting", "Payroll"),
                                e(8, "Vikram", "Finance", 80000, "2015-04-30", "Excel", "SQL"));

                // ANSWER 1
                // Names of Engineering employees, sorted by salary descending
                List<String> engineeringEmployees = emps.stream()
                                .filter(e -> "Engineering".equalsIgnoreCase(e.dept()))
                                .sorted(Comparator.comparing(Employee::salary).reversed())
                                .map(Employee::name)
                                .collect(Collectors.toList());

                System.out.println(
                                "Names of Engineering employees, sorted by salary descending: " + engineeringEmployees);

                // ANSWER 2
                // Names of the top 3 earners overall
                List<String> top3Earners = emps.stream()
                                .sorted(Comparator.comparing(Employee::salary).reversed())
                                .limit(3)
                                .map(Employee::name)
                                .collect(Collectors.toList());

                System.out.println("Names of the top 3 earners overall: " + top3Earners);

                // ANSWER 3
                // Employees hired before 2018-01-01, oldest hire first, as "name (year)"
                // strings
                List<String> employeesHiredBefore2018 = emps.stream()
                                .filter(e -> e.hireDate().isBefore(LocalDate.parse("2018-01-01")))
                                .sorted(Comparator.comparing(Employee::hireDate))
                                .map(e -> e.name() + " (" + e.hireDate().getYear() + ")")
                                .collect(Collectors.toList());

                System.out.println("Employees hired before 2018-01-01: " + employeesHiredBefore2018);

                // ANSWER 4
                // All names joined as "Asha, Ravi, ..." using Collectors.joining
                String joinedNames = emps.stream()
                                .map(Employee::name)
                                .collect(Collectors.joining(", "));

                System.out.println("All names joined: " + joinedNames);

                // LEVEL 2
                // ANSWER 5
                // Total payroll as a BigDecimal using reduce (not a loop)
                BigDecimal totalPayroll = emps.stream()
                                .map(Employee::salary)
                                .reduce(BigDecimal.ZERO, BigDecimal::add);

                System.out.println("Total payroll: " + totalPayroll);

                // ANSWER 6
                // anyMatch skill "AWS"? allMatch salary > 50000? noneMatch salary > 150000?
                boolean anySkillAws = emps.stream()
                                .anyMatch(e -> e.skills().contains("AWS"));

                boolean allSalaryAbove50k = emps.stream()
                                .allMatch(e -> e.salary().compareTo(BigDecimal.valueOf(50000)) > 0);

                boolean noneSalaryAbove150k = emps.stream()
                                .noneMatch(e -> e.salary().compareTo(BigDecimal.valueOf(150000)) > 0);

                System.out.println("anyMatch skill 'AWS'?: " + anySkillAws);
                System.out.println("allMatch salary > 50000?: " + allSalaryAbove50k);
                System.out.println("noneMatch salary > 150000?: " + noneSalaryAbove150k);

                // ANSWER 7
                // The highest-paid employee as an Optional; print the name or "none"
                Optional<Employee> highestPaidEmployee = emps.stream()
                                .max(Comparator.comparing(Employee::salary));

                String highestPaidName = highestPaidEmployee
                                .map(Employee::name)
                                .orElse("none");

                System.out.println("Highest-paid employee: " + highestPaidName);

                // LEVEL 3
                // ANSWER 8
                // Average salary per department (groupingBy + averagingDouble)
                Map<String, Double> avgSalaryPerDept = emps.stream()
                                .collect(Collectors.groupingBy(
                                                Employee::dept,
                                                Collectors.averagingDouble(e -> e.salary().doubleValue())));

                System.out.println("Average salary per department: " + avgSalaryPerDept);

                // ANSWER 9
                // Highest-paid employee name per department (maxBy + collectingAndThen)
                Map<String, String> highestPaidPerDept = emps.stream()
                                .collect(Collectors.groupingBy(
                                                Employee::dept,
                                                Collectors.collectingAndThen(
                                                                Collectors.maxBy(Comparator.comparing(Employee::salary)),
                                                                opt -> opt.map(Employee::name).orElse("none"))));

                System.out.println("Highest-paid employee name per department: " + highestPaidPerDept);

                // ANSWER 10
                // Partition by salary >= 75000
                Map<Boolean, List<Employee>> partitionedBySalary = emps.stream()
                                .collect(Collectors.partitioningBy(
                                                e -> e.salary().compareTo(BigDecimal.valueOf(75000)) >= 0));

                System.out.println("Partition by salary >= 75000: " + partitionedBySalary);

                // LEVEL 4
                // ANSWER 11
                // Sorted list of distinct skills across all employees
                List<String> distinctSortedSkills = emps.stream()
                                .flatMap(e -> e.skills().stream())
                                .distinct()
                                .sorted()
                                .collect(Collectors.toList());

                System.out.println("Sorted list of distinct skills across all employees: " + distinctSortedSkills);

                // ANSWER 12
                // Skill frequency map, then the most common skill
                Map<String, Long> skillFrequency = emps.stream()
                                .flatMap(e -> e.skills().stream())
                                .collect(Collectors.groupingBy(
                                                Function.identity(),
                                                Collectors.counting()));

                String mostCommonSkill = skillFrequency.entrySet().stream()
                                .max(Map.Entry.comparingByValue())
                                .map(Map.Entry::getKey)
                                .orElse("none");

                System.out.println("Skill frequency map: " + skillFrequency);
                System.out.println("Most common skill: " + mostCommonSkill);
        }

}