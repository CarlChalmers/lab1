import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkShop<T extends Car> {
    boolean acceptAll = false;
    private int maxCars;
    //private ArrayList<Car> carsIn;
    private ArrayList<T> carsIn;

    WorkShop(int max){
        this.maxCars = max;
    }
    WorkShop(){
        this.acceptAll = true;
    }

    // public void addCar(Car car){
    //     if()
    // }

    public void acceptCar(T car){
        if(carsIn.size() < maxCars || acceptAll){
            carsIn.add(car);
        }
    }

    public void removeCar(T car){
        if(carsIn.contains(car)){
            carsIn.remove(car);
        }else{
            System.out.println("Car is not in ");
        }
    }


}
