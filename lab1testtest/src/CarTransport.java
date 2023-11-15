import java.awt.Color;
import java.util.Stack;

public class CarTransport extends Truck{
    private Stack<Car> currentLoad;
    private boolean bedDown;
    
    public CarTransport(){
        super(2,250,0,Color.red,"Transport");
        stopEngine();
    }

    public void unloadCar(Car car){
        if(bedDown){
            currentLoad.pop();
        }else{
            System.out.println("Bed not down");
        }
    }

    public void loadCar(Car car){
        if(this.bedDown && isClose(car)){
            currentLoad.add(car);
        }else{
            System.out.println("Bed is not down or car too far away");
        }
    }

    public boolean isClose(Car car){
        if(Math.abs(this.getX() - car.getX()) < 5  && Math.abs(this.getY() - car.getY()) < 5){
            return true;
        }
        return false;
    }

    @Override
    public void raiseBed(){
        this.bedDown = false;
    }

    @Override
    public void lowerBed(){
        if(currentSpeed == 0){
            this.bedDown = true;
        }
    }

    @Override
    public void move(){
        double deltaX = currentSpeed * Math.cos(this.getDir());
        double deltaY = currentSpeed * Math.sin(this.getDir());
        double xPos = this.getX() + deltaX;
        double yPos = this.getY() + deltaY;
        this.setX(xPos);
        this.setY(yPos);

        for(Car car:currentLoad){
            car.setX(xPos);
            car.setY(yPos);
        }
    }

}
