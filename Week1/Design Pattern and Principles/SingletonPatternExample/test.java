public class test {
    public static void main(String[] args) {
        Logger obj1 = Logger.getInstance();
        obj1.printMessage("First message");

        Logger obj2 = Logger.getInstance();
        obj2.printMessage("Second message");

        if (obj1 == obj2) {
            System.out.println("Only one instance exists");
        }else {
            System.out.println("Multiple instances detected!");
        }
    }
}
