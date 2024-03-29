package ro.teamnet.springtraining.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanIsAbstractException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import ro.teamnet.springtraining.TheGreedyCapitalist;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 7/11/12
 * Time: 11:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class ShyIntroToBeanFactory {

    public static void main(String[] args) {
        ConfigurableListableBeanFactory factory =
                BeanFactories.from("capitalists.xml", ShyIntroToBeanFactory.class);
        //final TheGreedyCapitalist capitalist = exercisePrototypeScope(factory);

        exerciseAbstractBeanDefinitions(factory);
        //final TheGreedyCapitalist capitalist = factory.getBean(TheGreedyCapitalist.class);
        //capitalist.doSomethingSchmency();

    }


    private static void exerciseAbstractBeanDefinitions(BeanFactory factory) {
        ;
        try {
            factory.getBean("capitalist2", TheGreedyCapitalist.class);
        } catch (BeanIsAbstractException e) {
            System.out.println("This is expected");
        }

        TheGreedyCapitalist capitalist = factory.getBean("capitalistChild2", TheGreedyCapitalist.class);
        System.out.println(capitalist);
    }

    private static TheGreedyCapitalist exercisePrototypeScope(BeanFactory factory) {
        final TheGreedyCapitalist capitalist = factory.getBean("capitalist", TheGreedyCapitalist.class);
        final TheGreedyCapitalist capitalist2 = factory.getBean("capitalist", TheGreedyCapitalist.class);

        System.out.println(capitalist);
        System.out.println(capitalist2);
        return capitalist;
    }
}

