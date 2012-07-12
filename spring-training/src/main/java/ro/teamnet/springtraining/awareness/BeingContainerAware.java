package ro.teamnet.springtraining.awareness;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 7/12/12
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class BeingContainerAware implements ApplicationContextAware {

    ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;//To change body of implemented methods use File | Settings | File Templates.
    }

    public static void main(String[] args) {

    }
}
