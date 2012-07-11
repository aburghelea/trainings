package ro.teamnet.springtraining.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import ro.teamnet.springtraining.TheGreedyCapitalist;

/**
 * Spring training by Gnomix
 * User: iceman
 * Date: 7/11/12
 * Time: 3:30 PM
 * TNI
 */
public class PresentingBeanFactoryHierarchies {
    public static void main(String[] args) {

        ConfigurableListableBeanFactory parrentFactory =
                BeanFactories.from("capitalists.xml", PresentingBeanFactoryHierarchies.class);
        final ClassPathResource childResource =
                new ClassPathResource("capitalist-child-container.xml", PresentingBeanFactoryHierarchies.class);

        BeanFactory childFactory = new XmlBeanFactory(childResource, parrentFactory);
        final TheGreedyCapitalist parrentBean = parrentFactory.getBean("duplicateDefinitionBothInParentAsInChild", TheGreedyCapitalist.class);
        final TheGreedyCapitalist childBean = childFactory.getBean("duplicateDefinitionBothInParentAsInChild", TheGreedyCapitalist.class);

        System.out.println(parrentBean);
        System.out.println(childBean);
    }
}
