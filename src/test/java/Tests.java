import org.junit.*;

public class Tests {

    @BeforeClass
    public static void setup() {
        System.out.println("@BeforeAll executed");
    }

    @Before
    public void setupThis() {
        System.out.println("@BeforeEach executed");
    }

    //    @Tag("DEV")
    @Test
    public void testCalcOne() {
        System.out.println("======TEST ONE EXECUTED=======");
        Assert.assertEquals(4, 2 + 2);
    }

    //    @Tag("PROD")
//    @Disabled
    @Test
    public void testCalcTwo() {
        System.out.println("======TEST TWO EXECUTED=======");
        Assert.assertEquals(6, 2 + 4);
    }

    @After
    public void tearThis() {
        System.out.println("@AfterEach executed");
    }

    @AfterClass
    public static void tear() {
        System.out.println("@AfterAll executed");
    }
}