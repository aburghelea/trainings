package ro.teamnet.springtraining.beanfactory;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 7/11/12
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */
public final class BeanFactories {
    private BeanFactories() {
        throw new AssertionError("This is a utility class. DO NOT INSTANTIATE");
    }

    public static ConfigurableListableBeanFactory from(String configFileName, Class<?> relativeTo) {
        final ClassPathResource resource =
                new ClassPathResource(configFileName, relativeTo);
        ConfigurableListableBeanFactory factory = new XmlBeanFactory(resource);
        factory.preInstantiateSingletons();
        return factory;
    }

    public static ApplicationContext appCtx(String[] configFileName, Class<?> relativeTo) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configFileName, relativeTo);
        return ctx;
    }

}
