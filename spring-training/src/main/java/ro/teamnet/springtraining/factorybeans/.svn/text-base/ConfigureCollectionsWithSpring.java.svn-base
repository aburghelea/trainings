package ro.teamnet.springtraining.factorybeans;

import org.springframework.context.ApplicationContext;
import ro.teamnet.springtraining.beanfactory.BeanFactories;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 7/12/12
 * Time: 12:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConfigureCollectionsWithSpring {

    public static void main(String[] args) {
        final ApplicationContext ctx = BeanFactories.appCtx(new String[]{"collections-injection.xml"}, ConfigureCollectionsWithSpring.class);

        final ConfigureCollectionsWithSpring bean = ctx.getBean(ConfigureCollectionsWithSpring.class);

        /*System.out.println(Arrays.toString(bean.getStrings().toArray()));

        final Map<String, String> map = bean.getaMap();
        System.out.println(map);*/

        System.out.println(ctx.getBean("&someOtherMap").getClass().getSimpleName());

    }

    private List<String> strings;

    private Map<String, String> aMap;

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public Map<String, String> getaMap() {
        return aMap;
    }

    public void setaMap(Map<String, String> aMap) {
        this.aMap = aMap;
    }
}
