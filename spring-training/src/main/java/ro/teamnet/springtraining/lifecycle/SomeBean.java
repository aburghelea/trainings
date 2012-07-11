package ro.teamnet.springtraining.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring training by Gnomix
 * User: iceman
 * Date: 7/11/12
 * Time: 4:38 PM
 * TNI
 */
public class SomeBean implements InitializingBean, DisposableBean{
    
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        if("gogu".equalsIgnoreCase(this.name)){
//            throw new IllegalStateException("Gogu is not allowed as a property");
//        }
    }

    public void doInit() {
        if("gogu".equalsIgnoreCase(this.name)){
            System.out.println("I'm the happiest Gogu ever ....");
        }
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    public void doDestory() {
        System.out.println("on destroy");
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("lifecycle.xml", SomeBean.class);

    }
}
