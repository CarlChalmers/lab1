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
    @Test
    public void TruckTest(){
        //Vinkeln på flaket kan inte vara lägre än 0 eller högre än 70.
        Scania scaniaTest = new Scania();

        assertTrue(scaniaTest.getAngle() <= 70 && scaniaTest.getAngle()>=0);
        for (int i = 0; i < 100; i++) {
            scaniaTest.raiseBed();
        }
        assertTrue(scaniaTest.getAngle() <= 70 && scaniaTest.getAngle()>=0);
        for (int i = 0; i < 110; i++) {
            scaniaTest.lowerBed();
        }
        assertTrue(scaniaTest.getAngle() <= 70 && scaniaTest.getAngle()>=0);


        //Det är bara om lastbilen står stilla som flaket får ha en annan vinkel än 0.
        // Flaket ska inte kunna höjas om lastbilen är i rörelse; och lastbilen
        // ska inte kunna köra om flaket är uppfällt.
        scaniaTest.gas(0.5);
        assertTrue(scaniaTest.getCurrentSpeed() >0);
        assertTrue(scaniaTest.getAngle() == 0);
        scaniaTest.raiseBed();
        assertTrue(scaniaTest.getAngle() == 0);
        scaniaTest.brake(0.5);
        assertTrue(scaniaTest.getCurrentSpeed() == 0);
        scaniaTest.raiseBed();
        scaniaTest.gas(0.5);
        assertFalse(scaniaTest.getCurrentSpeed()> 0);

    }
    @Test
    public void carTransportTest(){
        //Biltransportens ramp har endast två lägen, uppe eller nere.
        //Rampen kan endast vara nere om biltransporten står stilla.

        //Bilar kan endast lastas om rampen är nere, och de befinner sig rimligt nära biltransporten
        // (gör ett eget antagande, de exakta detaljerna är inte viktiga).


        //Bilar kan endast lossas om rampen är nere. De bör då hamna rimligt nära biltransporten.
        //Bilar kan endast lossas i omvänd ordning från hur de lastades, dvs den sista bilen som
        // lastades måste vara först att lossas (first-in-last-out).

        //Biltransporten ska inte kunna lasta på en annan biltransport.
        //Under det att en bil är lastad på biltransporten ska dess position i världen alltid vara
        // densamma som biltransportens position.
        Volvo240 volvoTest1 = new Volvo240();
        CarTransport carTransportTest = new CarTransport();

        carTransportTest.lowerBed();
        assertTrue(carTransportTest.getBedDown());
        carTransportTest.loadCar(volvoTest1);
        assertTrue(carTransportTest.getCurrentLoad().peek() == volvoTest1);
        assertTrue(carTransportTest.unloadCar() == volvoTest1);
        volvoTest1.setX(100);
        carTransportTest.loadCar(volvoTest1);
        assertTrue(carTransportTest.getCurrentLoad().isEmpty());
        CarTransport carTransportTest1 = new CarTransport();
        //carTransportTest.loadCar(carTransportTest1);
        carTransportTest.lowerBed();
        Volvo240 volvoTest2 = new Volvo240();

        carTransportTest.loadCar(volvoTest2);
        carTransportTest.gas(0.5);
        carTransportTest.move();
        assertTrue(carTransportTest.getX() == volvoTest2.getX());









    }
}
