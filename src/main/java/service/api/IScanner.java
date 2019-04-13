package service.api;

import java.time.LocalDate;
import java.util.function.Predicate;

public interface IScanner {
     Double nextDouble(String invalidInputMessage);

    Integer nextInteger(String invalidInputMessage);

    Double nextDouble(String invalidInputMessage, Predicate<Double> validate);

    Integer nextInteger(String invalidInputMessage, Predicate<Integer> validate);

    Integer nextInteger(String invalidInputMessage, Predicate<Integer> validate, String... possibleMatches);

    Integer nextInteger(String invalidInputMessage, String... possibleMatches);

    String next();

    String next(String invalidInputMessage, Predicate<String> validate);

    String next(String invalidInputMessage, Predicate<String> validate, String... possibleMatches);

    String next(String invalidInputMessage, String... possibleMatches);

    LocalDate getDate(String pattern, String invalidInputMessage);
}
