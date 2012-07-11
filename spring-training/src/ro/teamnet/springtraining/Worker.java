package ro.teamnet.springtraining;

/**
 * Spring training by Gnomix
 * User: iceman
 * Date: 7/11/12
 * Time: 10:32 AM
 * TNI
 */
public interface Worker {

    void doTheShit();

    void doTheShit(String s);

    public static final Worker NO_OP_WORKER =
            new Worker() {
                public void doTheShit() {
                    System.err.println("Not Implemented");
                }

                public void doTheShit(String s) {
                    System.err.println("Not Implemented");
                }
            };
}
