package prozenda.stepdefinition;

import com.prozenda.Bench;
import io.cucumber.java.*;

public class Steps {
    private static Bench bench;

    @Before
    public static void setup() {
        if(Bench.bench == null) {
            new Bench();
        }
        bench = Bench.bench;
        bench.openBrowserTest();
    }

    @After
    public static void tearDown() {
        bench.closeTest();
        bench = null;
    }
}
