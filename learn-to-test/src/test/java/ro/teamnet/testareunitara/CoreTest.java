package ro.teamnet.testareunitara;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public abstract class CoreTest {
    protected Log log;

    public CoreTest() {
        log = LogFactoryImpl.getLog(this.getClass());
    }
}
