package ro.teamnet.springtraining.beanfactory;

/**
 * Spring training by Gnomix
 * User: iceman
 * Date: 7/11/12
 * Time: 2:59 PM
 * TNI
 */
public class DependencyTwo {

    private DependencyOne dependencyOne;

    public void setDependencyOne(DependencyOne dependencyOne) {
        this.dependencyOne = dependencyOne;
    }
}
