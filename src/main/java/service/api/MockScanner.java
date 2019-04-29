package service.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Stack;
import java.util.function.Predicate;

/**
 * class for unit tests.
 * This Scanner will return a given value that is defined with the constructor.
 */
public class MockScanner implements IScanner {
    Stack<String> stack;
    private AbstractProgram program;
    private boolean isStop = false;

    /**
     *
     * @param program for the IStopable implementation needed so it can return null of the user enters stop
     * @param objects the objects that will be used to fake the user input.
     * this object will be cast to the needed type.
     */
    public MockScanner(AbstractProgram program, String... objects) {
        this.program = program;
        this.stack = new Stack<>();
        for (int i = objects.length - 1; i >= 0; i--) {
            if (objects[i] == null) {
                this.stack.push("null");
            }else {
                this.stack.push(objects[i]);
            }
        }
    }

    @Override
    public boolean isStop() {
        return isStop;
    }

    /**
     *
     * @return the first item on the Stack. Null of program implements IStopable and user enters stop or
     * if the content of the String is "null".
     */
    private String takeFromStack() {
        System.out.println("peek: "+stack.peek());

        String pop = stack.pop();
        if (program instanceof IStopable && pop.equalsIgnoreCase("stop") ||
                pop.equalsIgnoreCase("null")) {
            if (pop.equalsIgnoreCase("stop")) {
                isStop = true;
            }

            return null;
        }
        return pop;
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public Double nextDouble(String invalidInputMessage) {
        String item = takeFromStack();
        try {
            return (item != null) ? Double.parseDouble(item) : null;
        }catch (Exception ex) {
            throw new InvalidScannerOutputException(item, invalidInputMessage);
        }
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public Integer nextInteger(String invalidInputMessage) {
        String item = takeFromStack();
        try {
            return (item != null) ? Integer.parseInt(item) : null;
        } catch (NumberFormatException e) {
            throw new InvalidScannerOutputException(item, invalidInputMessage);
        }
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public Double nextDouble(String invalidInputMessage, Predicate<Double> validate) {
        String item = takeFromStack();

        try {
            if ((item != null)) {
                double v = Double.parseDouble(item);

                if (validate.test(v)) {
                    return v;
                }else {
                    throw new InvalidScannerOutputException(""+v, invalidInputMessage);
                }
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            throw new InvalidScannerOutputException(item, invalidInputMessage);
        }
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public Integer nextInteger(String invalidInputMessage, Predicate<Integer> validate) {
        String item = takeFromStack();
        if ((item != null)) {
            int i = Integer.parseInt(item);

            if (validate.test(i)) {
                return i;
            }else {
                throw new InvalidScannerOutputException(""+i, invalidInputMessage);
            }
        } else {
            return null;
        }
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public Integer nextInteger(String invalidInputMessage, Predicate<Integer> validate, String... possibleMatches) {
        String item = takeFromStack();
        if ((item != null)) {
            int i = Integer.parseInt(item);

            if (validate.test(i) && Arrays.asList(possibleMatches).contains(i+"")) {
                return i;
            }else {
                throw new InvalidScannerOutputException(i+"", invalidInputMessage);
            }
        } else {
            return null;
        }
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public Integer nextInteger(String invalidInputMessage, String... possibleMatches) {
        String item = takeFromStack();
        if ((item != null)) {
            int i = Integer.parseInt(item);

            if (Arrays.asList(possibleMatches).contains(i+"")) {
                return i;
            }else {
                throw new InvalidScannerOutputException(i+"", invalidInputMessage);
            }
        } else {
            return null;
        }
    }

    /**
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public String next() {
        return takeFromStack();
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public String next(String invalidInputMessage, Predicate<String> validate) {
        String item = takeFromStack();

        if (item == null) {
            return null;
        }

        if (validate.test(item)) {
            return item;
        }else {
            throw new InvalidScannerOutputException(item, invalidInputMessage);
        }
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public String next(String invalidInputMessage, Predicate<String> validate, String... possibleMatches) {
        String item = takeFromStack();

        if (item == null) {
            return null;
        }

        if (validate.test(item) && Arrays.asList(possibleMatches).contains(item)) {
            return item;
        }else {
            throw new InvalidScannerOutputException(item, invalidInputMessage);
        }
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public String next(String invalidInputMessage, String... possibleMatches) {
        String item = takeFromStack();

        if (item == null) {
            return null;
        }

        if (Arrays.asList(possibleMatches).contains(item)) {
            return item;
        }else {
            throw new InvalidScannerOutputException(item, invalidInputMessage);
        }
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public LocalDate getDate(String pattern, String invalidInputMessage) {
        String item = takeFromStack();


        if ((item != null)) {
            try {
                return LocalDate.parse(item, DateTimeFormatter.ofPattern(pattern));
            }catch (Exception ex) {
                throw new InvalidScannerOutputException(item, invalidInputMessage);
            }
        } else {
            return null;
        }
    }
}