package service.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

public abstract class AbstractProgram {
    @Setter
    @Getter(AccessLevel.PACKAGE)
    private static IScanner staticScanner;
    @Getter(AccessLevel.PACKAGE)
    private IScanner currentScanner;

    public AbstractProgram() {
        staticScanner = null;
    }


    /**
     * this constructor is for unit tests so you can fake user inputs.
     */
    public AbstractProgram(String... project) {
        if (project == null) {
            staticScanner = null;
            return;
        }

        staticScanner = new MockScanner(this, project);
    }

    /**
     * this constructor is for unit tests so you can fake user inputs.
     */
    public AbstractProgram(MockScanner mockScanner) {
        if (mockScanner == null) {
            staticScanner = null;
            return;
        }

        staticScanner = mockScanner;
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
        if (staticScanner == null) {
            currentScanner = new InternalScanner(new Scanner(System.in), this);
            return currentScanner;
        }else {
            return staticScanner;
        }
    }
}
