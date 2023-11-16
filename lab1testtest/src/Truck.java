import java.awt.*;


public abstract class Truck extends Vehicle {
    private float angle;

    
    public Truck(int doors, int ePower, int cSpeed,Color col, String name){
        super(doors,ePower,cSpeed,col,name);
        this.angle = 0;
        stopEngine();
    }

    public void lowerBed(){
        if(angle < 5){
            angle = 0;
        }else{
            angle -= 5;
        }
    }

    public void raiseBed(){
        if(getCurrentSpeed() == 0){
        if(angle > 65){
            angle = 70;
        }else{
            angle += 5;
        }
        }
    }

    public float getAngle(){
        return this.angle;
    }
    

    
    @Override
    public double speedFactor(){
        if(angle > 0){
            return 0;
        }
        return getEnginePower() * 0.01 * 1;
    }
}
