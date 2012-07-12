package ro.teamnet.springtraining.beanpostprocessors;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring training by Gnomix
 * User: iceman
 * Date: 7/12/12
 * Time: 2:49 PM
 * TNI
 */
public class ComponentScanning {

    public static void main(String[] args) {
        programmaticAnnotationConfig();

        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-scanning.xml", ComponentScanning.class);
        try {
            ctx.getBean("gogu");
        } catch (BeansException e) {
            System.out.println("TI-a facut figura AppCtx");
        }
    }

    private static void programmaticAnnotationConfig() {
        final String[] basePackages = new String[]{ComponentScanning.class.getPackage().getName()};
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(basePackages);
        beanAcquiringByNameAndType(ctx);
        final BeanDependingOnSimpleBean bean = ctx.getBean(BeanDependingOnSimpleBean.class);
        System.out.println(bean.getSingleBean());
    }

    private static void beanAcquiringByNameAndType(AnnotationConfigApplicationContext ctx) {
        try {
            ctx.getBean("gogu");
            ctx.getBean(SingleBean.class);
        } catch (BeansException e) {
            System.out.println("This should be ok for now");
        }
    }
}
                              