package ro.teamnet.springtraining.beanpostprocessors;

import org.springframework.stereotype.Component;

/**
 * Spring training by Gnomix
 * User: iceman
 * Date: 7/12/12
 * Time: 2:55 PM
 * TNI
 */
@Component("gogu")
public class SingleBean {
    
    String s;

    public void setS(String s) {
        this.s = s;
    }
}
