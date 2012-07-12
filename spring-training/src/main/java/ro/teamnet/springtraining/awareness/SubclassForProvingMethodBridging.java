package ro.teamnet.springtraining.awareness;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 7/12/12
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class SubclassForProvingMethodBridging
    extends TheOneUnderTheBridge {

    public Integer getResult(int x) {
        return Integer.valueOf(x);
    }
}
