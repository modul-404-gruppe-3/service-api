package service.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * this is a implementation if the java.util.Scanner that is capable of getting a date from a pattern,
 * and is also able to handle the implementaiton of {@Link IStopable}.
 */
public class InternalScanner implements IScanner {
    private final Scanner scanner;
    private final AbstractProgram abstractProgram;

    /**
     *
     * @param scanner the scanner object that will be used for all Operations in this Scanner
     * @param abstractProgram the program that will be checked on for the IStopable Interface.
     */
    public InternalScanner(Scanner scanner, AbstractProgram abstractProgram) {
        this.scanner = scanner;
        this.abstractProgram = abstractProgram;
    }

    /**
     * if the p2.api.IExecutable class implements the IStopable Interface is true, "stop" can not be used as a input string because it is used to stop the p2.api.IExecutable.
     * @return the next String that the User put in the Console.
     */
    public String next() {
        String next = scanner.next();
        if (abstractProgram instanceof IStopable) {
            if (next.equalsIgnoreCase("stop")) {
                ((IStopable) this.abstractProgram).stop();
                abstractProgram.setStop(true);
                return null;
            }
        }
        return next;
    }

    /**
     * @param invalidInputMessage message that gets sent if the enterd value is invalid.
     * @return returns the next Double that is entered.
     */
    public Double nextDouble(String invalidInputMessage) {
        while (true) {
            var r = this.next();

            if (r == null) {
                return null;
            }

            try {
                return Double.parseDouble(r);
            }catch (NumberFormatException ex) {
                System.out.println(invalidInputMessage + "\n" + ex.getMessage());
            }
        }
    }

    /**
     * @param invalidInputMessage message that gets sent if the enterd value is invalid.
     * @return returns the next Double that is entered.
     */
    public Integer nextInteger(String invalidInputMessage) {
        while (true) {
            var r = this.next();

            if (r == null) {
                return null;
            }

            try {
                return Integer.parseInt(r);
            }catch (NumberFormatException ex) {
                System.out.println(invalidInputMessage + "\n" + ex.getMessage());
            }
        }
    }

    /**
     * if IStopable is Implemented in the p2.api.IExecutable and the user enters stop the program will continue and return null.
     *
     * @param invalidInputMessage message that gets sent if the enterd value is invalid.
     * @param validate this Method will be run to validate the returned value, if this method returns true the value
     *                 will be returned.
     * @return
     */
    public Double nextDouble(String invalidInputMessage, Predicate<Double> validate) {
        while (true) {
            Double t = nextDouble(invalidInputMessage);
            if (t == null || validate.test(t)) {
                return t;
            }else {
                System.out.println(invalidInputMessage);
            }
        }
    }

    /**
     * @param invalidInputMessage the message that will be sent when the wrong input is sent.
     * @param validate the function that will be called and if this function returns
     *                 true on the user input the value will be returned.
     * @return user input. null of IStopable is implemented and the user types stop.
     */
    public Integer nextInteger(String invalidInputMessage, Predicate<Integer> validate) {
        while (true) {
            Integer t = nextInteger(invalidInputMessage);
            if (t == null || validate.test(t)) {
                return t;
            }else {
                System.out.println(invalidInputMessage);
            }
        }
    }

    /**
     * @param invalidInputMessage the message that will be sent when the wrong input is sent.
     * @param validate the function that will be called and if this function returns
     *                 true on the user input the value will be returned.
     * @param possibleMatches the user input must be in this list.
     * @return user input. null of IStopable is implemented and the user types stop.
     */
    public Integer nextInteger(String invalidInputMessage, Predicate<Integer> validate, String... possibleMatches) {
        while (true) {
            Integer t = nextInteger(invalidInputMessage);
            if (t == null || (validate.test(t)) && (Arrays.asList(possibleMatches).contains(t+""))) {
                return t;
            }else {
                System.out.println(invalidInputMessage);
            }
        }
    }

    /**
     * @param invalidInputMessage the message that will be sent when the wrong input is sent.
     * @param possibleMatches the user input must be in this list.
     * @return user input. null of IStopable is implemented and the user types stop.
     */
    public Integer nextInteger(String invalidInputMessage, String... possibleMatches) {
        while (true) {
            Integer t = nextInteger(invalidInputMessage);
            if (t == null ||  Arrays.asList(possibleMatches).contains(""+t)) {
                return t;
            }else {
                System.out.println(invalidInputMessage);
            }
        }
    }


    /**
     * @param invalidInputMessage the message that will be sent when the wrong input is sent.
     * @param validate the function that will be called and if this function returns
     *                 true on the user input the value will be returned.
     * @return user input. null of IStopable is implemented and the user types stop.
     */
    public String next(String invalidInputMessage, Predicate<String> validate) {
        while (true) {
            String s = next();

            if (s == null || validate.test(s)) {
                return s;
            }else {
                System.out.println(invalidInputMessage);
            }
        }
    }

    /**
     * @param invalidInputMessage the message that will be sent when the wrong input is sent.
     * @param validate the function that will be called and if this function returns
     *                 true on the user input the value will be returned.
     * @param possibleMatches the user input must be in this list.
     * @return user input. null of IStopable is implemented and the user types stop.
     */

    public String next(String invalidInputMessage, Predicate<String> validate, String... possibleMatches) {
        while (true) {
            String s = next(invalidInputMessage, possibleMatches);

            if (s == null) {
                return null;
            }

            if (validate.test(s)) {
                return s;
            }
        }
    }

    /**
     * This Method is used for selection of a specific Option from a List of Options.
     *
     * If the p2.api.IExecutable implements the IStopable Interface stop will also be a valid input, even thoe the method will return null
     *
     * @param invalidInputMessage will be sent if the user does not enter one of the Strings given with possibleMatches.
     * @param possibleMatches the user input will need to match one of this Strings.
     *
     * @return the selected String, null if the p2.api.IExecutable implements IStopable and the input is stop.
     */
    public String next(String invalidInputMessage, String... possibleMatches) {
        while (true) {
            var r = this.next();

            if (r == null) {
                return null;
            }

            if (Arrays.asList(possibleMatches).contains(r)) {
                return r;
            }else {
                System.out.println(invalidInputMessage);
            }
        }
    }


    /**
     * @param pattern the date Pattern
     * @param invalidInputMessage message that gets sent if the entered value is invalid.
     * @return Returns the next entered date that fits the input Pattern
     */
    public LocalDate getDate(String pattern, String invalidInputMessage) {
        while (true) {
            try {
                String next = this.next();

                if (next == null) {
                    return null;
                }

                return LocalDate.parse(
                        next,
                        DateTimeFormatter.ofPattern(pattern));
            }catch (DateTimeParseException ex) {
                System.out.println(invalidInputMessage + "\n" + ex.getMessage());
            }
        }
    }
}
