package ro.teamnet.springtraining.beanpostprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

/**
 * Spring training by Gnomix
 * User: iceman
 * Date: 7/12/12
 * Time: 4:17 PM
 * TNI
 */
@Component
public class OurBeanPostProcessor implements BeanPostProcessor{


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        final Cool cool = AnnotationUtils.findAnnotation(bean.getClass(), Cool.class);
        if (cool != null){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("The bean[" + beanName + " is quite cool");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public static void main(String[] args) {
        final String[] basePackages = new String[]{ComponentScanning.class.getPackage().getName()};
        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(basePackages);
    }
}
