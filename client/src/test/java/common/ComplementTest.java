package common;

import common.payroll.Complement;
import org.junit.Test;
import static org.junit.Assert.*;

public class ComplementTest {
    @Test
    public void testGettersComplemet(){
        Complement c1= new Complement("complement", 55, 22, 22);

        assertEquals("complement", c1.getName());
        assertEquals(55f, c1.getOriginalValue(), 0.05);
        assertEquals(22f, c1.getValuePercentage(), 0.05);
        assertEquals(22f, c1.getValue(), 0.05);
    }
}
