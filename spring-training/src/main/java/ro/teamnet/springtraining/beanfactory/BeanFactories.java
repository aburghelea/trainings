package ro.teamnet.springtraining.beanfactory;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public final class BeanFactories {

    private BeanFactories() {
        throw  new AssertionError("This is a utility class. DO NOT INSTANTIATE");
    }

    public static ConfigurableListableBeanFactory from(String configByName, Class<?> relativeTo) {
        final ClassPathResource resource = new ClassPathResource(configByName, relativeTo);
        ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(resource);
        beanFactory.preInstantiateSingletons();
        return beanFactory;
    }
}