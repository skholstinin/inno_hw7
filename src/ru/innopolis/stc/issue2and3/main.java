package ru.innopolis.stc.issue2and3;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Random;

public class main {
    public static void main(String[] args) {

        Random random = new Random();
        ArrayList<Integer> array = new ArrayList<>();//создаём массив
        for (int i = 0; i < 100; i++) {//заполняем неповторяющимися элементами
            array.add(random.nextInt(100));
        }

        for (Integer i : array) {
            int j = random.nextInt(i + 1);
            int temp = array.get(i);
            array.set(j, array.get(i));
            array.set(i, temp);
        }

        MathInterface mathBox = new MathBox(array);
        ProxyMath proxyMath = new ProxyMath(mathBox);

        MathInterface pmathbox = (MathInterface) Proxy.newProxyInstance(MathInterface.class.getClassLoader(), new Class[]{MathInterface.class}, proxyMath);
        System.out.println("Pi before clear");
        System.out.println(mathBox.getPi());
        pmathbox.clearData();
        System.out.println("Pi after clear");
        System.out.println(pmathbox.getPi());
    }
}
