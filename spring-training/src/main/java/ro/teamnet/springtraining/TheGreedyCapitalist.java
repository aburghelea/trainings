package ro.teamnet.springtraining;

/**
 * Spring training by Gnomix
 * User: iceman
 * Date: 7/11/12
 * Time: 10:04 AM
 * TNI
 */
public class TheGreedyCapitalist {
    public static final String DEFAULT = "USA";
    /**
     * package protect (without modifier)
     */
    Worker chineseDude;

    private String country = DEFAULT;

    private TheGreedyCapitalist() {
    }

    public TheGreedyCapitalist(Worker chineseDude) {
        this.chineseDude = chineseDude;
    }

    public void doSomethingSchemency() {
        chineseDude.doTheShit("TheGreedyCapitalist.java: The shit");
    }

    public void setChineseDude(Worker chineseDude) {
        this.chineseDude = chineseDude;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "TheGreedyCapitalist{" +
                " from country='" + country + '\'' +
                '}';
    }

    /*
        public static void main(String[] args) {
            new TheGreedyCapitalist(
                    Worker.NO_OP_WORKER
            ).doSomethingSchemency();

        }
    */
}
