package ro.teamnet.springtraining.beanpostprocessors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring training by Gnomix
 * User: iceman
 * Date: 7/12/12
 * Time: 3:44 PM
 * TNI
 */
@Configuration
//@Import(value = "classpath:/")
public class TheConfig {

    @Bean
    public SimpleBean simpleBean(){

        return null;
    }
}
