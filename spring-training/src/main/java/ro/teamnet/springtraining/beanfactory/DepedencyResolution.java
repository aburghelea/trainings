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
        ConfigurableListableBeanFactory factory = BeanFactories.from("circulaDependencies.xml", DependencyOne.class);
        factory.getBean("dependencyOne");
    }

}
