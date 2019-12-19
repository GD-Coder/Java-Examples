package dreamscape.code.console;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class Main {

    // == constants ==
    private final static int min = 9;

    // class variables ==
    private static int[] result;
    private static int a = 0;
    private static int b = 1;
    private static int c;

    public static void main(String[] args) {

        // local variables ==
        final int max = 6;

        // == reverse word 1 ==
        System.out.println(reverseWord(splitString("Hello 1 esreveR")));

        // == reverse word 2 ==
        System.out.println(reverseWord2("Hello 2 esreveR"));

        // == fibonacci ==
        System.out.println(Arrays.toString(fibonacci(8)));

        // == fizz buzz ==
        System.out.println(fizzBuzz(rangedArray(min, max)));

        // == is prime ==
        System.out.println(isPrime(max));

        // == Create Context ==
//        ConfigurableApplicationContext context =
//                new AnnotationConfigApplicationContext(GameConfig.class);

        // == Close Context ==
//        context.close();
    }

    // ==> x = (t) => list
    public static List<String> splitString(String text) {
        return Stream.of(text.split(""))
                .map(String::new)
                .collect(Collectors.toList());
    }

    // ==> x = (list) => string
    public static String reverseWord(List<String> letters) {
        StringBuilder result = new StringBuilder();
        int count = letters.size() - 1;
        for(int i = 0; i < letters.size(); i++) {
            result.append(letters.get(count));
            count--;
        }
        return result.toString();
    }

    // ==> x = (w) => string
    public static String reverseWord2(String word) {
        StringBuilder stringBuilder = new StringBuilder(word);
        return stringBuilder.reverse().toString();
    }

    // ==> x = (n) => boolean
    public static boolean isPrime(int number) {
        boolean result = true;
        for(int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    // ==> x = (n) => boolean
    public static boolean fizz(int number) {
        return number % 3 == 0;
    }

    // ==> x = (n) => boolean
    public static boolean buzz(int number) {
        return number % 5 == 0;
    }

    // ==> x = (n) => boolean
    public static boolean fizzBuzz(int number) {
        return number % 3 == 0 && number % 5 == 0;
    }

    // ==> x = (min, max) => []
    public static int[] rangedArray(int minimum, int maximum) {
        return IntStream.range(minimum, maximum + minimum).toArray();
    }

    // ==> x = (r) => string
    public static String fizzBuzz(int[] range) {
        StringBuilder result = new StringBuilder();
        for(int i = min; i <= range.length; i++) {
            if (fizzBuzz(i)) {
                result.append("FizzBuzz ");
            } else if(buzz(i)) {
                result.append("Buzz ");
            } else if(fizz(i)) {
                result.append("Fizz ");
            } else {
                result.append(i).append(" ");
            }
        }
        return result.toString();
    }

    // ==> x = (n) => []
    public static int[] fibonacci(int number) {
        result = new int[number];
        IntStream.range(1, number).forEach(i -> {
            c = a + b;
            a = b;
            b = c;
            result[i] = a;
        });
        return result;
    }
}
