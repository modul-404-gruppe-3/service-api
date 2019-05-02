package service.api;

public class Test {
    public static void main(String[] args) {
        T2 program = new T2();
        MockScanner s1 = new MockScanner(program,"1", "2", "3", "4");
        program.setCurrentScanner(s1);

        System.out.println(program.getScanner() instanceof MockScanner);
        System.out.println(program.getScanner() instanceof InternalScanner);

        System.out.println(program.getScanner().next("baum", "1"));

        System.out.println(program.getScanner().next("sads", "2"));
        System.out.println(program.getScanner().next("sads", "3"));
        System.out.println(program.getScanner().next("sads", "4"));


    }
}

class T2 extends AbstractRunContinously {

    @Override
    public void execute() {
        System.out.println("execute");
    }
}
