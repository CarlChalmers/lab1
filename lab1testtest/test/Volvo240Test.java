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

        volvoTest.gas( 0.5);
        assertTrue(volvoTest.getCurrentSpeed() > 0);
        assertTrue(volvoTest.getCurrentSpeed() <= volvoTest.getEnginePower());

        double previousSpeed = volvoTest.getCurrentSpeed();
        volvoTest.gas(-0.5);
        assertEquals(previousSpeed, volvoTest.getCurrentSpeed(), 0.001);

    }
    @Test
    public void brakeTest() {
        Volvo240 volvoTest = new Volvo240();
        volvoTest.gas(0.8);
        double previousSpeed = volvoTest.getCurrentSpeed();
        volvoTest.brake(0.5);
        assertTrue(volvoTest.getCurrentSpeed() < previousSpeed);
        previousSpeed = volvoTest.getCurrentSpeed();
        volvoTest.brake(-0.5);
        assertEquals(previousSpeed, volvoTest.getCurrentSpeed(), 0.001);
    }
    @Test
    public void workshopTest(){
        Volvo240 volvoTest = new Volvo240();
        Saab95 saabTest = new Saab95();
        WorkShop<Volvo240> volvo240WorkShop = new WorkShop<>(10);
        volvo240WorkShop.acceptCar(volvoTest);
        //volvo240WorkShop.acceptCar(saabTest);

    }
}
