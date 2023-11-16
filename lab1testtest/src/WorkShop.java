import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkShop<T extends Car> {
    private Car[] acceptedCars;
    boolean acceptAll = false;
    private int maxCars;
    //private ArrayList<Car> carsIn;
    private ArrayList<T> carsIn;

    WorkShop(Car[] cars, int max){
        this.acceptedCars = cars;
        this.maxCars = max;
    }
    WorkShop(int max){
        this.acceptAll = true;
        this.maxCars = max;
    }

    // public void addCar(Car car){
    //     if()
    // }

    public void acceptCar(T car){
        List<Car> acceptedCarsList = Arrays.asList(acceptedCars);
        if(carsIn.size() < maxCars && (acceptedCarsList.contains(car)|| acceptAll)){
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
