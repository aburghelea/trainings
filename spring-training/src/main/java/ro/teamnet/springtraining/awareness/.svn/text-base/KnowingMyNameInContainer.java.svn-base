package ro.teamnet.springtraining.awareness;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;

import static ro.teamnet.springtraining.beanfactory.BeanFactories.appCtx;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 7/12/12
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class KnowingMyNameInContainer
    implements BeanNameAware{

    private String theWayTheyNamedMe;

    @Override
    public void setBeanName(String name) {
        this.theWayTheyNamedMe = name;
    }

    public String getTheWayTheyNamedMe() {
        return theWayTheyNamedMe;
    }

    public static void main(String[] args) {
        final ApplicationContext from = appCtx(
                new String[]{"bean-name.xml"}, KnowingMyNameInContainer.class);

        final KnowingMyNameInContainer bean = from.getBean(KnowingMyNameInContainer.class);
        System.out.println(bean.getTheWayTheyNamedMe());
    }
}
