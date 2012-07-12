package ro.teamnet.springtraining;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 7/11/12
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class TheGreedyCapitalist {

    public static final String DEFAULT_COUNTRY = "USA";
    Worker chineseDude;

    private String country = DEFAULT_COUNTRY;

    public void setCountry(String country) {
        this.country = country;
    }

    private TheGreedyCapitalist() {
    }

    public TheGreedyCapitalist(Worker chineseDude) {
        this.chineseDude = chineseDude;
    }

    public void setChineseDude(Worker chineseDude) {
        this.chineseDude = chineseDude;
    }

    public void doSomethingSchmency() {

        chineseDude.doTheShit("The Shit");
    }

    @Override
    public String toString() {
        return "TheGreedyCapitalist{" +
                " from country='" + country + '\'' +
                '}';
    }

    /*public static void main(String[] args) {
        new TheGreedyCapitalist(Worker.NO_OP_WORKER).doSomethingSchmency();
    }*/
}
