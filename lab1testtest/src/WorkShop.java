import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkShop {
    private Car[] acceptedCars;
    private int maxCars;
    //private ArrayList<Car> carsIn;
    private ArrayList<AcceptedCar> carsIn;

    WorkShop(Car[] cars, int max){
        this.acceptedCars = cars;
        this.maxCars = max;
    }

    // public void addCar(Car car){
    //     if()
    // }

    public void acceptCar(AcceptedCar car){
        List<Car> acceptedCarsList = Arrays.asList(acceptedCars);
        if(carsIn.size() < maxCars && acceptedCarsList.contains(car)){
            carsIn.add(car);
        }
    }

    public void removeCar(Car car){
        if(carsIn.contains(car)){
            carsIn.remove(car);
        }else{
            System.out.println("Car is not in ");
        }
    }


}
