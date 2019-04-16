package service.api;

import lombok.Getter;

import java.util.Scanner;

public abstract class AbstractProgram {
    @Getter
    public static IScanner scanner;

    public AbstractProgram() {
        scanner = null;
    }


    /**
     * this constructor is for unit tests so you can fake user inputs.
     */
    public AbstractProgram(String... project) {
        if (project == null) {
            scanner = null;
            return;
        }

        scanner = new MockScanner(this, project);
    }

    /**
     * this constructor is for unit tests so you can fake user inputs.
     */
    public AbstractProgram(MockScanner mockScanner) {
        if (mockScanner == null) {
            scanner = null;
            return;
        }

        scanner = mockScanner;
    }

    /**
     * every AbstractProgram needs to have some sort of implementation of this Method. This is the method that is executed
     * in the Main Method.
     */
    public abstract void execute();

    /**
     * This returns a Custom Object of type {@Link InternalScanner} this object is able to handle the Console Scanner
     * better and has some more implementations and handles the implementation of the {@link IStopable}.
     * @return
     */
    public IScanner getScanner() {
        if (scanner == null) {
            return new InternalScanner(new Scanner(System.in), this);
        }else {
            return scanner;
        }
    }
}
