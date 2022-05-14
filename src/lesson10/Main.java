package lesson10;

import java.util.*;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        List<MyArrayListTrain> cars = new ArrayList();
        List<MyArrayListTrain> sportCars = new ArrayList();



        System.out.println();
        System.out.println("init size = " + cars.size());

        System.out.println("collection cars is emty? - " + cars.isEmpty());

        MyArrayListTrain lotus = new MyArrayListTrain("Lotus");
        MyArrayListTrain maserati = new MyArrayListTrain("Maserati");
        MyArrayListTrain lamborghini = new MyArrayListTrain("Lamborghini");
        MyArrayListTrain bugatti = new MyArrayListTrain("Bugatti");
        MyArrayListTrain ferrari = new MyArrayListTrain("Ferrari");
        MyArrayListTrain mcLaren = new MyArrayListTrain("McLaren");
        MyArrayListTrain mazzanti = new MyArrayListTrain("Mazzanti");
        MyArrayListTrain pagani = new MyArrayListTrain("Pagani");
        MyArrayListTrain saleen = new MyArrayListTrain("Saleen");
        MyArrayListTrain porsche = new MyArrayListTrain("Porsche");

        cars.add(lotus);
        cars.add(maserati);
        cars.add(lamborghini);
        cars.add(bugatti);
        cars.add(ferrari);
        cars.add(mcLaren);
        cars.add(mazzanti);
        cars.add(pagani);
        cars.add(saleen);
        cars.add(porsche);

        System.out.println(cars.toString());

        System.out.println(cars.get(3));

        cars.clear();

        System.out.println(cars.toString());

        cars.add(mazzanti);
        cars.add(pagani);
        cars.add(saleen);
        cars.add(0, porsche);

        cars.remove(2);

        cars.remove(mcLaren);

        System.out.println(cars.toString());

        sportCars.add(mazzanti);
        sportCars.add(pagani);
        sportCars.add(saleen);
        sportCars.add(porsche);

        cars.addAll(sportCars);

        System.out.println(cars.isEmpty());
        System.out.println(cars);
        System.out.println(cars.contains(saleen));


        ListIterator<MyArrayListTrain> listIterator = cars.listIterator();


        while (listIterator.hasNext()) {
            Object element = listIterator.next();
            listIterator.set((MyArrayListTrain) element);
        }


        System.out.println("\n" + cars);
        System.out.print("\n arrayList in reverse order: \n \n");


        while (listIterator.hasPrevious()) {
            Object element = listIterator.previous();
            System.out.print(element + " ");
        }

    }
}

