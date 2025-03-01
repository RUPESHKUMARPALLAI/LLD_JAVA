package LLD_JAVA.TicTacToe.utils;

public record Pair<T, U>(T first, U second) {

    // Not necessary, but included to be consistent with javac's Pair class
    public static <T, U> Pair<T, U> of(T first, U second) {
        return new Pair<>(first, second);
    }
}
