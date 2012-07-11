package ro.teamnet.springtraining.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import ro.teamnet.springtraining.TheGreedyCapitalist;

/**
 * Spring training by Gnomix
 * User: iceman
 * Date: 7/11/12
 * Time: 11:25 AM
 * TNI
 */
public class ShyIntroToBeanFactory {

    public static void main(String[] args) {
        final ClassPathResource resource = new ClassPathResource("capitalists.xml", ShyIntroToBeanFactory.class);

        BeanFactory beanFactory = new XmlBeanFactory(resource);
        final TheGreedyCapitalist capitalist = beanFactory.getBean("capitalist", TheGreedyCapitalist.class);
        /*
        getBean(Class) -> aduce beanul care e definit UNIC de tipul asta , arunca NoSuchBeanException
        final TheGreedyCapitalist capitalist = beanFactory.getBean(TheGreedyCapitalist.class);
        */
        capitalist.doSomethingSchemency();
    }
}
