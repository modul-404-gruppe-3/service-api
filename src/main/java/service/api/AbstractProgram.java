package service.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

public abstract class AbstractProgram {
    @Getter(AccessLevel.PACKAGE)
    @Setter
    private static IScanner currentScanner;

    public AbstractProgram() {}

    /**
     * this constructor is for unit tests so you can fake user inputs.
     */
    public AbstractProgram(String... strings) {
        if (strings == null) {
            currentScanner = null;
            return;
        }

        currentScanner = new MockScanner(this, strings);
    }

    /**
     * this constructor is for unit tests so you can fake user inputs.
     */
    public AbstractProgram(MockScanner mockScanner) {
        if (mockScanner == null) {
            currentScanner = null;
            return;
        }

        currentScanner = mockScanner;
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
        if (currentScanner == null || currentScanner instanceof InternalScanner) {
            currentScanner = new InternalScanner(new Scanner(System.in), this);
            return currentScanner;
        }else {
            currentScanner = new MockScanner((MockScanner)currentScanner);
            return currentScanner;
        }
    }
}
