import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamOperations {


    public List<Student> studentList(){

        List<Student> list = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));

        return list;
    }


    public void getStudentWithA(){

        studentList().stream().filter(s-> s.getFirstName().startsWith("A")).collect(Collectors.toList()).forEach(System.out::println);


    }

    public void getStudentsBydept(){

        System.out.println(studentList().stream().collect(Collectors.groupingBy(Student::getDepartmantName)));
    }

    public void totalCountOfStudent(){
      long i=  studentList().stream().count();
        System.out.println(i);
    }

    public void maxAgeStudent(){
        int i= studentList().stream().map(Student::getAge).max(Integer::compareTo).get();
        System.out.println(i);

    }

    public void getDeptName(){

        System.out.println(studentList().stream().map(Student::getDepartmantName).distinct().collect(Collectors.toList()));
    }

    public void getStudentCountDept(){

        System.out.println(studentList().stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting())));
    }

    public void getstudentLessthan30(){

        studentList().stream().filter(s-> s.getAge() < 30).collect(Collectors.toList()).forEach(System.out::println);
    }

    public void avgAgeFemalMaleStudent(){

        System.out.println(studentList().stream().collect(Collectors.groupingBy(Student::getGender,Collectors.averagingInt(Student::getAge))));
    }

    public void getListRank(){

        studentList().stream().filter(s-> 50 < s.getRank() &&  s.getRank() <100).collect(Collectors.toList()).forEach(System.out::println);
    }

    public void getDeptMaxNoStudent(){

        System.out.println(studentList().stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue()).get());
    }

    public void avgRankAllDept(){
        System.out.println(studentList().stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.averagingInt(Student::getRank))));
    }

    public void highestRankByDept(){

        System.out.println(studentList().stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.maxBy(Comparator.comparing(Student::getRank)))));
    }

    public void sortStudentByRank(){

        studentList().stream().sorted(Comparator.comparing(Student::getRank)).forEach(System.out::println);
    }

    public void secondHighestRank(){

      Student i=  studentList().stream().sorted(Comparator.comparing(Student::getRank).reversed()).skip(1).findFirst().get();
        System.out.println(i);
    }
}
