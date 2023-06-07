package techproed.day08_JUnit;

import org.junit.*;

public class C02_BeforeClassAfterClass {

    /*
    BeforeClass classda en önce çalışan methoddur
    Afterclass class da en son çalışan methoddur

    BeforeClass ve afterclass methodları sadece stat,c methodlar ile çalışır

     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Class da en önce çalışan methoddur");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("classta en son çalışan methodur");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("her test methodundan önce çalışır");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("her test methodundan sonra çalışır");
    }

    @Test
    public void test01() {
        System.out.println("ilk test");
    }

    @Test
    public void test02() {
        System.out.println("test02");
    }
}
