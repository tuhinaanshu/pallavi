import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solutions {

    void reverse(){
        String original = "Java is bad";
        //dab si avaJ
        String reversed = original.chars()  // Convert to stream
                .mapToObj(c -> (char) c)        // Convert to Character stream
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);
        System.out.println(reversed);

        //avaJ si dab
        String reversedSentence =  Pattern.compile(" +").splitAsStream(original)
                    .map(word->new StringBuilder(word).reverse())
                    .collect(Collectors.joining(" "));
        System.out.println(reversedSentence);

        //bad is Java
        System.out.println(Arrays.stream(original.split("(?=\\W)|(?<=\\W)"))
                .reduce("", (acc, s) -> s + acc).toString());

    }

    void duplicate(){
        String input = "JavaJavaEE";

        // convert string into stream
        Map< Character, Long > result = input
                .chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        result.forEach((k, v) -> {
            if (v > 1) {
                System.out.println(k + " : " + v);
            }
        });

    }

    void letterCount(){
        String input = "india";
        System.out.println( input.chars().filter(ch -> ch == 'i').count());
    }

    void anagram(){
        /*ASTRONOMER -> MOON STARER
        ELEVEN PLUS TWO -> TWELVE PLUS ONE
        DORMITORY -> DIRTY ROOM*/
        String word1 = "DORMITORY";
        String word2 = "DIRTYROOM";

        List<String> listWord1 = new ArrayList<>(Arrays.asList(word1.split("")));
        List<String> listWord2 = new ArrayList<>(Arrays.asList(word2.split("")));

        Collections.sort(listWord1);
        Collections.sort(listWord2);

        word1 = String.join("", listWord1);
        word2 = String.join("", listWord2);

        //return listWord1.equals(listWord2);
        System.out.println("Is Anagram : "+ word1.equals(word2));
    }

}


