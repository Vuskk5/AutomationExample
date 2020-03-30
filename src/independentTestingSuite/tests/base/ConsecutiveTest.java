package independentTestingSuite.tests.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class ConsecutiveTest extends BaseTest {
    @Override
    @BeforeTest
    public void initialize() {
        super.initialize();
    }

    @Override
    @AfterTest
    public void terminate() {
        super.terminate();
    }
}
