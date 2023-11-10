import static org.junit.Assert.*;
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
        volvoTest.setColor(Color.red);
        assertEquals(Color.red, volvoTest.getColor());
    }
    @Test
    public void gasTest() {
        Volvo240 volvoTest = new Volvo240();

        volvoTest.gas(0.5);
        assertTrue(volvoTest.getCurrentSpeed() > 0);
        assertTrue(volvoTest.getCurrentSpeed() <= volvoTest.getEnginePower());

        double previousSpeed = volvoTest.getCurrentSpeed();
        volvoTest.gas(-0.5);
        assertEquals(previousSpeed, volvoTest.getCurrentSpeed(), 0.001);
        volvoTest.gas(-10);
        assertEquals(0,volvoTest.getCurrentSpeed(),0.001);
    }

}
