package ro.teamnet.springtraining.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanIsAbstractException;
import ro.teamnet.springtraining.TheGreedyCapitalist;

/**
 * Spring training by Gnomix
 * User: iceman
 * Date: 7/11/12
 * Time: 11:25 AM
 * TNI
 */
@SuppressWarnings("deprecation")
public class ShyIntroToBeanFactory {

    public static void main(String[] args) {
        BeanFactory beanFactory = BeanFactories.from("capitalists.xml", ShyIntroToBeanFactory.class);

        exercisePrototypeScope(beanFactory);
        exerciseMixInstantiation(beanFactory);
        exerciseAbstractBeanDefinition(beanFactory);


        /*
        getBean(Class) -> aduce beanul care e definit UNIC de tipul asta , arunca NoSuchBeanException
        final TheGreedyCapitalist capitalist = beanFactory.getBean(TheGreedyCapitalist.class);
        */

        /*capitalist.doSomethingSchemency();*/
    }

    private static void exerciseAbstractBeanDefinition(BeanFactory beanFactory) {
        System.out.println("=== Abstract Bean Defintion ===");
        try {
            beanFactory.getBean("capitalist_abstract", TheGreedyCapitalist.class);
        } catch (BeanIsAbstractException e) {
            System.out.println("This is expected, it's abstract isn't it ?");
        }

        TheGreedyCapitalist capitalist = beanFactory.getBean("capitalist_concret", TheGreedyCapitalist.class);
        System.out.println(capitalist);


    }

    private static void exerciseMixInstantiation(BeanFactory beanFactory) {
        System.out.println("=== Mix Instantiation Example ===");
        final TheGreedyCapitalist capitalist_with_setter = beanFactory.getBean("capitalist_mix", TheGreedyCapitalist.class);
        capitalist_with_setter.doSomethingSchemency();
    }

    private static void exercisePrototypeScope(BeanFactory beanFactory) {
        System.out.println("=== Prototype Scope Example ===");
        final TheGreedyCapitalist capitalist = beanFactory.getBean("capitalist", TheGreedyCapitalist.class);
        final TheGreedyCapitalist capitalist2 = beanFactory.getBean("capitalist", TheGreedyCapitalist.class);
        System.out.println(capitalist);
        System.out.println(capitalist2);
    }
}
