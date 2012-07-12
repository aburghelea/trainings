package ro.teamnet.springtraining.beanfactory;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 7/11/12
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class DependencyResolution {
    public static void main(String[] args) {
        final ClassPathResource resource =
                new ClassPathResource("circularDependencies.xml", DependencyOne.class);

        ConfigurableListableBeanFactory factory = new XmlBeanFactory(resource);
        factory.preInstantiateSingletons();

        factory.getBean("dependencyTwo");
    }
}
