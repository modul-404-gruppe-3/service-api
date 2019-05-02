package service.api;

public abstract class AbstractRunContinously extends AbstractProgram implements IStopable {
    /**
     * makes so a program runs until a user enters stop.
     */
    public void run() {
        while (!this.isStop()) {
            this.execute();
        }
        this.setStop(false);
    }
}
