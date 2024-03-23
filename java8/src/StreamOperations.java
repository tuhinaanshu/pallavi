import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamOperations {
    public void getEvenNums(){

        List<Integer> integerList= Arrays.asList(1,2,3,4,5,6,8,78);
        integerList.stream().filter(a-> a%2 == 0).collect(Collectors.toList()).forEach(System.out::println);

    }

    public void getNumberwith1(){

        List<Integer> integerList= Arrays.asList(1,2,13,4,5,16,8,78);
        integerList.stream().map(s-> s + "").filter(a-> a.startsWith("1")).forEach(System.out::println);
    }

    public void findDuplicateNum(){

        List<Integer> integerList= Arrays.asList(1,2,13,4,5,16,8,78,1,13);
        Set<Integer> dupSet= new HashSet<>();
        integerList.stream().filter(s-> !dupSet.add(s)).forEach(System.out::println);
    }

    public void findFirstElementinList(){
        List<Integer> integerList= Arrays.asList(1,2,13,4,5,16,8,78,1,13);
       int i= integerList.stream().findFirst().get();
        System.out.println(i);


    }


    public void findCountElement(){
        List<Integer> integerList= Arrays.asList(1,2,13,4,5,16,8,78,1,13);
       long i= integerList.stream().count();
        System.out.println(i);

    }

    public void findMaxValueinStream(){

        List<Integer> integerList= Arrays.asList(1,2,13,4,5,16,8,78,1,13);
       int i= integerList.stream().max(Integer::compare).get();
        System.out.println(i);
    }

    public void sortElements(){

        List<Integer> integerList= Arrays.asList(1,2,13,4,5,16,8,78,1,13);
        integerList.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);
    }

    public void sortElementsdesc(){
        List<Integer> integerList= Arrays.asList(1,2,13,4,5,16,8,78,1,13);
        integerList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).forEach(System.out::println);

    }

    public void returnTrueFalse(){

        int [] intArray = new int[]{1,2,3,4};
        List<Integer> list = Arrays.stream(intArray)
                .boxed()
                .toList();
        Set<Integer> set = new HashSet<>(list);
        if(set.size() == list.size()) {
            System.out.println("False");

        }
         else {
            System.out.println("true");
        }
    }


    public void getCubeOfElement(){

        List<Integer> list= Arrays.asList(1,2,3,20,10);
        list.stream().filter(i-> (i * i * i )> 50).collect(Collectors.toList()).forEach(System.out::println);

    }

    public void sortArrayStream(){

        int arr[] = { 99, 55, 203, 99, 4, 91 };
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .toList();
        System.out.println(list);
        System.out.println(list.stream().sorted().collect(Collectors.toList()));
    }

    public void mapToUpperCase(){

        List<String> stringsList= Arrays.asList("aa","bb");
        stringsList.stream().map(i-> i.toUpperCase()).collect(Collectors.toList()).forEach(System.out::println);
    }

    public void countWord(){
        List<String> stringsList= Arrays.asList("aa","bb");
        long i= stringsList.stream().count();
        System.out.println(i);

    }

    public void countLetters(){

        List<String> stringsList= Arrays.asList("aa","bb");
        System.out.println(stringsList.stream().collect(
                Collectors.groupingBy(
                        Function.identity()
                        , Collectors.counting()
                )));
    }

    public void getDupCount(){

        List<String> stringsList= Arrays.asList("aa","bb","aa","bc","bc","bb","cv");
        Set<String> dupSet= new HashSet<>();
        long i=stringsList.stream().filter(s-> !dupSet.add(s)).count();
        System.out.println(stringsList.stream().filter(x->Collections.frequency(stringsList, x)>1)
                 .collect(Collectors.groupingBy
                         (Function.identity(), Collectors.counting())));

        System.out.println(i);

    }

    public void getMax(){

        int [] arr= {1,2,3,4,56};
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .toList();
      int i=  list.stream().max(Integer::compareTo).get();
        System.out.println(i);
    }



    public void countOfEachChar(){

        String str= "AAAABBBCCD";
        List<String> strList= Arrays.stream(str.split("")).collect(Collectors.toList());
        System.out.println(str);
        Map<String, Long> map=strList.stream().filter(x->Collections.frequency(strList, x)>1)
                .collect(Collectors.groupingBy
                        (Function.identity(), Collectors.counting()));
        System.out.print("A"+ map.get("A"));
        System.out.print("B"+ map.get("B"));
        System.out.print("C"+ map.get("C"));
        System.out.print("D"+ map.get("B"));
    }


    public void getDupinSet(){

        List<Integer> integerList= Arrays.asList(1,2,3,3,7,9,9,2,10);
        Set<Integer> dupSet= new HashSet<>(); //2,3,9
      int i=  integerList.stream().filter(s-> !dupSet.add(s)).sorted(Collections.reverseOrder()).skip(1).findFirst().get();
        System.out.println(i);
    }


}
