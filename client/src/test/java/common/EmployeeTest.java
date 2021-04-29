package common;

import java.sql.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {
    @Test
    public void testGettersEmployee(){
        Employee emp1 = new Employee(1, "passport", "Tofol", "Manolo", "Isaac", "Fernandez",
                "tofol@tofol.com", "602015412", Date.valueOf("2001-01-22") , Date.valueOf("2002-01-22"), 2, true, true, false, 22, 55 );

        assertEquals(1, emp1.getId());
        assertEquals("passport", emp1.getPassport());
        assertEquals("Tofol", emp1.getName());
        assertEquals("Manolo", emp1.getName2());
        assertEquals("Isaac", emp1.getLastName());
        assertEquals("Fernandez", emp1.getLastName2());
        assertEquals("tofol@tofol.com", emp1.getMailAddress());
        assertEquals("602015412", emp1.getPhoneNumber());
        assertEquals(Date.valueOf("2001-01-22"), emp1.getJoinDate());
        assertEquals(Date.valueOf("2002-01-22"), emp1.getExpirationDate());
        assertEquals(2, emp1.getCategory());
        assertTrue(emp1.isActive());
        assertTrue(emp1.isHourly());
        assertFalse(emp1.isApportion());
        assertEquals(22f, emp1.getHiredHours(), 0.05);
        assertEquals(55f, emp1.getIrpf(), 0.05);
    }
}
