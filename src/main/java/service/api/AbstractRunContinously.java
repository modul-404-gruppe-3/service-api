package service.api;

public abstract class AbstractRunContinously extends AbstractProgram implements IStopable {

    public boolean isStop() {
        if (getStaticScanner() != null) {
            return getStaticScanner().isStop();
        }

        if (getCurrentScanner() == null) {
            return false;
        }

        return getCurrentScanner().isStop();
    }

    /**
     * makes so a program runs until a user enters stop.
     */
    public void run() {
        while (!this.isStop()) {
            this.execute();
        }
    }
}
