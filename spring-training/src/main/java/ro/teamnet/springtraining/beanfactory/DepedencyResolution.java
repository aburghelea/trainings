package ro.teamnet.springtraining.beanfactory;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Spring training by Gnomix
 * User: iceman
 * Date: 7/11/12
 * Time: 3:05 PM
 * TNI
 */
public class DepedencyResolution {

    public static void main(String[] args) {
        // TODO: make this work
        // TODO-RESPONSE: why on earth would you have this kind of circular dependencies (a.k.a "esti prost")
        ConfigurableListableBeanFactory factory = BeanFactories.from("circulaDependencies.xml", DepedencyResolution.class);
        factory.getBean("dependencyOne");
    }

}
