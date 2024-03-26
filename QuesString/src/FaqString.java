import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FaqString {

//How do you reverse a given string in place? (solution)

    public void reverseString(){
        String str= "ABCD";
        List<String> strList= Arrays.stream(str.split("")).collect(Collectors.toList());
        System.out.println(strList);
        List<String> reversedList =   strList.stream().collect(Collectors.collectingAndThen(
                Collectors.toList(),
                lst -> {
                    Collections.reverse(lst);
                    return lst;
                }));

        System.out.println(reversedList);
    }

    //How do you print duplicate characters from a string?

    public void printDupString(){
        String str= "ABCDADFQQ";
        List<String> strList= Arrays.stream(str.split("")).collect(Collectors.toList());
        System.out.println(strList);
        Set<String> dupSet= new HashSet<>();
        strList.stream().filter(s-> !dupSet.add(s)).collect(Collectors.toList()).forEach(System.out::println);

    }

    //Count the number of I in India

    public void countNoOfI(){

       // String str="PALLAVI";
        String str= new String("pallavi");

        List<String> strList= Arrays.stream(str.split("")).collect(Collectors.toList());
        System.out.println(strList);
        Map<Character, Long> noOfChar =strList.stream().flatMap(a -> a.chars().mapToObj(c -> (char) c))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(noOfChar);
        System.out.println(noOfChar.get('I'));
        }



    }

