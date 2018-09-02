package ru.innopolis.stc.issue2and3;

import java.util.*;

@Logged
public class MathBox implements MathInterface {

    private SortedSet<Integer> numberTreeSet = new TreeSet<>();
    private double pi = 3.141592653589793238462643;


    public MathBox(ArrayList<Integer> array) {
        numberTreeSet.addAll(array);
    }

    @Override
    @ClearData
    public void clearData() {

    }

    @Override
    public double getPi() {
        return pi;
    }

    @Override
    public void addItem(Integer item) {
        numberTreeSet.add(item);
    }

    @Override
    public int summator() {
        Iterator<Integer> iterator = numberTreeSet.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum;
    }

    @Override
    public void searchAndRemoveItem(Integer item) {
        numberTreeSet.remove(item);
    }

    @Override
    public List splitter(int divider) {
        ArrayList<Integer> localList = new ArrayList();
        for (Integer s : numberTreeSet) {
            localList.add(s / divider);
        }
        return localList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(numberTreeSet, mathBox.numberTreeSet);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "MathBox{" +
                ", myTreeSet=" + numberTreeSet +
                '}';
    }
}
