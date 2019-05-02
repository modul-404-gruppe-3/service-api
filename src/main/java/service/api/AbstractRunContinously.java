package service.api;

public abstract class AbstractRunContinously extends AbstractProgram implements IStopable {


    public boolean isStop() {
        if (getCurrentScanner() == null) {
            return false;
        }

        return getCurrentScanner().isStop();
    }

    /**
     * makes so a program runs until a user enters stop.
     */
    public void run() {
        System.out.println("start: ("+ this.getClass() +")"+ ((getCurrentScanner() != null) ? getCurrentScanner().isStop() : "null" ));
        while (!this.isStop()) {
            System.out.println("before: ("+ this.getClass()+")"+ ((getCurrentScanner() != null) ? getCurrentScanner().isStop() : "null" ));
            this.execute();
            System.out.println("after: ("+ this.getClass() +")"+ ((getCurrentScanner() != null) ? getCurrentScanner().isStop() : "null" ));
        }
    }
}
