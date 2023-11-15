import java.awt.Color;
public class AcceptedCar extends Car {
    
    AcceptedCar(int door, double ePower, double cSpeed, Color col, String mName){
        super(door,ePower,cSpeed,col,mName);
    }

    @Override
    public double speedFactor() {
        return 0; // AcceptedCars wont move
    }
}
