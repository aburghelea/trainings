package ro.teamnet.springtraining;

/**
 * Spring training by Gnomix
 * User: iceman
 * Date: 7/11/12
 * Time: 10:04 AM
 * TNI
 */
public class TheGreedyCapitalist {
    // package protect (without modifier)
    TheLittleDevilDoingTheRealWork chineseDude;

    public TheGreedyCapitalist() {
        // and now it's hardoded again;
        this.chineseDude = new TheLittleDevilDoingTheRealWork();
    }

    public TheGreedyCapitalist(TheLittleDevilDoingTheRealWork chineseDude) {
        this.chineseDude = chineseDude;
    }

    public void doSomethingSchemency() {

        chineseDude.doTheShit("TheGreedyCapitalist.java: The shit");
    }

    public static void main(String[] args) {
        new TheGreedyCapitalist(
                new TheLittleDevilDoingTheRealWork()
        ).doSomethingSchemency();

    }
}
