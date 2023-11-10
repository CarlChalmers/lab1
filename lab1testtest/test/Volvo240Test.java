import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.awt.*;


public class Volvo240Test {
    @Test
    public void constructorTest(){
        Volvo240 volvoTest = new Volvo240();
        assertEquals("Volvo240", volvoTest.getModelName());
        assertEquals(100.0, volvoTest.getEnginePower(),0.001);
        assertEquals(4, volvoTest.getNrDoors() );
        assertEquals(0, volvoTest.getCurrentSpeed(),0.001);
        assertEquals(Color.black, volvoTest.getColor());
    }
}
