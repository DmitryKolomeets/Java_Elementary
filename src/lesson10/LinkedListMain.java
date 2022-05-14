package lesson10;

import java.util.*;


public class LinkedListMain {

    public static void main(String[] args) {


        List<String> cars = new LinkedList<>();
        List<String> sportCars = new LinkedList<>();


        String str1 = new String("Lotus");
        String str2 = new String("Maserati");
        String str3 = new String("Lamborghini");
        String str4 = new String("Bugatti");
        String str5 = new String("Ferrari");
        String str6 = new String("McLaren");
        String str7 = new String("Pagani");

        cars.add(str1);
        cars.add(str2);
        cars.add(str3);
        cars.add(str4);
        cars.add(str5);
        cars.add(str6);
        cars.add(str7);

        String str8 = new String("BMW");

        cars.add(7,str8);
        sportCars.addAll(cars);

        sportCars.clear();

        cars.contains(str5);

        cars.get(4);

        sportCars.isEmpty();

        cars.remove(1);

        cars.remove(str4);





    }
}




