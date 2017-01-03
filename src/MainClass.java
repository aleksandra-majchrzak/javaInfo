import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Mohru on 02.01.2017.
 */
public class MainClass {
    static List<String> strings;

    public static void main(String[] args) {

        strings = new ArrayList<>();
        strings.add("Ala");
        strings.add("ma");
        strings.add("kota,");
        strings.add("kot");
        strings.add("ma");
        strings.add("Ale");

        for (String string : strings) {
            MyFunctionalInterface impl = (str) -> str.length() + 5;

            boolean result = impl.function(string) > 6 ? true : false;
        }

        strings.forEach(str -> System.out.println(str));

        strings.forEach(System.out::println);


        strings.stream().filter(str -> str.length() > 3).map(str -> str.toUpperCase()).forEach(System.out::println);


        List<Integer> list = strings.stream().map(str -> str.length()).collect(Collectors.toList());

        strings.stream().filter(a -> a.length() > 2).reduce(0, (a, b) -> a + b.length(), (a, b) -> a + b);

        Random r = new Random(System.currentTimeMillis());
        Stream.generate(r::nextInt).limit(10).forEach(System.out::println);

        Optional<Integer> integer = Stream.of(1).filter(a -> a > 2).findAny();
        integer.ifPresent(i -> System.out.println(i));


        int a = 8;
        int b = 10;

        int c = a < b ? 3 : 6;
    }
}

@FunctionalInterface
interface MyFunctionalInterface {

    int function(String str);

    default int defaultFunction(int a) {
        return function(String.valueOf(a));
    }
}

interface MyInterface {
    String stringFunction(String begin);

    default String defaultStringFunction(String str) {
        return str.toUpperCase();
    }
}

class MySimpleClass implements MyInterface {

    @Override
    public String stringFunction(String begin) {
        return defaultStringFunction(begin) + " " + defaultStringFunction(begin);
    }
}