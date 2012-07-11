package ro.teamnet.springtraining;

/**
 * Spring training by Gnomix
 * User: iceman
 * Date: 7/11/12
 * Time: 10:06 AM
 * TNI
 */
public class TheLittleDevilDoingTheRealWork implements Worker {

    @Override
    public void doTheShit() {
        System.out.println("iceman: do the shit");
    }

    @Override
    public void doTheShit(String s) {
        System.out.println(s);
    }
}
