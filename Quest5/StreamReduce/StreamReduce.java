import java.util.stream.Stream;

public class StreamReduce {
    public static Integer sumAll(Stream<Integer> s) {
        return s.reduce(0, Integer::sum);
    }

    public static Integer divideAndAddElements(Stream<Integer> s, int divider) {
        if (divider == 0){
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return s.reduce(0, (acc, num) -> acc + (num / divider));
    }
}