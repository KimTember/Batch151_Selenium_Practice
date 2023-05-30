import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JUnitTest01 {

    @Test
    public void test01(){
        assertEquals(1,1);//bu methodun parantez içindeki parametreleri eşitse pass olur, değilse fail olur

        assertTrue(true);//bu methodun parantez içi true ise pass olur, değilse fail olur

    }
}
