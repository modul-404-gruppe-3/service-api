package service.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Stack;
import java.util.function.Predicate;

/**
 * class for unit tests.
 * This Scanner will return a given value that is defined with the constructor.
 */
public class MockScanner implements IScanner {
    Stack<String> stack;
    private AbstractProgram program;

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


    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public Double nextDouble(String invalidInputMessage) {
        System.out.println("peek: "+stack.peek());

        if (program instanceof IStopable && stack.peek().equalsIgnoreCase("stop") ||
            stack.peek().equalsIgnoreCase("null")) {
            stack.pop();
            return null;
        }
        return Double.parseDouble(stack.pop());
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public Integer nextInteger(String invalidInputMessage) {
        System.out.println("peek: "+stack.peek());

        if (program instanceof IStopable && stack.peek().equalsIgnoreCase("stop") ||
                stack.peek().equalsIgnoreCase("null")) {
            stack.pop();
            return null;
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public Double nextDouble(String invalidInputMessage, Predicate<Double> validate) {
        System.out.println("peek: "+stack.peek());

        if (program instanceof IStopable && stack.peek().equalsIgnoreCase("stop") ||
                stack.peek().equalsIgnoreCase("null")) {
            stack.pop();
            return null;
        }
        return Double.parseDouble(stack.pop());
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public Integer nextInteger(String invalidInputMessage, Predicate<Integer> validate) {
        System.out.println("peek: "+stack.peek());

        if (program instanceof IStopable && stack.peek().equalsIgnoreCase("stop") ||
                stack.peek().equalsIgnoreCase("null")) {
            stack.pop();
            return null;
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public Integer nextInteger(String invalidInputMessage, Predicate<Integer> validate, String... possibleMatches) {
        System.out.println("peek: "+stack.peek());

        if (program instanceof IStopable && stack.peek().equalsIgnoreCase("stop") ||
                stack.peek().equalsIgnoreCase("null")) {
            stack.pop();
            return null;
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public Integer nextInteger(String invalidInputMessage, String... possibleMatches) {
        System.out.println("peek: "+stack.peek());

        if (program instanceof IStopable && stack.peek().equalsIgnoreCase("stop") ||
            stack.peek().equalsIgnoreCase("null")) {
            stack.pop();
            return null;
        }

        return Integer.parseInt(stack.pop());
    }

    /**
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public String next() {
        System.out.println("peek: "+stack.peek());

        if (program instanceof IStopable && stack.peek().equalsIgnoreCase("stop") ||
            stack.peek().equalsIgnoreCase("null")) {
            stack.pop();
            return null;
        }
        return (String) stack.pop();
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public String next(String invalidInputMessage, Predicate<String> validate) {
        System.out.println("peek: "+stack.peek());

        if (program instanceof IStopable && stack.peek().equalsIgnoreCase("stop") ||
            stack.peek().equalsIgnoreCase("null")) {
            stack.pop();
            return null;
        }
        return stack.pop();
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public String next(String invalidInputMessage, Predicate<String> validate, String... possibleMatches) {
        System.out.println("peek: "+stack.peek());

        if (program instanceof IStopable && stack.peek().equalsIgnoreCase("stop") ||
            stack.peek().equalsIgnoreCase("null")) {
            stack.pop();
            return null;
        }
        return stack.pop();
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public String next(String invalidInputMessage, String... possibleMatches) {
        System.out.println("peek: "+stack.peek());

        if (program instanceof IStopable && stack.peek().equalsIgnoreCase("stop") ||
            stack.peek().equalsIgnoreCase("null")) {
            stack.pop();
            return null;
        }
        return stack.pop();
    }

    /**
     * @param invalidInputMessage message that will be sent when a input is invalid
     * @return the top most value of the stack that is given with the constructor.
     * this object will be cast to the needed type.
     */
    @Override
    public LocalDate getDate(String pattern, String invalidInputMessage) {
        System.out.println("peek: "+stack.peek());

        if (program instanceof IStopable && stack.peek().equalsIgnoreCase("stop") ||
            stack.peek().equalsIgnoreCase("null")) {
            stack.pop();
            return null;
        }

        return LocalDate.parse(stack.pop(), DateTimeFormatter.ofPattern(pattern));
    }
}