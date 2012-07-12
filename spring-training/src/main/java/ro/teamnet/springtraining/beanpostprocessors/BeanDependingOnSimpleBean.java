package ro.teamnet.springtraining.beanpostprocessors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Spring training by Gnomix
 * User: iceman
 * Date: 7/12/12
 * Time: 3:00 PM
 * TNI
 */
@Component
public class BeanDependingOnSimpleBean {

    private SingleBean singleBean;

    public BeanDependingOnSimpleBean() {
    }
    @Autowired
    public BeanDependingOnSimpleBean(SingleBean singleBean) {
        this.singleBean = singleBean;
    }


    public SingleBean getSingleBean() {
        return singleBean;
    }

    public void setSingleBean(SingleBean singleBean) {
        this.singleBean = singleBean;
    }
}
