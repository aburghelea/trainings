package ro.teamnet.springtraining;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 7/11/12
 * Time: 10:30 AM
 * To change this template use File | Settings | File Templates.
 */
interface Worker {
    void doTheShit(String bla);

    public static final Worker NO_OP_WORKER =
            new Worker() {
                @Override
                public void doTheShit(String bla) {
                    System.out.println("NADA");
                }
            };
}
