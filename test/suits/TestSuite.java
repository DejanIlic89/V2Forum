package suits;

import baseball.TestBaseball;
import comparison.TestTv;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import profile.TestProfile;

/**
 *
 * @author Dejan
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({TestProfile.class, TestBaseball.class, TestTv.class})
public class TestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
