import java.awt.*;


public abstract class Car implements Movable{

    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public double posX;
    public double posY;
    public double dir;


    public Car(int door, double ePower, double cSpeed, Color col, String mName){
        this.nrDoors = door;
        this.enginePower = ePower;
        this.currentSpeed = cSpeed;
        this.color = col;
        this.modelName = mName;

        posX = 0;
        posY = 0;
        dir = 0;
    }

    public String getModelName(){
        return modelName;
    }
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        if(currentSpeed > enginePower){
            currentSpeed = enginePower;
        }
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        if(currentSpeed < 0){
            currentSpeed = 0;
        }
    }

    public abstract double speedFactor();

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if(amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if(amount >= 0 && amount <= 1){
            decrementSpeed(amount);
        }
    }
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public void move(){
        double deltaX = currentSpeed * Math.cos(dir);
        double deltaY = currentSpeed * Math.sin(dir);
        posX += deltaX;
        posY += deltaY;
    }

    public void turnLeft(){
        dir -= 10;
    }

    public void turnRight(){
        dir += 10;
    }

    public static void main(String[] args) {
        Saab95 saab = new Saab95();
        System.out.println(saab.currentSpeed);
        saab.gas(-10);
        System.out.println(saab.currentSpeed);

    }
}
