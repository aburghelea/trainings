package ro.teamnet.springtraining.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
        exerciseBeanDefinitionLookupWithOverriding();
        exerciseBeanDeffinitionLookupWithoutOverriding();
    }

    private static void exerciseBeanDeffinitionLookupWithoutOverriding() {
        /*Atitudine de genul "Last one wins"*/
        final ApplicationContext ctx = new ClassPathXmlApplicationContext("capitalist-child-container.xml", "capitalists.xml");
        final TheGreedyCapitalist parrentBean = ctx.getBean("duplicateDefinitionBothInParentAsInChild", TheGreedyCapitalist.class);
        System.out.println(parrentBean);
    }

    private static void exerciseBeanDefinitionLookupWithOverriding() {
        ConfigurableListableBeanFactory parrentFactory =
                BeanFactories.from("capitalists.xml", PresentingBeanFactoryHierarchies.class);
        final ClassPathResource childResource =
                new ClassPathResource("capitalist-child-container.xml", PresentingBeanFactoryHierarchies.class);

        BeanFactory childFactory = new XmlBeanFactory(childResource, parrentFactory);
        final TheGreedyCapitalist parrentBean =
                parrentFactory.getBean("duplicateDefinitionBothInParentAsInChild", TheGreedyCapitalist.class);
        final TheGreedyCapitalist childBean =
                childFactory.getBean("duplicateDefinitionBothInParentAsInChild", TheGreedyCapitalist.class);

        System.out.println(parrentBean);
        System.out.println(childBean);
    }
}
