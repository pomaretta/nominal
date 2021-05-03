/*

 Nominal Application
 DNI Test Utility

 @author     Carlos Pomares
 Date        2021-05-03

*/

package util;

import org.junit.Assert;
import org.junit.Test;
import util.generators.GenerateDNI;
import util.generators.ValidationException;

public class GenerateDNITest {

    @Test
    public void validateDNI(){
        String dni = "99999999R";
        try {
            Assert.assertTrue(GenerateDNI.validateDNI(dni));
        } catch (ValidationException v){
            Assert.fail();
        }
    }

    @Test
    public void generateDNI(){
        String dni = GenerateDNI.generateDNI();
        System.out.println(dni);
        try {
            Assert.assertTrue(GenerateDNI.validateDNI(dni));
        } catch (ValidationException v){
            Assert.fail();
        }
    }

}
