package service.api;

import java.time.LocalDate;
import java.util.Stack;
import java.util.function.Predicate;

public class MockScanner implements IScanner {
    Stack<Object> stack;

    public MockScanner(Object... objects) {
        this.stack = new Stack<>();
        for (int i = objects.length - 1; i >= 0; i--) {
            if (objects[i] == null) {
                this.stack.push(new NullObject());
            }else {
                this.stack.push(objects[i]);
            }
        }
    }

    @Override
    public Double nextDouble(String invalidInputMessage) {
        if (stack.peek() instanceof NullObject) {
            stack.pop();
            return null;
        }
        return (Double) stack.pop();
    }

    @Override
    public Integer nextInteger(String invalidInputMessage) {
        if (stack.peek() instanceof NullObject) {
            stack.pop();
            return null;
        }
        return (Integer) stack.pop();
    }

    @Override
    public Double nextDouble(String invalidInputMessage, Predicate<Double> validate) {
        if (stack.peek() instanceof NullObject) {
            stack.pop();
            return null;
        }
        return (Double) stack.pop();
    }

    @Override
    public Integer nextInteger(String invalidInputMessage, Predicate<Integer> validate) {
        if (stack.peek() instanceof NullObject) {
            stack.pop();
            return null;
        }
        return (Integer) stack.pop();
    }

    @Override
    public Integer nextInteger(String invalidInputMessage, Predicate<Integer> validate, String... possibleMatches) {
        if (stack.peek() instanceof NullObject) {
            stack.pop();
            return null;
        }
        return (Integer) stack.pop();
    }

    @Override
    public Integer nextInteger(String invalidInputMessage, String... possibleMatches) {
        if (stack.peek() instanceof NullObject) {
            stack.pop();
            return null;
        }
        return (Integer) stack.pop();
    }

    @Override
    public String next() {
        if (stack.peek() instanceof NullObject) {
            stack.pop();
            return null;
        }
        return (String) stack.pop();
    }

    @Override
    public String next(String invalidInputMessage, Predicate<String> validate) {
        if (stack.peek() instanceof NullObject) {
            stack.pop();
            return null;
        }
        return (String) stack.pop();
    }

    @Override
    public String next(String invalidInputMessage, Predicate<String> validate, String... possibleMatches) {
        if (stack.peek() instanceof NullObject) {
            stack.pop();
            return null;
        }
        return (String) stack.pop();
    }

    @Override
    public String next(String invalidInputMessage, String... possibleMatches) {
        if (stack.peek() instanceof NullObject) {
            stack.pop();
            return null;
        }
        return (String) stack.pop();
    }

    @Override
    public LocalDate getDate(String pattern, String invalidInputMessage) {
        if (stack.peek() instanceof NullObject) {
            stack.pop();
            return null;
        }
        return (LocalDate) stack.pop();
    }
    private class NullObject {
    }

}
