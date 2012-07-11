package ro.teamnet.springtraining;

/**
 * Spring training by Gnomix
 * User: iceman
 * Date: 7/11/12
 * Time: 10:04 AM
 * TNI
 */
public class TheGreedyCapitalist {
    /**
     * package protect (without modifier)
     */
    Worker chineseDude;

    private TheGreedyCapitalist() {
        System.out.println("You're doing setting with me !?");
    }

    public TheGreedyCapitalist(Worker chineseDude) {
        System.out.println("Ctor injection");
        this.chineseDude = chineseDude;
    }

    public void doSomethingSchemency() {

        chineseDude.doTheShit("TheGreedyCapitalist.java: The shit");
    }

    public void setChineseDude(Worker chineseDude) {
        System.out.println("Setter injection");
        this.chineseDude = chineseDude;
    }

/*
    public static void main(String[] args) {
        new TheGreedyCapitalist(
                Worker.NO_OP_WORKER
        ).doSomethingSchemency();

    }
*/
}
