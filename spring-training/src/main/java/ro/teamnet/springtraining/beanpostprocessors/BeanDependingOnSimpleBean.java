package ro.teamnet.springtraining.beanpostprocessors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Spring training by Gnomix
 * User: iceman
 * Date: 7/12/12
 * Time: 3:00 PM
 * TNI
 */
@Component
@Cool
public class BeanDependingOnSimpleBean {

    private SimpleBean simpleBean;

    public BeanDependingOnSimpleBean() {
    }
    @Autowired
    public BeanDependingOnSimpleBean(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }


    public SimpleBean getSimpleBean() {
        return simpleBean;
    }

    public void setSimpleBean(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }
}
