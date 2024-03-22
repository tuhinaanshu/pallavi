import java.util.*;
import java.util.stream.Collectors;

public class StreamOperations {
    public List<Employee> getEmpList(){
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hydrabad", 2015));
        empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013));
        empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee(7, "uvw", 22, 130, "F", "IT", "Pune", 2016));
        empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010));
        return empList;
    }

    public void groupByCity(){
        //Group the Employees by city
        Map<String, List<Employee>> empByCity;
        empByCity = getEmpList().stream()
                .collect( // collects
                        Collectors. // collects
                                groupingBy(// groups
                                Employee::getCity));
        System.out.println("Employees grouped by city :: \n" + empByCity);
    }

    //Group the employees by Age
    public void groupByAge() {

        Map<Integer, Long> empByAge = new HashMap<>();
        empByAge = getEmpList().stream().collect(Collectors.groupingBy(Employee::getAge,Collectors.counting()));
        System.out.println("Employee by age ::" + empByAge);
    }

    public void countOfMaleFemale(){

        Map<String,Long> noOfMaleFemale;
        noOfMaleFemale= getEmpList().stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println(noOfMaleFemale);
    }
















    public void getCountByCity(){

        Map<String,Long> getCountCity= new HashMap<>();
        getCountCity= getEmpList().stream().collect(Collectors.groupingBy(Employee::getCity,Collectors.counting()));
        System.out.println(getCountCity);
    }


    public void getAllDepart(){

        getEmpList().stream().map(Employee::getDeptName).distinct().forEach(System.out::println);
    }

    public void ageGreater28(){ //print emp details greater than 28 age

        List<Employee> detailEmp= getEmpList().stream().filter(s-> s.getAge() > 28).collect(Collectors.toList());
        //System.out.println(detailEmp);
        detailEmp.forEach(System.out::println);

    }

    public void maxAge(){

        int maxAgeEmp= getEmpList().stream().map(Employee::getAge).max(Integer::compare).get();
       // System.out.println(getEmpList().stream().mapToInt(Employee::getAge).max())   ;
        System.out.println(maxAgeEmp);
    }

    public void avgMaleFemaleEmpAge(){

        Map<String,Double>avgMaleFemaleEmp;
        avgMaleFemaleEmp= getEmpList().stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
        System.out.print(avgMaleFemaleEmp);
    }

    public void noOfEmpByDept(){
        Map<String ,Long> noOfEmpDept;
        noOfEmpDept=   getEmpList().stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting()));
        System.out.println("No of employees in each department");
        for (Map.Entry<String,Long> entry : noOfEmpDept.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }

    public void oldestEmployee(){
        Employee employee=  getEmpList().stream().max(Comparator.comparing(Employee::getAge)).get();
        System.out.println(employee);
    }

    public void youngFemale(){

        Employee youngFemale= getEmpList().stream().filter(s-> s.getGender().equalsIgnoreCase("F")).min(Comparator.comparing(Employee::getAge)).get();
        System.out.println(youngFemale);

    }



    public void greaterThan30andLessThan30(){

      //  List<Employee> employeeListgreatThan30= getEmpList().stream().filter(s->  s.getAge() >30).toList();


//        List<Employee> employeeListLessThan30= getEmpList().stream().filter(s->  s.getAge() <30).toList();
//        System.out.println(employeeListLessThan30);
//        System.out.println(employeeListgreatThan30);

        System.out.println("Employees whose age is greater than 30 and less than 30");
        Map<Boolean, List<Employee>> partitionEmployeesByAge =
                getEmpList().stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30));

        partitionEmployeesByAge.get(true).forEach(System.out::println);

        partitionEmployeesByAge.get(false).forEach(System.out::println);

    }

    public void getDeptNameForHighestEmpNo(){

        Map<String,Long> deptName= getEmpList().stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting()));
        System.out.println( deptName.entrySet().stream().max(Map.Entry.comparingByValue()).get());
       // System.out.println(
    }

    public void ifEmpPresentHR(){

        /*long isPresent= getEmpList().stream().filter(s-> s.getDeptName().equalsIgnoreCase("Hr")).collect(Collectors.counting());
        if (isPresent > 0){
            System.out.println("HR dept is there");*/
    //}

        Optional<Employee> emp= getEmpList().stream().filter(w-> w.getDeptName().equalsIgnoreCase("HR"))
                .findAny();
        emp.ifPresent(employee -> System.out.println("Found employees from HR department " + employee));

    }


    public void departmentOver3(){
         getEmpList().stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting())).
        entrySet().stream().filter(entry -> entry.getValue() > 3).forEach(System.out::println);

    }

    public void getDistinctDeptName(){
        getEmpList().stream().map(Employee::getDeptName).distinct().collect(Collectors.toList()).forEach(System.out::println);

    }

    public void getBlrEmp(){
      getEmpList().stream().filter(s-> s.getCity().equalsIgnoreCase("Blore")).sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList()).forEach(System.out::println);


    }

    public void totalEmp(){

       long total= getEmpList().stream().count();
        System.out.println(total);
    }

    public void totalEmpDept(){

        System.out.println(getEmpList().stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting())));


    }

    public  void highestEmp(){

        Optional<Map.Entry<String, Long>> i= getEmpList().stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue());

        if(i.isPresent()){
            System.out.println(i.get());
        }
    }

    public void sortAgeNAme(){

        getEmpList().stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge)).collect(Collectors.toList()).forEach(System.out::println);

    }

    public void highExpEmp(){

        System.out.println(getEmpList().stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst().get());
    }


    public void avgTotalSalary(){

        DoubleSummaryStatistics swq= getEmpList().stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(swq.getSum());
        System.out.println(swq.getAverage());
    }

    //ques 23
    public void avgSalaryByDept(){
        Map<String,Double> avgsalaryDept= getEmpList().stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgsalaryDept);
    }
}











