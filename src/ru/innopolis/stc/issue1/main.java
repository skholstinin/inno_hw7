package ru.innopolis.stc.issue1;

import java.util.ArrayList;
import java.util.Random;

public class main {
    public static void main(String[] args) {

        Random random = new Random();
        ArrayList<Integer> myArray = new ArrayList<>();//создаём массив
        for (int i = 0; i < 100; i++) {//заполняем неповторяющимися элементами
            myArray.add(random.nextInt(100));
        }


        for (Integer i : myArray) {//перемешиваем массив
            int j = random.nextInt(i + 1);
            int temp = myArray.get(i);
            myArray.set(j, myArray.get(i));
            myArray.set(i, temp);
            System.out.println(myArray.get(j));
        }
        System.out.println("Proxy");
        MathInterface pmathBox = new MathBox();
        pmathBox.setNumberTreeSet(myArray);
        System.out.println(pmathBox.summator());

        System.out.println("No Proxy");
        MathBox mathBox = new MathBox();
        mathBox.setNumberTreeSet(myArray);
        System.out.println(mathBox.summator());


    }
}
